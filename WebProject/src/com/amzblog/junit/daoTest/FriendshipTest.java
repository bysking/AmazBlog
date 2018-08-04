package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.amzblog.dao.FriendshipDao;
import com.amzblog.daoImpl.FriendshipDaoImpl;
import com.amzblog.model.Friendship;

public class FriendshipTest {

//	@Test
//	public void test() {
//		String[] users = {"sizhe","shatao", "pengxu","xiaomei"};
//		
//		FriendshipDao friendshipDao = FriendshipDaoImpl.getInstance();
//		for (int i=0; i<users.length; i++) {
//			for (int j=i; j<users.length; j++) {
//				friendshipDao.addFriend(users[i], users[j]);
//			}
//		}
//		List<Friendship> ulist1 = friendshipDao.friendInfo(users[0]);
//		List<Friendship> ulist2 = friendshipDao.friendInfo(users[1]);
//		List<Friendship> ulist3 = friendshipDao.friendInfo(users[2]);
//		List<Friendship> ulist4 = friendshipDao.friendInfo(users[3]);
//		
//		
//		System.out.println("user:"+ users[0] +" friendlist: ");
//		for (int i=0;i<ulist1.size();i++) {
//			System.out.println(ulist1.get(i).getUserByFriendId().getUsername());
//		}
//		
//		System.out.println("user:"+ users[1] +" friendlist: ");
//		for (int i=0;i<ulist2.size();i++) {
//			System.out.println(ulist2.get(i).getUserByFriendId().getUsername());
//		}
//		
//		System.out.println("user:"+ users[2] +" friendlist: ");
//		for (int i=0;i<ulist3.size();i++) {
//			System.out.println(ulist3.get(i).getUserByFriendId().getUsername());
//		}
//		
//		System.out.println("user:"+ users[3] +" friendlist: ");
//		for (int i=0;i<ulist4.size();i++) {
//			System.out.println(ulist4.get(i).getUserByFriendId().getUsername());
//		}
//	}

}
