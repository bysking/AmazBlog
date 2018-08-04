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
	 * ��ȡʵ��
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
	
	//��֤�û��Ƿ����
	public boolean validateUser(String userName){
		boolean b=false;
		if(dao.find(userName)!=null){
			b=true;
		}
		return b;
	}
	
	//���û��������û�
	public User findUser(String userName){
		return dao.find(userName);
	}
	
	//�û�ע��
	public void register(User user){
		dao.add(user);
	}
	
	//�û���¼
	public User login(String userName,String userPassword){
		return dao.login(userName, userPassword);
	}
	
	//�û��޸���Ϣ
	public void updateInfo(User user){
		dao.change(user);
	}
	
	//�û�ע����Ϣ
	public void delete(String userName){
		dao.del(userName);
	}

}
