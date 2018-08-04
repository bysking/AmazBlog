package com.amzblog.daoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.FriendshipDao;
import com.amzblog.dao.UserDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Admin;
import com.amzblog.model.Friendship;
import com.amzblog.model.User;

public class FriendshipDaoImpl extends BaseHibernateDAO implements FriendshipDao{
	
	//-------------------------------------------
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(FriendshipDaoImpl.class);
	
	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static FriendshipDao instance;
	//获取FriendshipDao实例
	public static final FriendshipDao getInstance() {
		if (instance == null) {
			try {
				instance = new FriendshipDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	//-------------------------------------------
	// FriendshipDao接口方法实现
	//-------------------------------------------

	
	@Override
	public List<Friendship> friendInfo(String userName) {
		
		UserDao dao = UserDaoImpl.getInstance();
		return findAll(dao.find(userName));
	}

	//判断双方是否是好友
	public boolean isFriend(String userName,String friendName) {
		if(findByUserAndFriend(userName, friendName) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean addFriend(String userName, String friendName) {
		UserDao dao = UserDaoImpl.getInstance();
		User user = dao.find(userName);
		User friend = dao.find(friendName);
		
		Friendship friendship1 = new Friendship();
		friendship1.setUserByUserId(user);
		friendship1.setUserByFriendId(friend);
		
		Friendship friendship2 = new Friendship();
		friendship2.setUserByUserId(friend);
		friendship2.setUserByFriendId(user);
		
		tx = getSession().beginTransaction();
		try{
			save(friendship1);
			save(friendship2);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	@Override
	public boolean delFriend(String userName,String friendName) {

		Friendship friendship1 = findByUserAndFriend(userName, friendName);
		Friendship friendship2 = findByUserAndFriend(friendName, userName);
		
		tx = getSession().beginTransaction();
		try{
			delete(friendship1);
			delete(friendship2);
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
	
	public void save(Friendship transientInstance) {
		log.debug("saving Friendship instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Friendship transientInstance) {
    	log.debug("updating Friendship instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            throw re;
        }
    } 

	public void delete(Friendship persistentInstance) {
		log.debug("deleting Friendship instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Friendship findById(java.lang.Integer id) {
		log.debug("getting Friendship instance with id: " + id);
		try {
			Friendship instance = (Friendship) getSession().get("com.amzblog.model.Friendship", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Friendship findByUserAndFriend(String userName,String friendName) {
		log.debug("finding Friendship instance");
		try {
			String queryString = "from Friendship f where f.userByFriendId.username=? and f.userByUserId.username=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, userName);
			queryObject.setParameter(1, friendName);
			
			if(queryObject.list().size() != 0) {
				return (Friendship) queryObject.list().get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Friendship> findByProperty(String propertyName, Object value) {
		log.debug("finding Friendship instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Friendship as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	//查询数据库中所有朋友关系
	public List<Friendship> findAll() {
		log.debug("finding all Friendship instances");
		try {
			String queryString = "from Friendship";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//查询某个用户的所有朋友关系
	public List<Friendship> findAll(User user) {
		log.debug("finding all Friendship instances of a user");
		try {
			String queryString = "from Friendship f where f.userByUserId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Friendship merge(Friendship detachedInstance) {
		log.debug("merging Friendship instance");
		try {
			Friendship result = (Friendship) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Friendship instance) {
		log.debug("attaching dirty Friendship instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Friendship instance) {
		log.debug("attaching clean Friendship instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}