package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.amzblog.dao.FeelingDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.FeelingDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;
import com.amzblog.utils.DateUtils;

public class FeelingTest {
	static FeelingDao dao = FeelingDaoImpl.getInstance();
//	@Test
//	public void test() {
//		UserDao userDao = UserDaoImpl.getInstance();
//		User user = userDao.find(1);
//		
//		Feeling feeling = new Feeling();
//		feeling.setFeelId(1);
//		feeling.setUser(user);
//		feeling.setFeelContent("ºÃÊæ·þ°¡");
//		feeling.setFeelCreateTime(DateUtils.toTimestamp(new Date()));
//		
//		int i = dao.insertFeelingByUser(user, feeling);
//		System.out.println(i);
//	}

}
