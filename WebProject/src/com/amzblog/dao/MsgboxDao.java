package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Message;
import com.amzblog.model.Msgbox;
import com.amzblog.model.User;

public interface MsgboxDao {

	//msgboxʵ����ָ����һ�Ρ���Ϣ���ĸ��û��յ����Ĺ�ϵ���޷�����ɾ����ֻ����Message������ɾ��
	
	//��һ����Ϣ�������������û��յ���Ϣ��������һ��Msgbox��ϵ
	public boolean addMsgbox(User user, Message message);
		
}
