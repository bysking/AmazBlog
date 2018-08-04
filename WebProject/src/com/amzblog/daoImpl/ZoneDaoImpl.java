package com.amzblog.daoImpl;

import com.amzblog.dao.UserDao;
import com.amzblog.dao.ZoneDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.User;
import com.amzblog.model.Zone;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

public class ZoneDaoImpl extends BaseHibernateDAO implements ZoneDao {
	
	//-------------------------------------------
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(ZoneDaoImpl.class);
	
	//声明常量(与类的属性对应)
	public static final String ZONE_NAME = "zoneName";
	
	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static ZoneDao instance;
	//获取ZoneDao实例
	public static final ZoneDao getInstance() {
		if (instance == null) {
			try {
				instance = new ZoneDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	//-------------------------------------------
	// AdminDao接口方法实现
	//-------------------------------------------
	
	//通过ZoneId查找空间
	@Override
	public Zone find(int zoneId) {
		
		return findById(zoneId);
	}
	
	@Override
	public Zone findZone(int userId) {
		
		return findByUser(userId);
	}
	
	@Override
	public boolean addZone(Zone zone) {
		
		tx = getSession().beginTransaction();
		boolean flag = save(zone);
		
		if(flag == true) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		
		return flag;
	}
	
	@Override
	public boolean changeZone(Zone zone) {

		tx = getSession().beginTransaction();
		boolean flag = update(zone);
		
		if(flag == true) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		
		return flag;
	}
	
	@Override
	public boolean deleteZone(Zone zone) {
		
		tx = getSession().beginTransaction();
		boolean flag = delete(zone);
		
		if(flag == true) {
			tx.commit();
		}
		else {
			tx.rollback();
		}
		
		return flag;
	}

	//-------------------------------------------
	//	底层支持的功能函数
	//-------------------------------------------
	
	public boolean save(Zone transientInstance) {
		log.debug("saving Zone instance");
		boolean flag = false;
        
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			flag = true;
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
		return flag;
	}
	
	public boolean update(Zone transientInstance) {
    	log.debug("updating Zone instance");
    	boolean flag = false;
        
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            flag = true;
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            tx.rollback();
            throw re;
        }
        
        return flag;
    }

	public boolean delete(Zone persistentInstance) {
		log.debug("deleting Zone instance");
		boolean flag = false;
        
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			flag = true;
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		
		return flag;
	}

	public Zone findById(java.lang.Integer id) {
		log.debug("getting Zone instance with id: " + id);
		try {
			Zone instance = (Zone) getSession().get("com.amzblog.model.Zone",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Zone findByUser(int userId) {
		
		log.debug("finding Zone By userId: ");
		try {
			String queryString = "from Zone as model where model.user.userId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, userId);
			
			if(queryObject.list().size() != 0) {
				return (Zone) queryObject.list().get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Zone> findByProperty(String propertyName, Object value) {
		log.debug("finding Zone instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Zone as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);			
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByZoneName(Object zoneName) {
		return findByProperty(ZONE_NAME, zoneName);
	}

	public List findAll() {
		log.debug("finding all Zone instances");
		try {
			String queryString = "from Zone";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Zone merge(Zone detachedInstance) {
		log.debug("merging Zone instance");
		try {
			Zone result = (Zone) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Zone instance) {
		log.debug("attaching dirty Zone instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Zone instance) {
		log.debug("attaching clean Zone instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}