package com.amzblog.daoImpl;

import java.sql.Timestamp;
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

import com.amzblog.dao.BlogDao;
import com.amzblog.dao.UserDao;
import com.amzblog.db.BaseHibernateDAO;
import com.amzblog.model.Blog;
import com.amzblog.model.User;
import com.amzblog.model.Zone;

public class BlogDaoImpl extends BaseHibernateDAO implements BlogDao{
	
	//-------------------------------------------
	// ����
	//-------------------------------------------
	
	//����Log�����������������Ϣ
	private static final Log log = LogFactory.getLog(BlogDaoImpl.class);
	
	//��������(��������Զ�Ӧ)
	public static final String BLOG_TITLE = "blogTitle";
	public static final String BLOG_CONTENT = "blogContent";

	//����Transaction
	Transaction tx;
	
	//����ʵ������
	private static BlogDao instance;
	//��ȡBlogDaoʵ��
	public static final BlogDao getInstance() {
		if (instance == null) {
			try {
				instance = new BlogDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	
	//-------------------------------------------
	// BlogDao�ӿڷ���ʵ��
	//-------------------------------------------
	
	/**
	 * ͨ��blogId������־�������ڷ���Blog�����򷵻�null
	 * @param int
	 * @return Blog
	 * @author Bruski
	 */
	@Override
	public Blog findBlog(int blogId) {
		
		return findById(blogId);
	}
	
	
	/**
	 * ͨ��User��blogTitle������־�������ڷ���Blog�����򷵻�null
	 * @param User, String
	 * @return Blog
	 * @author Bruski
	 */
	@Override
	public Blog findBlogByUser(User user,String blogTitle) {
		
		return findByUserAndBlogTitle(user, blogTitle);
	}
	
	
	/**
	 * ��ȡ���û����е���־
	 * @param User
	 * @return List<Blog>
	 * @author Bruski
	 */
	@Override
	public List<Blog> getAllBlog(User user) {
		
		return findAll(user);
	}

	
	/**
	 * ������־
	 * @param Blog
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean insertBlogByUser(Blog blog) {

		tx = getSession().beginTransaction();
		try{
			save(blog);
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	
	/**
	 * ɾ����־
	 * @param int
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean delBlogByUser(int blogId) {
		
		tx = getSession().beginTransaction();
		try{
			delete(findById(blogId));
			tx.commit();
			return true;
			
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
	
	
	/**
	 * ������־
	 * @param Blog
	 * @return boolean
	 * @author Bruski
	 */
	@Override
	public boolean changeBlogByUser(Blog blog) {
		
		tx = getSession().beginTransaction();
		try{
			update(blog);
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
	
	public void save(Blog transientInstance) {
		log.debug("saving Blog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Blog transientInstance) {
    	log.debug("updating Blog instance");
        try {
            getSession().update(transientInstance);
            log.debug("update successful");
            
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
	
	public void delete(Blog persistentInstance) {
		log.debug("deleting Blog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Blog findById(java.lang.Integer id) {
		log.debug("getting Blog instance with id: " + id);
		try {
			Blog instance = (Blog) getSession().get("com.amzblog.model.Blog",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Blog> findByProperty(String propertyName, Object value) {
		log.debug("finding Blog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Blog> findByBlogTitle(Object blogTitle) {
		return findByProperty(BLOG_TITLE, blogTitle);
	}

	//ͨ��user��blogTitle������־
	public Blog findByUserAndBlogTitle(User user, String blogTitle) {
		
		log.debug("finding Blog instance by User and Title: ");
		try {
			String queryString = "from Blog blog where blog.user = ? and blog.blogTitle = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			queryObject.setParameter(1, blogTitle);
			
			if(queryObject.list().size() != 0) {
				return (Blog) queryObject.list().get(0);
			} else {
				return null;
			}
			
		} catch (RuntimeException re) {
			log.error("find by User and Title failed", re);
			throw re;
		}
	}
	
 	public List<Blog> findByBlogContent(Object blogContent) {
		return findByProperty(BLOG_CONTENT, blogContent);
	}

	//����ĳ��User��������־
	public List<Blog> findAll(Object user) {
		log.debug("finding all Blog instances");
		try {
			String queryString = "from Blog blog where blog.user = ?"
					+ " order by blog.blogCreateTime desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, user);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blog merge(Blog detachedInstance) {
		log.debug("merging Blog instance");
		try {
			Blog result = (Blog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blog instance) {
		log.debug("attaching dirty Blog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Blog instance) {
		log.debug("attaching clean Blog instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}