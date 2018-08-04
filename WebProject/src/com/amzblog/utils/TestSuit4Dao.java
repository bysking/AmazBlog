package com.amzblog.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import com.amzblog.model.*;
import com.amzblog.dao.*;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;

public class TestSuit4Dao {

	public static void addUser() {
		
		UserDao dao = UserDaoImpl.getInstance();
		User user = new User();
		UserDaoImpl dao1 = new UserDaoImpl();
		
		int count = dao1.findAll().size();
		count++;
		
		user.setUsername("test" + count);
		user.setUserPassword("123");
		user.setUserNickname("test" + count);
		user.setUserBlogAddr("www.test.com");

		dao.add(user);
	}
	
	public static void addBlog() throws ParseException {
		
		UserDao dao = UserDaoImpl.getInstance();
		BlogDao bDao = BlogDaoImpl.getInstance();
		
		User user = dao.find(1);
		
		BlogDao dao1 = BlogDaoImpl.getInstance();
		
		int count = user.getBlogs().size();
		count++;
		
		Blog blog = new Blog();
		blog.setUser(user);
		blog.setBlogTitle("new blog" + count);
		blog.setBlogContent("content");
		
		Timestamp  ts=DateUtils.toTimestamp(new Date());
		blog.setBlogCreateTime(ts);
		
		//bDao.insertBlogByUser(user, blog);
		
		System.out.println("Add a blog to user(id = 1) :" + blog.getBlogTitle() + " " + blog.getUser().getUsername() + " " + blog.getBlogContent());
		
	}
}
