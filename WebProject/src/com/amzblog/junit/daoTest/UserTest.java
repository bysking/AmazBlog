package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.User;
import com.amzblog.model.Zone;
import com.amzblog.utils.TestSuit4Dao;

public class UserTest {

	@Test
	public void test(){
		UserDao dao = UserDaoImpl.getInstance();
		User user = dao.find("sese");
		if(user==null){
			System.out.println("null");
		}else{
			System.out.println(user.getUserNickname());
		}
		
	}
//	public void findTest1() {
//		UserDao dao = UserDaoImpl.getInstance();
//		User user = dao.find(1);
//		System.out.println(user.getUsername());
//	}

//	@Test
//	public void findTest2() {
//		UserDao dao = UserDaoImpl.getInstance();
//		User user = dao.find("292803281");
//		System.out.println(user.getUsername());
//	}
	
	//@Test
//	public void addTest() {
////		UserDao dao = UserDaoImpl.getInstance();
////		User user = new User();
////		user.setUsername("test");
////		user.setUserPassword("123");
////		user.setUserNickname("test");
////		user.setUserBlogAddr("www.test.com");
////		
////		dao.add(user);
////
////		User result = dao.find(user.getUserId());
////		System.out.println(result.getUserId()  + " " + result.getUserNickname());
//		
//		TestSuit4Dao.addUser();
//	}
	
//	@Test
//	public void changeTest() {
//		UserDao dao = UserDaoImpl.getInstance();
//		User user = dao.find("shatao");
//		user.setUsername("sizhe");
//		user.setUserPassword("123");
//		user.setUserNickname("ЫЇем");
//		user.setUserBlogAddr("www.shuaizhe.com");
//		
//		dao.change(user);
//		
//		User result = dao.find(user.getUsername());
//		System.out.println(result.getUserId() + " " + result.getUserNickname());
//	}
	
	
//	@Test
//	public void delTest() {
//		UserDao dao = UserDaoImpl.getInstance();
//		
//		//add first
//		User user = new User();
//		user.setUsername("deltest");
//		user.setUserPassword("123");
//		user.setUserNickname("deltest");
//		user.setUserBlogAddr("www.deltest.com");
//		dao.add(user);
//		
//		User result = dao.find("deltest");
//		System.out.println(result.getUserId()  + " " + result.getUserNickname());
//		
//		dao.del("deltest");
//		
//		result = dao.find("deltest");
//		if (result == null) {
//			System.out.println("delete successfully");
//		}
	
//	@Test 
//	public void loginTest() {
//		UserDao dao = UserDaoImpl.getInstance();
//		
//		String Username = "sizhe";
//		String Password = "123";
//		User user = dao.login(Username, Password);
//		if (user == null) {
//			System.out.println("login failed");
//		} else {
//			System.out.println(user.getUserNickname() + " login successfully");
//		}
//		
//	}
}
