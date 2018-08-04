package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.swing.border.TitledBorder;

import org.junit.Test;

import java.util.List;

import com.amzblog.dao.BlogDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.User;
import com.amzblog.utils.DateUtils;
import com.amzblog.utils.TestSuit4Dao;
import com.mysql.fabric.xmlrpc.base.Data;


public class BlogTest {

//	@Test
//	public void findTest() {
//		BlogDao dao1 = BlogDaoImpl.getInstance();
//		UserDao dao2 = UserDaoImpl.getInstance();
//		
//		String title = "userBlog";
//		User user = dao2.find(1);
//		Blog blog = dao1.findBlogByUser(user, title);
//		
//		System.out.println(blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
//	}

//	@Test
//	public void insertTest() throws ParseException {
//		TestSuit4Dao.addBlog();
//	}

//	@Test
//	public void delTest() {
//		BlogDao dao1 = BlogDaoImpl.getInstance();
//		UserDao dao2 = UserDaoImpl.getInstance();
//		
//		User user = dao2.find(7);
//		String title = "Breaking News";
//		
//		Blog blog = dao1.findBlogByUser(user, "Breaking News");
//		
//		int result = dao1.delBlogByUser(user, blog.getBlogId());
//		
//		if (result == 1) {
//			System.out.println("delete successfully");
//		}
//	}
	
//	@Test
//	public void changeTest() {
//		BlogDao dao1 = BlogDaoImpl.getInstance();
//		UserDao dao2 = UserDaoImpl.getInstance();
//		
//		User user = dao2.find(7);
//		String title = "Breaking News";
//		
//		Blog blog = dao1.findBlogByUser(user, "Breaking News");
//		
//		blog.setBlogTitle("title changed");
//		blog.setBlogContent("content changed");
//		blog.setBlogCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		int result = dao1.changeBlogByUser(user, blog);
//		
//		if (result == 1) {
//			System.out.println("change successfully");
//		}
//	}
	
//	@Test 
//	public void findAllBlogTest() {
//		BlogDao dao1 = BlogDaoImpl.getInstance();
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		List<Blog> blogs = dao1.getAllBlog(user);
//		for(int i = 0; i < blogs.size(); i++) {
//			System.out.println(blogs.get(i).getBlogTitle());
//		}
//
//	}

}
