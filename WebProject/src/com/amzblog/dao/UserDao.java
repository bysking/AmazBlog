package com.amzblog.dao;

import com.amzblog.model.User;

public interface UserDao {
	
	//��ID��ѯ
	User find(int userId);
	
	//���û�����ѯ
	User find(String userName);
		
	//ע���û�
	boolean add(User user);
	
	//�û���¼
	User login(String userName,String userPassword);
	
	//�û��޸���Ϣ
	boolean change(User user);
	
	//�û�ע��
	boolean del(String userName);
}
