package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.amzblog.dao.FriendshipDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.FriendshipDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Friendship;
import com.amzblog.model.User;

public class FriendTest {

//	@Test
//	public void test() {
//		UserDao dao = new UserDaoImpl();
//		User user = dao.find(1);
//		Set set = user.getFriendshipsForUserId();
//		Iterator iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Object object = iterator.next();
//			Friendship temp = (Friendship) object;
//			
//			System.out.println(temp.getUserByFriendId().getUsername());
//		}
//		
//	}
	
//	@Test
//	public void test(){
//		UserDao dao=new UserDaoImpl();
//		FriendshipDao fdao=new FriendshipDaoImpl();
//		String userName="test";
//		String friendName="test12";
//		boolean result=fdao.addFriend(userName, friendName);
//		System.out.println(result);
//	}

}
