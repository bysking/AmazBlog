package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.User;
import com.amzblog.model.Friendship;

public interface FriendshipDao {
	
	//��ѯ�����б���Ϣ
	List<Friendship> friendInfo(String userName);
	
	//�ж�˫���Ƿ��Ǻ���
	boolean isFriend(String userName,String friendName);
	
	//��Ӻ���
	boolean addFriend(String userName,String friendName);
	
	//ɾ������
	boolean delFriend(String userName,String friendName);
	



}
