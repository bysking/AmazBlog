package com.amzblog.service;


import com.amzblog.model.*;
import com.amzblog.dao.*;
import com.amzblog.daoImpl.*;

public class ZoneService {
	
	private ZoneDao dao;
	
	private static ZoneService instance;
	
	private  ZoneService() {
		dao =  ZoneDaoImpl.getInstance();
	}
	
	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static final ZoneService getInstance() {
		if (instance == null) {
			try {
				instance = new ZoneService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	//用户id寻找空间
	public Zone findZone(int userId){
		return dao.findZone(userId);
	}
	//修改空间信息
	public void updateZone(Zone zone){
		dao.changeZone(zone);
	}
	//创建空间
	public void addZone(Zone zone){
		dao.addZone(zone);
	}

}
