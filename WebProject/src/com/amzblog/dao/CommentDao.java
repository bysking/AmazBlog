package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;

public interface CommentDao {

		//通过commentId查找评论
		public Comment find(int commentId);
	
	    //查询用户发出所有的评论
		public List<Comment> findCommentByUser(User user);
		
		//删除用户发出的评论
		public boolean delCommentByUser(int commentId);
		
		//添加用户发出的评论
		public boolean insertCommentByUser(Comment comment);
		
		//修改用户发出的评论
		public boolean changeCommentByUser(Comment comment);
		
		//获取某一篇日志的所有的评论
		public List<Comment> getAllComment(Blog blog);
		
		

		/**
		 * 浏览了文章 增加文章的浏览次数
		 * 
		 * @param article_id
		 */
		//void addVisit(int article_id);
		
		/**
		 * 获取阅读排行文章列表
		 * 
		 * @return
		 */
		//List<Comment> getVisitRank();

		/**
		 * 通过某一列查询文章
		 * 
		 * @param column
		 * @param value
		 * @return
		 */
		//List<Comment> getArticleByColumn(String column, String value);
		//通过某一列查询文章
		//public List<Comment> getCommentByColumn(String column, String value);

		/**
		 * 获取博客 对应评论的数量
		 * 
		 * @param search_key
		 * @return
		 */
		//int getCommentCount(Blog blog);

		/**
		 * 点赞了文章
		 * 
		 * @param id
		 * @return
		 */
		//int star_article(int id);

		/**
		 * 更新了类别
		 * 
		 * @param old_sort
		 * @param new_sort
		 * @return
		 */
		//boolean updateSort(String old_sort, String new_sort);
}
