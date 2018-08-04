package com.amzblog.dao;

import com.amzblog.model.User;

public interface UserDao {
	
	//按ID查询
	User find(int userId);
	
	//按用户名查询
	User find(String userName);
		
	//注册用户
	boolean add(User user);
	
	//用户登录
	User login(String userName,String userPassword);
	
	//用户修改信息
	boolean change(User user);
	
	//用户注销
	boolean del(String userName);
}
