package com.amzblog.daoImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.MessageDao;
import com.amzblog.dao.MsgboxDao;
import com.amzblog.dao.UserDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Admin;
import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.Message;
import com.amzblog.model.User;

public class MessageDaoImpl extends BaseHibernateDAO implements MessageDao{
	
	//-------------------------------------------
	// ����
	//-------------------------------------------
	
	//����Log�����������������Ϣ
	private static final Log log = LogFactory.getLog(MessageDaoImpl.class);
	
	//��������(��������Զ�Ӧ)
	public static final String MSG_CONTENT = "msgContent";

	//����Transaction
	Transaction tx;
	
	//����ʵ������
	private static MessageDao instance;
	//��ȡMessageDaoʵ��
	public static final MessageDao getInstance() {
		if (instance == null) {
			try {
				
				instance = new MessageDaoImpl();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;

	}
	
	//-------------------------------------------
	// MessageDao�ӿڷ���ʵ��
	//-------------------------------------------
			
	//ͨ��ID��ѯһ����Ϣ
	@Override
    public Message find(int messageId) {
    	
    	return findById(messageId);
    }
    
    @Override
    public Message find(Message message) {
    	List list = findByExample(message);
    	if(list.size()!=0) {
    		return (Message)list.get(0);
    	} else {
    		return null;
    	}
    }
	
	//���ظ��û���������������
	@Override
	public List<Message> findAllMessage(User user) {
		
		return findAll(user);
	}
	
	//���ظ��û��յ�����������
	@Override
	public List<Message> findReceivedMsgs(User user) {
		
		return findByUser(user);
	}
    
	//��Ӹ��û����������ԣ�ͬʱ���յ��û�����Ϣ�б�Ҳ���
	@Override
	public boolean addMessage(Message message, User receiver) {

		MsgboxDao msgboxDao = MsgboxDaoImpl.getInstance();
		tx = getSession().beginTransaction();
		try{
			save(message);
			//ͬʱ���յ��û�����Ϣ�б�Ҳ���
			msgboxDao.addMsgbox(receiver, message);
			
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	//ɾ�����û����������ԣ�ͬʱ���յ��û�����Ϣ�б�Ҳɾ��(����ɾ��)
	@Override
	public boolean delMessage(Message message) {

		tx = getSession().beginTransaction();
		try{
			delete(message);
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

	public void save(Message transientInstance) {
		log.debug("saving Message instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Message transientInstance) {
    	log.debug("updating Message instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            tx.rollback();
            throw re;
        }
    }

	public void delete(Message persistentInstance) {
		log.debug("deleting Message instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Message findById(java.lang.Integer id) {
		log.debug("getting Message instance with id: " + id);
		try {
			Message instance = (Message) getSession().get(
					"com.amzblog.model.Message", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Message> findByUser(User user) {
		
		log.debug("finding find Received Msgs with user");
		try {
			String queryString = "select m.message from Msgbox m where m.user=?"
					+" order by m.message.msgCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find Msgbox instance with user failed", re);
			throw re;
		}
	}

	public List findByExample(Message instance) {
		log.debug("finding Message instance by example");
		try {
			List results = getSession()
					.createCriteria("com.amzblog.model.Message")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Message> findByProperty(String propertyName, Object value) {
		log.debug("finding Message instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Message as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Message> findByMsgContent(Object msgContent) {
		return findByProperty(MSG_CONTENT, msgContent);
	}

	public List<Message> findAll() {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	//��ѯĳ�û���������������
	public List<Message> findAll(User user) {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message m where m.user= ?"
					+" order by m.msgCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Message merge(Message detachedInstance) {
		log.debug("merging Message instance");
		try {
			Message result = (Message) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Message instance) {
		log.debug("attaching dirty Message instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Message instance) {
		log.debug("attaching clean Message instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}