package com.amzblog.daoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.MsgboxDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Comment;
import com.amzblog.model.Message;
import com.amzblog.model.Msgbox;
import com.amzblog.model.Msgbox;
import com.amzblog.model.User;


public class MsgboxDaoImpl extends BaseHibernateDAO implements MsgboxDao{
	
	//-------------------------------------------
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(MsgboxDaoImpl.class);

	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static MsgboxDao instance;
	//获取MsgboxDao实例
	public static final MsgboxDao getInstance() {
		if (instance == null) {
			try {
				
				instance = new MsgboxDaoImpl();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return instance;

	}

	//-------------------------------------------
	// MsgboxDao接口方法实现
	//-------------------------------------------
	
	@Override
	public boolean addMsgbox(User receiver, Message message) {
		
		Msgbox msgbox = new Msgbox();
		msgbox.setUser(receiver);
		msgbox.setMessage(message);
		
		try{
			save(msgbox);
			return true;
			
		} catch(Exception e) {
			return false;
		}
	}

	
	//-------------------------------------------
	//	底层支持的功能函数
	//-------------------------------------------
	
	public void save(Msgbox transientInstance) {
		log.debug("saving Msgbox instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Msgbox transientInstance) {
    	log.debug("updating Msgbox instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            tx.rollback();
            throw re;
        }
    }

	public void delete(Msgbox persistentInstance) {
		log.debug("deleting Msgbox instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Msgbox findById(java.lang.Integer id) {
		log.debug("getting Msgbox instance with id: " + id);
		try {
			Msgbox instance = (Msgbox) getSession().get(
					"com.amzblog.model.Msgbox", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public boolean insert(User rec, Message msg) {
		String sql = "insert into message('UserID','MsgID') "
				+ "values('"+rec.getUserId()+"','"+msg.getMsgId()+"')";
		SQLQuery query = getSession().createSQLQuery(sql);
		int i = query.executeUpdate();
		return i>0?true:false;
	}
	//暂时不用
	public Msgbox findByMessage(Message message) {
		log.debug("finding Msgbox instance with message: ");
		try {
			String queryString = "from Msgbox m where m.message=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, message);
			return (Msgbox)queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find Msgbox instance with message failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Msgbox instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Msgbox as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Msgbox instances");
		try {
			String queryString = "from Msgbox";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Msgbox merge(Msgbox detachedInstance) {
		log.debug("merging Msgbox instance");
		try {
			Msgbox result = (Msgbox) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Msgbox instance) {
		log.debug("attaching dirty Msgbox instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Msgbox instance) {
		log.debug("attaching clean Msgbox instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}