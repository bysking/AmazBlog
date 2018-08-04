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
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	//声明常量(与类的属性对应)
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

	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static UserDao instance;
	//获取UserDao实例
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
	// UserDao接口方法实现
	//-------------------------------------------
	
	/**
	 * 通过userId查找User，若存在返回User，否则返回null
	 * @param int
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User find(int userId) {

		return findById(userId);
	}
	
	
	/**
	 * 通过userName查找User，若存在返回User，否则返回null
	 * @param String
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User find(String userName) {

		return findByUsername(userName);
	}
	
	
	/**
	 * 登录模块：通过userName与userPassword查找User，若存在返回User，否则返回null
	 * @param String, String
	 * @return User
	 * @author Bruski
	 */
	@Override
	public User login(String userName, String userPassword) {

		return findByUsernameAndPassword(userName, userPassword);
	}
	
	
	/**
	 * 增加User,若user名不允许重复添加
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
	 * 更新User信息
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
	 * 删除User
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
	//	底层支持的功能函数
	//-------------------------------------------
	
	//增加USER表的一条数据
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
    
    //更新USER表的一条数据
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
    
    //删除USER表的一条数据
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
    
	//通过UserId查找并返回User对象
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
    
    //查询模板：通过某一个属性及其值，找到符合该值的所有实例List
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

	//通过Username属性(Unique约束)及其值，找到符合该值的User,无符合的返回null
	public User findByUsername(Object username) {
		List list = findByProperty(USERNAME, username);

		if (list.size() != 0) {
			return (User)list.get(0);
		} else {
			return null;
		}	
	}

	//通过用户名，密码查找User，若存在返回User，否则返回null
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

	//返回昵称为输入值的User对象List
	public List<User> findByUserNickname(Object userNickname) {
		return findByProperty(USER_NICKNAME, userNickname);
	}
	
	//返回性别为“男”或“女”的User对象List
	public List<User> findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}
	
	//通过注册邮箱查找User，若存在返回User，否则返回null
	public User findByUserEmailAddr(Object userEmailAddr) {
		List<User> list = findByProperty(USER_EMAIL_ADDR, userEmailAddr);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//通过博客地址查找User，若存在返回User，否则返回null
	public User findByUserBlogAddr(Object userBlogAddr) {
		List<User> list = findByProperty(USER_BLOG_ADDR, userBlogAddr);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//通过手机号查找User，若存在返回User，否则返回null
	public User findByUserPhone(Object userPhone) {
		List<User> list = findByProperty(USER_PHONE, userPhone);
		
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//获取USER表中所有的User对象List，若存在返回List<User>，否则返回null
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
	 * merge方法使用提示
	 * 新new一个对象，如果该对象设置了ID，则这个对象就当作游离态处理：
	 * 	当ID在数据库中不能找到时，用update的话肯定会报异常，然而用merge的话，就会insert。
	 * 	当ID在数据库中能找到的时候，update与merge的执行效果都是更新数据，发出update语句；
	 * 如果没有设置ID的话，则这个对象就当作瞬态处理：
	 * 	用update的话，由于没有ID，所以会报异常，
	 * 	merge此时则会保存数据，根据ID生产策略生成一条数据；
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

    //将传入的对象持久化并保存，如果对象未保存（Transient状态），调用save方法保存
    //如果对象已保存（Detached状态），调用update方法将对象与Session重新关联
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
    
    //将传入的对象状态设置为Transient状态
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