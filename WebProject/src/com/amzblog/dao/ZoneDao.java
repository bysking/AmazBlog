package com.amzblog.dao;

import com.amzblog.model.Zone;

public interface ZoneDao {
	
	//ͨ��ZoneId���ҿռ�
	public Zone find(int noneId);
	
	//ͨ��userId���ҿռ�
	public Zone findZone(int userId);
	
	//�½��ռ�
	boolean addZone(Zone zone);
	
	//�޸Ŀռ���Ϣ
	boolean changeZone(Zone zone);
	
	//ɾ���ռ�
	boolean deleteZone(Zone zone);
	


}
