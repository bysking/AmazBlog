package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Blog;
import com.amzblog.model.User;

public interface BlogDao {

	//ͨ��blogId��ѯ��־
	public Blog findBlog(int blogId);
	
	//ͨ��blogTitle��ѯ��־
	public Blog findBlogByUser(User user,String blogTitle);
	
	//�����û�������־
	public List<Blog> getAllBlog(User user);
	
	//����û���־
	public boolean insertBlogByUser(Blog blog);
	
	//ɾ���û���־
	public boolean delBlogByUser(int blogId);

	//�޸��û���־
	public boolean changeBlogByUser(Blog blog);

	//��ʱ����
	
	//����ɾ��
	//public int delBlogByUser(List<User> userlist);
	
	//���޻��߱���
	//int star_diss(int id, int star_or_diss);
		
			
}
