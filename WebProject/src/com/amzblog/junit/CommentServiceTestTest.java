package com.amzblog.junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
import com.amzblog.service.BlogService;
import com.amzblog.service.CommentService;
import com.amzblog.utils.DateUtils;

public class CommentServiceTestTest {

//	@Test
//	public void findalltest() {
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		CommentService ts=CommentService.getInstance();
//		
//		BlogService tsblog = BlogService.getInstance();
////			//BlogService ts =new BlogService(user);
////		    //获取用户对应标题的所有日志
//		//String title = "userblog";
//		Blog blog=tsblog.findBlogByBlodIdService(1);
//	
//    List<Comment> commentlist=ts.getAllCommentService(blog);
//   for(Comment x:commentlist){	
//	System.out.println(x.getCommId()+ " " +x.getCommContent());
//}
//	}

//	@Test
//	public void deltest() {
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		CommentService ts=CommentService.getInstance();
//		ts.delCommentByUserService(user, 3);
//  
//	}
	
	
//	@Test
//	public void addtest() {
//		
//		BlogDao dao1=BlogDaoImpl.getInstance();	
//		Blog blog=dao1.findBlog(6);
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//		
//		Comment comment=new Comment();
//		comment.setUser(user);
//		comment.setCommContent("666666666666666666666666");
//		comment.setBlog(blog);
//		comment.setCommCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		CommentService ts=CommentService.getInstance();
//		ts.insertCommentByUserService(user, comment);
//
//	}

//	@Test
//	public void changetest() {
//		
//		BlogDao dao1=BlogDaoImpl.getInstance();	
//		Blog blog=dao1.findBlog(6);
//		
//		CommentDao dao3=CommentDaoImpl.getInstance();	
//		
//		//获取指定id的comment
//		Comment comment=dao3.find(4);
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//
//		comment.setCommContent("000000000000000000000000");
//		comment.setCommCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		CommentService ts=CommentService.getInstance();
//		ts.changeCommentByUserService(comment);
//
//	}
	
//	@Test
//	public void changetest() {
//		
//		BlogDao dao1=BlogDaoImpl.getInstance();	
//		Blog blog=dao1.findBlog(6);
//		
//		CommentDao dao3=CommentDaoImpl.getInstance();	
//		
//		//获取指定id的comment
//		Comment comment=dao3.find(4);
//		
//		UserDao dao2 = UserDaoImpl.getInstance();
//		User user = dao2.find(1);
//
//		comment.setCommContent("000000000000000000000000");
//		comment.setCommCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		CommentService ts=CommentService.getInstance();
//		ts.changeCommentByUserService(comment);
//
//	}

}
