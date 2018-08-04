package com.amzblog.junit.serviceTest;

import static org.junit.Assert.*;

import com.amzblog.dao.*;
import com.amzblog.daoImpl.*;
import com.amzblog.model.*;

import org.junit.Test;

import com.amzblog.service.UserService;

public class UserServiceTest {

//	@Test
//	public void test() {
////		String userName="size";
////		UserService us=UserService.getInstance();
////		UserDao dao=UserDaoImpl.getInstance();
//		//boolean result=us.validateUser(userName);
//		//User user=us.findUser(userName);
//		//User user=dao.find(userName);
//		System.out.println("123");
//	}
	@Test
	public void test(){
		UserService us=UserService.getInstance();
		String userName="haita";
		boolean result=us.validateUser(userName);
		System.out.println(result);
	}

}
