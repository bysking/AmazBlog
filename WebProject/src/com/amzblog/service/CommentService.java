package com.amzblog.service;

import java.util.List;

import com.amzblog.dao.CommentDao;
import com.amzblog.daoImpl.CommentDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;

public class CommentService {

	private CommentDao dao;

	private static User user;
	
	private static CommentService instance;
	
	//构造函数传入一个用户作为参数
	public CommentService( User user){
		dao=CommentDaoImpl.getInstance();	
		CommentService.user=user;
	}
	
	
	public static final CommentService getInstance() {
		if (instance == null) {
			try {
				instance = new CommentService(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	



	
	       //查询用户评论
			public List<Comment> findCommentByUserService(User user){
				
				return dao.findCommentByUser(user);
				
				
				
				
			}
			
			//删除用户评论
			public boolean delCommentByUserService(int commentId){
				
				return dao.delCommentByUser(commentId);
				
				
			}
			
			//添加用户评论
			public boolean insertCommentByUserService(Comment comment){
				return dao.insertCommentByUser(comment);
				
			}
			
			//修改用户评论
			public boolean changeCommentByUserService(Comment comment){
				return dao.changeCommentByUser(comment);
				
				
			}
			
			
			//获取某一篇日志的所有的评论
			public List<Comment> getAllCommentService(Blog blog ){
				return dao.getAllComment(blog);
				//dao.getAllComment(blog);
				
			}

			
//			//通过某一列查询文章
//
//			public	List<Comment> getCommentByColumn(String column, String value) {
//				
//				return dao.getCommentByColumn(column, value);
//			}
//
//	
	
}
