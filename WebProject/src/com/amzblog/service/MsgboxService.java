package com.amzblog.service;

import com.amzblog.dao.MsgboxDao;
import com.amzblog.daoImpl.MsgboxDaoImpl;
import com.amzblog.model.Message;
import com.amzblog.model.Msgbox;
import com.amzblog.model.User;

public class MsgboxService {

	private MsgboxDao dao;
	private static User user;
	private static MsgboxService instance;
	
	//构造函数传入一个用户作为参数
	private MsgboxService( User user){
		dao=MsgboxDaoImpl.getInstance();	
		MsgboxService.user=user;
	}
	
	public static final MsgboxService getInstance() {
		if (instance == null) {
			try {
				instance = new MsgboxService(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	

//	public Msgbox findMsgboxService(User user) {
//		// TODO Auto-generated method stub
//		return dao.
//	}


	public boolean addMsgboxService(User user,Message message) {
		// TODO Auto-generated method stub
		return dao.addMsgbox(user, message);
	}

//	public int changeMsgboxService(User user,int MsgboxId) {
//		// TODO Auto-generated method stub
//		return dao.
//	}
	
	
	
	
	
}
