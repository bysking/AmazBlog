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
	
	//���캯������һ���û���Ϊ����
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
	



	
	       //��ѯ�û�����
			public List<Comment> findCommentByUserService(User user){
				
				return dao.findCommentByUser(user);
				
				
				
				
			}
			
			//ɾ���û�����
			public boolean delCommentByUserService(int commentId){
				
				return dao.delCommentByUser(commentId);
				
				
			}
			
			//����û�����
			public boolean insertCommentByUserService(Comment comment){
				return dao.insertCommentByUser(comment);
				
			}
			
			//�޸��û�����
			public boolean changeCommentByUserService(Comment comment){
				return dao.changeCommentByUser(comment);
				
				
			}
			
			
			//��ȡĳһƪ��־�����е�����
			public List<Comment> getAllCommentService(Blog blog ){
				return dao.getAllComment(blog);
				//dao.getAllComment(blog);
				
			}

			
//			//ͨ��ĳһ�в�ѯ����
//
//			public	List<Comment> getCommentByColumn(String column, String value) {
//				
//				return dao.getCommentByColumn(column, value);
//			}
//
//	
	
}
