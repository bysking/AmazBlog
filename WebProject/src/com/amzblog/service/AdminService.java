package com.amzblog.service;

import com.amzblog.model.*;
import com.amzblog.dao.*;
import com.amzblog.daoImpl.*;

public class AdminService {
	
	private AdminDao dao;
	
	private static AdminService instance;
	
	private  AdminService() {
		dao =  AdminDaoImpl.getInstance();
	}
	
	/**
	 * »ñÈ¡ÊµÀý
	 * 
	 * @return
	 */
	public static final AdminService getInstance() {
		if (instance == null) {
			try {
				instance = new AdminService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	public Admin adminLogin(String adminName,String adminPassword){
		return dao.login(adminName, adminPassword);
	}
	
}
