package com.amzblog.junit.serviceTest;

import static org.junit.Assert.*;

import java.util.List;

import com.amzblog.model.*;

import org.junit.Test;

import com.amzblog.service.FriendshipService;

public class FriendshipTest {

//	@Test
//	public void test() {
//		FriendshipService fs=FriendshipService.getInstance();
//		String userName="haitao";
//		List<User> fl=fs.getFriendInfo(userName);
//		for(User u:fl){
//			System.out.println(u.getUsername());
//		}
//	}
	
	@Test
	public void test(){
		FriendshipService fs=FriendshipService.getInstance();
		String userName="haitao";
		String friendName="test11";
		boolean result=fs.addFriend(userName, friendName);
		System.out.println(result);
	}

}
