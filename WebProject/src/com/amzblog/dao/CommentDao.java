package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;

public interface CommentDao {

		//ͨ��commentId��������
		public Comment find(int commentId);
	
	    //��ѯ�û��������е�����
		public List<Comment> findCommentByUser(User user);
		
		//ɾ���û�����������
		public boolean delCommentByUser(int commentId);
		
		//����û�����������
		public boolean insertCommentByUser(Comment comment);
		
		//�޸��û�����������
		public boolean changeCommentByUser(Comment comment);
		
		//��ȡĳһƪ��־�����е�����
		public List<Comment> getAllComment(Blog blog);
		
		

		/**
		 * ��������� �������µ��������
		 * 
		 * @param article_id
		 */
		//void addVisit(int article_id);
		
		/**
		 * ��ȡ�Ķ����������б�
		 * 
		 * @return
		 */
		//List<Comment> getVisitRank();

		/**
		 * ͨ��ĳһ�в�ѯ����
		 * 
		 * @param column
		 * @param value
		 * @return
		 */
		//List<Comment> getArticleByColumn(String column, String value);
		//ͨ��ĳһ�в�ѯ����
		//public List<Comment> getCommentByColumn(String column, String value);

		/**
		 * ��ȡ���� ��Ӧ���۵�����
		 * 
		 * @param search_key
		 * @return
		 */
		//int getCommentCount(Blog blog);

		/**
		 * ����������
		 * 
		 * @param id
		 * @return
		 */
		//int star_article(int id);

		/**
		 * ���������
		 * 
		 * @param old_sort
		 * @param new_sort
		 * @return
		 */
		//boolean updateSort(String old_sort, String new_sort);
}
