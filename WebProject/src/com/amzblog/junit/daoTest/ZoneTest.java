package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.amzblog.dao.UserDao;
import com.amzblog.dao.ZoneDao;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.daoImpl.ZoneDaoImpl;
import com.amzblog.model.Friendship;
import com.amzblog.model.User;
import com.amzblog.model.Zone;
import com.amzblog.utils.DateUtils;

public class ZoneTest {
	static ZoneDao dao = ZoneDaoImpl.getInstance();
//	@Test
//	public void findTest() {
//		Zone zone = dao.findZone(1);
//		System.out.println(zone.getZoneId() + " " + zone.getUser().getUsername() + " " +zone.getZoneName());
//	}
	
//	@Test
//	public void addTest() {
//		Zone zone = new Zone();
//		UserDao userdao =  UserDaoImpl.getInstance();
//		User user = userdao.find(2);
//		
//		zone.setUser(user);
//		zone.setZoneName("user2's zone");
//		zone.setZoneCreateDate(DateUtils.toTimestamp(new Date()));
//		dao.addZone(zone);
//		System.out.println("Add a zone!");
//	}
	
//	@Test
//	public void changeTest() {
//		Zone zone = dao.findZone(2);
//		zone.setZoneName("name changed");
//		dao.changeZone(zone);
//		System.out.println("changed zone" + zone.getZoneId());
//	}
	
//	@Test
//	public void delete() {
//		Zone zone = dao.findZone(2);
//		dao.deleteZone(zone);
//		System.out.println("delete zone" + zone.getZoneId());
//	}
	

}
