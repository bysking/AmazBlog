package com.amzblog.daoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.AdminDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Admin;
import com.amzblog.model.User;

public class AdminDaoImpl extends BaseHibernateDAO implements AdminDao {
	
	//-------------------------------------------
	// ����
	//-------------------------------------------
	
	//����Log�����������������Ϣ
	private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

	//��������(��������Զ�Ӧ)
	public static final String ADMIN_USERNAME = "adminUsername";
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_NICKNAME = "adminNickname";

	//����Transaction
	Transaction tx;
	
	//����ʵ������
	private static AdminDao instance;
	//��ȡAminDaoʵ��
	public static final AdminDao getInstance(){
		if(instance == null) {
			try {
				instance = new AdminDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	//-------------------------------------------
	// AdminDao�ӿڷ���ʵ��
	//-------------------------------------------
		
	/**
	 * ͨ��adminId���ҹ���Ա�������ڷ���Admin�����򷵻�null
	 * @param int
	 * @return Admin
	 * @author Bruski
	 */
	@Override
	public Admin find(int adminId) {

		return findById(adminId);
	}
	
	
	/**
	 * ͨ��adminUsername���ҹ���Ա�������ڷ���Admin�����򷵻�null
	 * @param String
	 * @return Admin
	 * @author Bruski
	 */
	@Override
	public Admin find(String adminUsername) {

		return findByAdminUsername(adminUsername);
	}
	
	
	/**
	 * ��¼ģ�飺ͨ��adminUsername��adminPassword���ҹ���Ա�����ڷ���Admin�����򷵻�null
	 * @param String, String
	 * @return Admin
	 * @author Bruski
	 */
	@Override
	public Admin login(String adminUsername, String adminPassword) {

		return findByUsernameAndPassword(adminUsername, adminPassword);
	}

	
	/**
	 * ����Admin
	 * @param Admin
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean add(Admin admin) {
		
		tx = getSession().beginTransaction();
		try{
			save(admin);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	

	/**
	 * ����Admin��Ϣ
	 * @param Admin
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean change(Admin admin) {
		
		tx = getSession().beginTransaction();
		try{
			save(admin);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	
	/**
	 * ɾ��Admin
	 * @param Admin
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean del(String adminUserName){

		Admin admin = findByAdminUsername(adminUserName);
		tx = getSession().beginTransaction();
		try{
			delete(admin);
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

	public void save(Admin transientInstance) {
		log.debug("saving Admin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Admin transientInstance) {
    	log.debug("updating Admin instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    } 

	public void delete(Admin persistentInstance) {
		log.debug("deleting Admin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	

	public Admin findById(java.lang.Integer id) {
		log.debug("getting Admin instance with id: " + id);
		try {
			Admin instance = (Admin) getSession().get(
					"com.amzblog.model.Admin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Admin> findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();

		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Admin findByAdminUsername(Object adminUsername) {
		List list = findByProperty(ADMIN_USERNAME, adminUsername);
		
		if (list.size() != 0) {
			return (Admin)list.get(0);
		} else {
			return null;
		}	
	}

	//ͨ����¼���������ѯ����Ա
	public Admin findByUsernameAndPassword(Object adminUsername, Object adminPassword) {
		log.debug("finding Admin instance with username: " + adminUsername
	            + ", password: " + adminPassword);
		try {
	         String queryString = "select admin from Admin admin where admin.adminUsername = ? and admin.adminPassword = ?";
	         Query queryObject = getSession().createQuery(queryString);
			 queryObject.setParameter(0, adminUsername);
			 queryObject.setParameter(1, adminPassword);

			 if(queryObject.list().size() != 0) {
					return (Admin) queryObject.list().get(0);
				} else {
					return null;
				}
			 
	      } catch (RuntimeException re) {
	         log.error("username or password incorrect!", re);
	         throw re;
		  }	 
	}
	
	public List<Admin> findByAdminNickname(Object adminNickname) {
		return findByProperty(ADMIN_NICKNAME, adminNickname);
	}

	public List<Admin> findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admin merge(Admin detachedInstance) {
		log.debug("merging Admin instance");
		try {
			Admin result = (Admin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admin instance) {
		log.debug("attaching dirty Admin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admin instance) {
		log.debug("attaching clean Admin instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}