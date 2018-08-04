package com.amzblog.service;

import java.util.ArrayList;
import java.util.List;

import com.amzblog.dao.BlogDao;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.db.HibernateSessionFactory;
import com.amzblog.model.Blog;
import com.amzblog.model.User;

public class BlogService {

	private BlogDao dao;
	private static User user;
	private static BlogService instance;
	
	//���캯������һ���û���Ϊ����
	public BlogService( User user){
		dao=BlogDaoImpl.getInstance();	
		BlogService.user=user;
	}
	
	public static final BlogService getInstance() {
		if (instance == null) {
			try {
				instance = new BlogService(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	//������ʾ��־�б�
	public List<Blog> getAllBlogService(User user) {
		//��ȡ���ݿ��е�������־
		List<Blog> bloglist =dao.getAllBlog(user);	
		//HibernateSessionFactory.closeSession();
		return bloglist;
		
	}
	
	//��ȡ��ҳ����ҳ��
	public int getPageCount(User user){
		
		List<Blog> bloglist =dao.getAllBlog(user);
		int pageSize = 5;//Ĭ��ÿҳ���ݴ�С
		int dataCount = bloglist.size();//��������
		int pageCount=dataCount/pageSize;//��ҳ��
		
		//������ҳ��
		if(dataCount%pageSize==0){
			
			pageCount=dataCount/pageSize;
		}
		else{
			
			pageCount=dataCount/pageSize+1;
		}
		
		return pageCount;
		
		
	}
	

	public int getBlogCount(User user){
		
		List<Blog> bloglist =dao.getAllBlog(user);
		
		return bloglist.size();
		
		
		
	}
	
	//��ҳ��ʾ�û���־,����һ����̬���飬����5��blog����,
	@SuppressWarnings({ "null" })
	public List<Blog> getBlogByPageService(User user,int pageIndex) {
		//��ȡ���ݿ��е�������־
		List<Blog> bloglist =dao.getAllBlog(user);	
		
		ArrayList<Blog> blogpagelist = new ArrayList<>() ;
		
		//Ĭ��ÿҳ��ʾ5����¼
		for(int i=(pageIndex-1)*5;(i<(pageIndex-1)*5+5)&&(i<bloglist.size());i++){
			blogpagelist.add(bloglist.get(i));
		}
		
		return blogpagelist;//#####����ط���֪��ʹ�ù���᲻�ᱻ��null�������´�ʹ�õ�ʱ�����
		
	}
	
	
	//ɾ���û���־
	public boolean delBlogService(int blogId){
		

		return dao.delBlogByUser(blogId);
		
	}
	//�����־
	public boolean insertBlogByUserService(Blog blog){
		
		return dao.insertBlogByUser(blog);		
	
    }
	//�޸���־
	public boolean changeBlogByUserService(Blog blog){
		
		return dao. changeBlogByUser(blog);				
		
	}

	
	public Blog findBlogListByUserService(User user,String BlogTitle){
			
		return dao.findBlogByUser(user,BlogTitle);
	}
	//����ô�н��в���
	public Blog findBlogByBlodIdService(int blogId){
		
		return dao.findBlog(blogId);
	}

	
	
	
	
}
