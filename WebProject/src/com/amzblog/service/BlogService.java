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
	
	//构造函数传入一个用户作为参数
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
	
	//用来显示日志列表
	public List<Blog> getAllBlogService(User user) {
		//获取数据库中的所有日志
		List<Blog> bloglist =dao.getAllBlog(user);	
		//HibernateSessionFactory.closeSession();
		return bloglist;
		
	}
	
	//获取分页的总页数
	public int getPageCount(User user){
		
		List<Blog> bloglist =dao.getAllBlog(user);
		int pageSize = 5;//默认每页数据大小
		int dataCount = bloglist.size();//总数据量
		int pageCount=dataCount/pageSize;//总页数
		
		//计算总页数
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
	
	//分页显示用户日志,返回一个动态数组，包含5个blog对象,
	@SuppressWarnings({ "null" })
	public List<Blog> getBlogByPageService(User user,int pageIndex) {
		//获取数据库中的所有日志
		List<Blog> bloglist =dao.getAllBlog(user);	
		
		ArrayList<Blog> blogpagelist = new ArrayList<>() ;
		
		//默认每页显示5条记录
		for(int i=(pageIndex-1)*5;(i<(pageIndex-1)*5+5)&&(i<bloglist.size());i++){
			blogpagelist.add(bloglist.get(i));
		}
		
		return blogpagelist;//#####这个地方不知道使用过后会不会被置null，可能下次使用的时候出错
		
	}
	
	
	//删除用户日志
	public boolean delBlogService(int blogId){
		

		return dao.delBlogByUser(blogId);
		
	}
	//添加日志
	public boolean insertBlogByUserService(Blog blog){
		
		return dao.insertBlogByUser(blog);		
	
    }
	//修改日志
	public boolean changeBlogByUserService(Blog blog){
		
		return dao. changeBlogByUser(blog);				
		
	}

	
	public Blog findBlogListByUserService(User user,String BlogTitle){
			
		return dao.findBlogByUser(user,BlogTitle);
	}
	//这里么有进行测试
	public Blog findBlogByBlodIdService(int blogId){
		
		return dao.findBlog(blogId);
	}

	
	
	
	
}
