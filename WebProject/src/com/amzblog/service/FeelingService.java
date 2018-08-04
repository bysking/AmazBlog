package com.amzblog.service;

import java.util.List;

import com.amzblog.dao.BlogDao;
import com.amzblog.dao.FeelingDao;
import com.amzblog.daoImpl.BlogDaoImpl;
import com.amzblog.daoImpl.FeelingDaoImpl;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;

public class FeelingService {

	private FeelingDao dao;
	private static User user;
	private static FeelingService instance;
	
	//构造函数传入一个用户作为参数
	private FeelingService( User user){
		dao=FeelingDaoImpl.getInstance();	
		FeelingService.user=user;
	}
	
	public static final FeelingService getInstance() {
		if (instance == null) {
			try {
				instance = new FeelingService(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public Feeling findRecentFeelingByUserService(User user) {
		// TODO Auto-generated method stub
		return dao.findRecentFeelingByUser(user);
	}

	public List<Feeling> findAllFeelingByUserService(User user) {
		// TODO Auto-generated method stub
		return dao.findAllFeelingByUser(user);
	}


	public boolean delFeelingByUserService(Feeling feeling) {
		// TODO Auto-generated method stub
		return dao.delFeelingByUser(feeling);
	}


	public boolean insertFeelingByUserService(Feeling feeling) {
		// TODO Auto-generated method stub
		return dao.insertFeelingByUser(feeling);
	}

	public boolean changeFeelingByUserService(Feeling feeling) {
		// TODO Auto-generated method stub
		return dao.changeFeelingByUser(feeling);
	}
	
	public Feeling findById(int id){
		
		return dao.find(id);
	}
	
}
