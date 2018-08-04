package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Blog;
import com.amzblog.model.User;

public interface BlogDao {

	//通过blogId查询日志
	public Blog findBlog(int blogId);
	
	//通过blogTitle查询日志
	public Blog findBlogByUser(User user,String blogTitle);
	
	//返回用户所有日志
	public List<Blog> getAllBlog(User user);
	
	//添加用户日志
	public boolean insertBlogByUser(Blog blog);
	
	//删除用户日志
	public boolean delBlogByUser(int blogId);

	//修改用户日志
	public boolean changeBlogByUser(Blog blog);

	//暂时不用
	
	//批量删除
	//public int delBlogByUser(List<User> userlist);
	
	//点赞或者鄙视
	//int star_diss(int id, int star_or_diss);
		
			
}
