package com.amzblog.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.amzblog.model.*;
import com.amzblog.dao.*;
import com.amzblog.daoImpl.*;
import com.amzblog.utils.*;

public class FriendshipService {
	
	private FriendshipDao fdao;
	private UserDao udao;
	
	private static FriendshipService instance;
	
	private  FriendshipService() {
		fdao =  FriendshipDaoImpl.getInstance();
		udao = UserDaoImpl.getInstance();
	}

	/**
	 * ��ȡʵ��
	 * 
	 * @return
	 */
	public static final FriendshipService getInstance() {
		if (instance == null) {
			try {
				instance = new FriendshipService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	//��ѯ�����б���Ϣ
	public List getFriendInfo(String userName){
		List<User> list=new ArrayList();
		List<Friendship> flist=fdao.friendInfo(userName);
		for(Friendship a:flist){
			list.add(a.getUserByFriendId());
		}
		return list;
	}
		
	//ɾ������
	public boolean deleteFriend(String userName,String friendName){
		return fdao.delFriend(userName, friendName);
	}
	
	
	//��Ӻ���
	public boolean addFriend(String userName,String friendName){
		return fdao.addFriend(userName, friendName);
	}
 	
	


}
