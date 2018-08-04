package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.amzblog.dao.BlogDao;
import com.amzblog.dao.CommentDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.daoImpl.CommentDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;
import com.amzblog.utils.DateUtils;

public class CommentTest {
	static CommentDao dao = CommentDaoImpl.getInstance();
//	@Test
//	public void addTest() {
//		UserDao userDao = UserDaoImpl.getInstance();
//		BlogDao blogDao = BlogDaoImpl.getInstance();
//		
//		User user = userDao.find(1);
//		
//		Set set = user.getBlogs();
//		Iterator<Blog> iterator = set.iterator();
//		ArrayList<Blog> blogs = new ArrayList<>();
//		while(iterator.hasNext())
//		{
//			Blog blog = iterator.next();
//			blogs.add(blog);
//			System.out.println(blog.getBlogTitle());
//		}
//		
//		User user2 = userDao.find(2);
//		
//		Blog blog = blogDao.findBlog(blogs.get(2).getBlogId());
//		Comment comment = new Comment();
//		comment.setBlog(blogs.get(0));
//		comment.setUser(user2);
//		comment.setCommContent("∫√Àß≈∂£°");
//		comment.setCommCreateTime(DateUtils.getCurrTime());
//		
//		dao.insertCommentByUser(user, comment);
//		System.out.println("add a comment on blog:" + blogs.get(2).getBlogTitle() + " comment content:" + comment.getCommContent());
//	}

//	@Test
//	public void findTest() {
//		BlogDao blogDao = BlogDaoImpl.getInstance();
//		
//		
//		Blog blog = blogDao.findBlog(6);
//		List<Comment> list = dao.getAllComment(blog);
//		
//		System.out.println("Blog" + blog.getBlogId() + " received comments:");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getCommId()+" "+
//					list.get(i).getCommContent() + 
//					" " + list.get(i).getCommCreateTime());
//		}
//
//	}
//	
//	@Test 
//	public void findUserComm() {
//		UserDao userDao = UserDaoImpl.getInstance();
//		User user = userDao.find(1);
//		List<Comment> list2 = dao.findCommentByUser(user);
//		
//		System.out.println("User" + user.getUserId() + " send comments:");
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i).getCommId()+" "+
//					list2.get(i).getCommContent() + 
//					" " + list2.get(i).getCommCreateTime());
//		}
//	}
}
