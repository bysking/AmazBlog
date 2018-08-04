package com.amzblog.dao;

import com.amzblog.model.Admin;
import com.amzblog.model.User;

public interface AdminDao {
	
	//��ID��ѯ����Ա
	Admin find(int adminId);
		
	//���û�����ѯ����Ա
	Admin find(String adminUsername);
		
	//�½�����Ա
	boolean add(Admin admin);
	
	//����Ա��¼
	Admin login(String adminUsername,String adminPassword);
	
	//����Ա�޸���Ϣ
	boolean change(Admin admin);
	
	//����Աע��
	boolean del(String userName);
	

}
