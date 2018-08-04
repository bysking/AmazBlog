package com.amzblog.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.amzblog.dao.BlogDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.User;
import com.amzblog.service.BlogService;
import com.amzblog.utils.DateUtils;

public class BlogServiceTest {
//	@SuppressWarnings("null")
//	@Test
//	public void addtest() {
//
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		
//		//System.out.println(user.getUsername());
//		
//		Blog blog=new Blog();
//		
//		
//		String title = "userBlogtitle";
//		String blogContent = "userBloblogContent";		
//		//User user=dao2.find(1);;
//		//blog.setBlogTitle(title);
//		blog.setUser(user);
//		blog.setBlogTitle(title);
//		blog.setBlogContent(blogContent);
//		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		//blog.setBlogCreateTime(blogCreateTime);
//	    BlogService ts = BlogService.getInstance();
//		//BlogService ts =new BlogService(user);
//		ts.insertBlogByUserService(blog);
//		//System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//	
//		//System.out.println("hello");
//	}
//	@Test
//	public void deltest() {
//
//		
////		UserDao dao2 = UserDaoImpl.getInstance();
////		User user = dao2.find(1);
////		
////		//System.out.println(user.getUsername());
////		
////		Blog blog=new Blog();
////		
////		
////		String title = "userBlogtitle";
////		String blogContent = "userBloblogContent";		
////		//User user=dao2.find(1);;
////		//blog.setBlogTitle(title);
////		blog.setUser(user);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		//blog.setBlogCreateTime(blogCreateTime);
//	    BlogService ts = BlogService.getInstance();
//		//BlogService ts =new BlogService(user);
//		ts.delBlogService(7);
//		//System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//	
//		//System.out.println("hello");
//	}
	
//	@Test
//	public void changetest() {
//
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
////		
////		//System.out.println(user.getUsername());
////		
//		Blog blog=new Blog();
////		
////		
//		String title = "userBlog";
//		String blogContent = "标题：userBlogtitle，更改内容";
//		blog.setUser(user);
//	
//		blog.setBlogId(6);
//		blog.setBlogTitle(title);
//		blog.setBlogContent(blogContent);
//		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//		//BlogService ts =new BlogService(user);
//		ts.changeBlogByUserService(blog);
//		//System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//	
//		//System.out.println("hello");
//	}
	
//	@Test
//	public void findtest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
////		
////		Blog blog=new Blog();
////		
////		String title = "userBlog";
////		String blogContent = "标题：userBlogtitle，更改内容";
////		blog.setUser(user);
////	
////		blog.setBlogId(6);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	    String title = "blogcpx";
//		Blog blog=ts.findBlogListByUserService(user,title);
//		System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//
//	}
	
//	@Test
//	public void findalltest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
////		
////		Blog blog=new Blog();
////		
////		String title = "userBlog";
////		String blogContent = "标题：userBlogtitle，更改内容";
////		blog.setUser(user);
////	
////		blog.setBlogId(6);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	   // String title = "blogcpx";
//		List<Blog> bloglist=ts.getAllBlogService(user);
//		for(Blog blog:bloglist){	
//			System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//		}
//		

//	@Test
//	public void getpagecounttest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
////		
////		Blog blog=new Blog();
////		
////		String title = "userBlog";
////		String blogContent = "标题：userBlogtitle，更改内容";
////		blog.setUser(user);
////	
////		blog.setBlogId(6);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//	   System.out.println("分页数量"+ts.getPageCount(user)); 
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	   // String title = "blogcpx";
////		List<Blog> bloglist=ts.getAllBlogService(user);
////		for(Blog blog:bloglist){	
////			System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
////		}
		
//	@Test
//	public void getpagecounttest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(7);
////		
////		Blog blog=new Blog();
////		
////		String title = "userBlog";
////		String blogContent = "标题：userBlogtitle，更改内容";
////		blog.setUser(user);
////	
////		blog.setBlogId(6);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//	   System.out.println("用户"+user.getUserId()+"的博客数量："+ts.getBlogCount(user)); 
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	   // String title = "blogcpx";
////		List<Blog> bloglist=ts.getAllBlogService(user);
////		for(Blog blog:bloglist){	
////			System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
////		}
	
//	@Test
//	public void getpagecounttest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
////		
////		Blog blog=new Blog();
////		
////		String title = "userBlog";
////		String blogContent = "标题：userBlogtitle，更改内容";
////		blog.setUser(user);
////	
////		blog.setBlogId(6);
////		blog.setBlogTitle(title);
////		blog.setBlogContent(blogContent);
////		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//	    BlogService ts = BlogService.getInstance();
//	  //  System.out.println("用户"+user.getUserId()+"的博客数量："+ts.getBlogCount(user)); 
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	   // String title = "blogcpx";
//		List<Blog> bloglist=ts.getBlogByPageService(user, 2);
//		for(Blog blog:bloglist){	
//			System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//		}
	
//	@Test
//	public void getpagecounttest() {
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		
//		Blog blog=new Blog();
//		
//		String title = "userBlog";
//		String blogContent = "标题：userBlogtitle，更改内容";
//		blog.setUser(user);
//	
//		blog.setBlogId(6);
//		blog.setBlogTitle(title);
//		blog.setBlogContent(blogContent);
//		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
		
//	    BlogService ts = BlogService.getInstance();
//	  //  System.out.println("用户"+user.getUserId()+"的博客数量："+ts.getBlogCount(user)); 
//		//BlogService ts =new BlogService(user);
//	    //获取用户对应标题的所有日志
//	   // String title = "blogcpx";
//		List<Blog> bloglist=ts.getBlogByPageService(user, 2);
//		for(Blog blog:bloglist){	
//			System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//		}
//		
//	}
}
