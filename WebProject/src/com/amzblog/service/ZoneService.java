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
	 * ��ȡʵ��
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
	
	//�û�idѰ�ҿռ�
	public Zone findZone(int userId){
		return dao.findZone(userId);
	}
	//�޸Ŀռ���Ϣ
	public void updateZone(Zone zone){
		dao.changeZone(zone);
	}
	//�����ռ�
	public void addZone(Zone zone){
		dao.addZone(zone);
	}

}
