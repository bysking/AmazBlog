package com.amzblog.daoImpl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.FeelingDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Blog;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;

public class FeelingDaoImpl extends BaseHibernateDAO implements FeelingDao{
	
	//-------------------------------------------
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(FeelingDaoImpl.class);
	
	//声明常量(与类的属性对应)
	public static final String FEEL_CONTENT = "feelContent";
	
	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static FeelingDao instance;
	//获取FeelingDao实例
	public static final FeelingDao getInstance() {
		if (instance == null) {
			try {
				instance = new FeelingDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;

	}
	
	
	//-------------------------------------------
	// FeelingDao接口方法实现
	//-------------------------------------------
	
	/**
	 * 通过feelingId查找心情，若存在返回Feeling，否则返回null
	 * @param int
	 * @return Feeling
	 * @author Bruski
	 */
	@Override
	public Feeling find(int feelingId) {
		
		return findById(feelingId);
	}
	
	
	/**
	 * 通过User查找最新一条的心情，若存在返回Feeling，否则返回null
	 * @param User 
	 * @return Feeling
	 * @author Bruski
	 */
	@Override
	public Feeling findRecentFeelingByUser(User user) {
		
		return findRecentFeeling(user);
	}

	
	/**
	 * 通过User查找用户的所有心情(按日期最新在前排序)，若存在返回List<Feeling>，否则返回null
	 * @param User
	 * @return List<Feeling>
	 * @author Bruski
	 */
	@Override
	public List<Feeling> findAllFeelingByUser(User user) {
		
		return findAll(user);
	}
	
	
	/**
	 * 添加用户新的心情
	 * @param Feeling
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean insertFeelingByUser(Feeling feeling) {
		
		tx = getSession().beginTransaction();
		try{
			save(feeling);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}

	
	/**
	 * 删除用户的心情
	 * @param Feeling
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean delFeelingByUser(Feeling feeling) {
		tx = getSession().beginTransaction();
		try{
			delete(feeling);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}

	
	/**
	 * 更新用户的心情
	 * @param Feeling
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean changeFeelingByUser(Feeling feeling) {
		tx = getSession().beginTransaction();
		try{
			update(feeling);
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
	
	public void save(Feeling transientInstance) {
		log.debug("saving Feeling instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Feeling transientInstance) {
    	log.debug("updating feeling instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
			
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
	
	public void delete(Feeling persistentInstance) {
		log.debug("deleting Feeling instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Feeling findById(java.lang.Integer id) {
		log.debug("getting Feeling instance with id: " + id);
		try {
			Feeling instance = (Feeling) getSession().get(
					"com.amzblog.model.Feeling", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//自定义方法：查找用户最新的一条心情
	public Feeling findRecentFeeling(User user) {
		log.debug("finding Recent Feeling of User");
		try {
			String queryString = "from Feeling f where f.user=?"
					+ " order by f.feelCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			
			if(queryObject.list().size() != 0) {
				return (Feeling) queryObject.list().get(0);
			} else {
				return null;
			}
			
		} catch (RuntimeException re) {
			log.error("find Recent Feeling of User failed", re);
			throw re;
		}
	}

	public List<Feeling> findByProperty(String propertyName, Object value) {
		log.debug("finding Feeling instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Feeling as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Feeling> findByFeelContent(Object feelContent) {
		return findByProperty(FEEL_CONTENT, feelContent);
	}

	public List<Feeling> findAll() {
		log.debug("finding all Feeling instances");
		try {
			String queryString = "from Feeling";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//自定义方法：查找用户的所有心情
	public List<Feeling> findAll(User user) {
		log.debug("finding all Feeling instances of a user");
		try {
			String queryString = "from Feeling feeling where feeling.user = ?"
					+" order by feeling.feelCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Feeling merge(Feeling detachedInstance) {
		log.debug("merging Feeling instance");
		try {
			Feeling result = (Feeling) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Feeling instance) {
		log.debug("attaching dirty Feeling instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Feeling instance) {
		log.debug("attaching clean Feeling instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}