package com.amzblog.dao;

import com.amzblog.model.Zone;

public interface ZoneDao {
	
	//通过ZoneId查找空间
	public Zone find(int noneId);
	
	//通过userId查找空间
	public Zone findZone(int userId);
	
	//新建空间
	boolean addZone(Zone zone);
	
	//修改空间信息
	boolean changeZone(Zone zone);
	
	//删除空间
	boolean deleteZone(Zone zone);
	


}
