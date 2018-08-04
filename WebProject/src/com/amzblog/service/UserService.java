package com.amzblog.service;

import com.amzblog.model.*;
import com.amzblog.dao.*;
import com.amzblog.daoImpl.*;

public class UserService {
	
	private UserDao dao;
	
	private static UserService instance;
	
	private  UserService() {
		dao =  UserDaoImpl.getInstance();
	}
	
	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static final UserService getInstance() {
		if (instance == null) {
			try {
				instance = new UserService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	//验证用户是否存在
	public boolean validateUser(String userName){
		boolean b=false;
		if(dao.find(userName)!=null){
			b=true;
		}
		return b;
	}
	
	//按用户名查找用户
	public User findUser(String userName){
		return dao.find(userName);
	}
	
	//用户注册
	public void register(User user){
		dao.add(user);
	}
	
	//用户登录
	public User login(String userName,String userPassword){
		return dao.login(userName, userPassword);
	}
	
	//用户修改信息
	public void updateInfo(User user){
		dao.change(user);
	}
	
	//用户注销信息
	public void delete(String userName){
		dao.del(userName);
	}

}
