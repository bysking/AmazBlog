package com.amzblog.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.AdminDao;
import com.amzblog.dao.UserDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.User;

public class UserDaoImpl extends BaseHibernateDAO implements UserDao {

	//-------------------------------------------
	// ����
	//-------------------------------------------
	
	//����Log�����������������Ϣ
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	//��������(��������Զ�Ӧ)
	public static final String USERNAME = "username";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_NICKNAME = "userNickname";
	public static final String USER_SEX = "userSex";
	public static final String USER_AGE = "userAge";
	public static final String USER_SELFIE = "userSelfie";
	public static final String USER_EMAIL_ADDR = "userEmailAddr";
	public static final String USER_BLOG_ADDR = "userBlogAddr";
	public static final String USER_WECHAT = "userWechat";
	public static final String USER_QQ = "userQq";
	public static final String USER_PHONE = "userPhone";

	//����Transaction
	Transaction tx;
	
	//����ʵ������
	private static UserDao instance;
	//��ȡUserDaoʵ��
	public static final UserDao getInstance(){
		if(instance == null) {
			try {
				instance = new UserDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	
	//-------------------------------------------
	// UserDao�ӿڷ���ʵ��
	//-------------------------------------------
	
	/**
	 * ͨ��userId����User�������ڷ���User�����򷵻�null
	 * @param int
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User find(int userId) {

		return findById(userId);
	}
	
	
	/**
	 * ͨ��userName����User�������ڷ���User�����򷵻�null
	 * @param String
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User find(String userName) {

		return findByUsername(userName);
	}
	
	
	/**
	 * ��¼ģ�飺ͨ��userName��userPassword����User�������ڷ���User�����򷵻�null
	 * @param String, String
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User login(String userName, String userPassword) {

		return findByUsernameAndPassword(userName, userPassword);
	}
	
	
	/**
	 * ����User,��user���������ظ����
	 * @param User
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean add(User user) {
		
		tx = getSession().beginTransaction();
		try{
			save(user);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}

	
	/**
	 * ����User��Ϣ
	 * @param User
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean change(User user) {
		
		tx = getSession().beginTransaction();
		try{
			update(user);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	
	/**
	 * ɾ��User
	 * @param User
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean del(String userName){
		
		tx = getSession().beginTransaction();
		try{
			delete(findByUsername(userName));
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	
	//-------------------------------------------
	//	�ײ�֧�ֵĹ��ܺ���
	//-------------------------------------------
	
	//����USER���һ������
	public void save(User transientInstance){
        log.debug("saving User instance");
        try {
        	getSession().save(transientInstance);
        	
            log.debug("save successful");
            
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    //����USER���һ������
    public void update(User transientInstance) {
    	log.debug("updating User instance");
        try {
        	getSession().update(transientInstance);
            
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
    
    //ɾ��USER���һ������
	public void delete(User persistentInstance) {
        log.debug("deleting User instance");
        try {
        	getSession().delete(persistentInstance);
        	
            log.debug("delete successful");
            
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
	//ͨ��UserId���Ҳ�����User����
    public User findById( java.lang.Integer id) {
        log.debug("getting User instance with id: " + id);
        try {
            User instance = (User) getSession().get("com.amzblog.model.User", id);
            return instance;
            
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    //��ѯģ�壺ͨ��ĳһ�����Լ���ֵ���ҵ����ϸ�ֵ������ʵ��List
    public List<User> findByProperty(String propertyName, Object value) {
      log.debug("finding User instance with property: " + propertyName
            + ", value: " + value);
      try {
		String queryString = "from User as u where u." + propertyName + "= ?";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return queryObject.list();
     
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	//ͨ��Username����(UniqueԼ��)����ֵ���ҵ����ϸ�ֵ��User,�޷��ϵķ���null
	public User findByUsername(Object username) {
		List list = findByProperty(USERNAME, username);

		if (list.size() != 0) {
			return (User)list.get(0);
		} else {
			return null;
		}	
	}

	//ͨ���û������������User�������ڷ���User�����򷵻�null
	public User findByUsernameAndPassword(Object username, Object password) {
		log.debug("finding User instance with username: " + username
	            + ", password: " + password);
		try {
			
			String queryString = "from User u where u.username = ? and u.userPassword = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, username);
			queryObject.setParameter(1, password);

			if (queryObject.list().size() != 0) {
				return (User) queryObject.list().get(0);
			} else {
				return null;
			}	
				 
		} catch (RuntimeException re) {
			log.error("username or password incorrect!", re);
			throw re;
		}
	}

	//�����ǳ�Ϊ����ֵ��User����List
	public List<User> findByUserNickname(Object userNickname) {
		return findByProperty(USER_NICKNAME, userNickname);
	}
	
	//�����Ա�Ϊ���С���Ů����User����List
	public List<User> findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}
	
	//ͨ��ע���������User�������ڷ���User�����򷵻�null
	public User findByUserEmailAddr(Object userEmailAddr) {
		List<User> list = findByProperty(USER_EMAIL_ADDR, userEmailAddr);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//ͨ�����͵�ַ����User�������ڷ���User�����򷵻�null
	public User findByUserBlogAddr(Object userBlogAddr) {
		List<User> list = findByProperty(USER_BLOG_ADDR, userBlogAddr);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//ͨ���ֻ��Ų���User�������ڷ���User�����򷵻�null
	public User findByUserPhone(Object userPhone) {
		List<User> list = findByProperty(USER_PHONE, userPhone);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//��ȡUSER�������е�User����List�������ڷ���List<User>�����򷵻�null
	public List<User> findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
	        Query queryObject = getSession().createQuery(queryString);
	        return queryObject.list();
	        
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/*
	 * merge����ʹ����ʾ
	 * ��newһ����������ö���������ID�����������͵�������̬����
	 * 	��ID�����ݿ��в����ҵ�ʱ����update�Ļ��϶��ᱨ�쳣��Ȼ����merge�Ļ����ͻ�insert��
	 * 	��ID�����ݿ������ҵ���ʱ��update��merge��ִ��Ч�����Ǹ������ݣ�����update��䣻
	 * ���û������ID�Ļ������������͵���˲̬����
	 * 	��update�Ļ�������û��ID�����Իᱨ�쳣��
	 * 	merge��ʱ��ᱣ�����ݣ�����ID������������һ�����ݣ�
	 */
    public User merge(User detachedInstance) {
        log.debug("merging User instance");
        try {
        	User result = (User) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
            
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    //������Ķ���־û������棬�������δ���棨Transient״̬��������save��������
    //��������ѱ��棨Detached״̬��������update������������Session���¹���
    public void attachDirty(User instance) {
        log.debug("attaching dirty User instance");
        try {
        	getSession().saveOrUpdate(instance);
            log.debug("attach successful");
            
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    //������Ķ���״̬����ΪTransient״̬
    public void attachClean(User instance) {
        log.debug("attaching clean User instance");
        try {
        	getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

}