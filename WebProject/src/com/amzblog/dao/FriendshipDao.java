package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.User;
import com.amzblog.model.Friendship;

public interface FriendshipDao {
	
	//查询好友列表信息
	List<Friendship> friendInfo(String userName);
	
	//判断双方是否是好友
	boolean isFriend(String userName,String friendName);
	
	//添加好友
	boolean addFriend(String userName,String friendName);
	
	//删除好友
	boolean delFriend(String userName,String friendName);
	



}
