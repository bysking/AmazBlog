package com.amzblog.dao;

import com.amzblog.model.Admin;
import com.amzblog.model.User;

public interface AdminDao {
	
	//按ID查询管理员
	Admin find(int adminId);
		
	//按用户名查询管理员
	Admin find(String adminUsername);
		
	//新建管理员
	boolean add(Admin admin);
	
	//管理员登录
	Admin login(String adminUsername,String adminPassword);
	
	//管理员修改信息
	boolean change(Admin admin);
	
	//管理员注销
	boolean del(String userName);
	

}
