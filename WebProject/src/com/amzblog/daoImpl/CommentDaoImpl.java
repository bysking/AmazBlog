package com.amzblog.daoImpl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.amzblog.dao.CommentDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;


public class CommentDaoImpl extends BaseHibernateDAO implements CommentDao{
	
	//-------------------------------------------
	// 声明
	//-------------------------------------------
	
	//创建Log对象，用于输出编译信息
	private static final Log log = LogFactory.getLog(CommentDaoImpl.class);
	
	//声明常量(与类的属性对应)
	public static final String COMM_CONTENT = "commContent";

	//声明Transaction
	Transaction tx;
	
	//声明实例变量
	private static CommentDao instance;
	//获取CommentDao实例
	public static final CommentDao getInstance() {
		if (instance == null) {
			try {
				instance = new CommentDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;

	}
	
	
	//-------------------------------------------
	// CommentDao接口方法实现
	//-------------------------------------------
	
	/**
	 * 通过commentId查找评论，若存在返回Comment，否则返回null
	 * @param int
	 * @return Comment
	 * @author Bruski
	 */
	public Comment find(int commentId) {
		
		return findById(commentId);
	}
	
	
	/**
	 * 通过User查找用户发出的所有评论(按日期最新在前排序)，若存在返回List<Comment>，否则返回null
	 * @param User
	 * @return List<Comment>
	 * @author Bruski
	 */
	@Override
	public List<Comment> findCommentByUser(User user) {

		return findByUser(user);
	}

	/**
	 * 通过blog查找该日志收到的所有评论，若存在返回List<Comment>，否则返回null
	 * @param Blog
	 * @return List<Comment>
	 * @author Bruski
	 */
	@Override
	public List<Comment> getAllComment(Blog blog) {

		return findAll(blog);
	}
	
	/**
	 * 添加用户发出的评论
	 * @param Comment
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean insertCommentByUser(Comment comment) {

		tx = getSession().beginTransaction();
		try{
			save(comment);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	/**
	 * 删除用户发出的评论
	 * @param int
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean delCommentByUser(int commentId) {
		
		tx = getSession().beginTransaction();
		try{
			delete(findById(commentId));
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}

	/**
	 * 更新用户发出的评论
	 * @param Comment
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean changeCommentByUser(Comment comment) {

		tx = getSession().beginTransaction();
		try{
			update(comment);
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
	
	public void save(Comment transientInstance) {
		log.debug("saving Comment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Comment transientInstance) {
    	log.debug("updating Comment instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
	
	public void delete(Comment persistentInstance) {
		log.debug("deleting Comment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comment findById(java.lang.Integer id) {
		log.debug("getting Comment instance with id: " + id);
		try {
			Comment instance = (Comment) getSession().get(
					"com.amzblog.model.Comment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comment> findByProperty(String propertyName, Object value) {
		log.debug("finding Comment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Comment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Comment> findByUser(User user) {
		log.debug("finding All Comments of User");
		try {
			String queryString = "from Comment comm where comm.user=?"
					+ " order by comm.commCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find All Comments of User failed", re);
			throw re;
		}
	}
	
	public List<Comment> findByCommContent(Object commContent) {
		return findByProperty(COMM_CONTENT, commContent);
	}

	public List<Comment> findAll(Object blog) {
		log.debug("finding all Blog instances");
		try {
			String queryString = "from Comment comment where comment.blog = ? "
					+ "order by comment.commCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, blog);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Comment> findAll() {
		log.debug("finding all Comment instances");
		try {
			String queryString = "from Comment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comment merge(Comment detachedInstance) {
		log.debug("merging Comment instance");
		try {
			Comment result = (Comment) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comment instance) {
		log.debug("attaching dirty Comment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comment instance) {
		log.debug("attaching clean Comment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}