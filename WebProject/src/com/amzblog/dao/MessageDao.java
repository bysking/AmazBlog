package com.amzblog.dao;


import java.util.List;

import com.amzblog.model.Message;
import com.amzblog.model.User;

public interface MessageDao {

	//��ȡ���û���������������
    public List<Message> findAllMessage(User user);
    
    //��ѯ���԰��ϵ��û������б���Ϣ
    public List<Message> findReceivedMsgs(User user);

    //ͨ��ID��ѯһ����Ϣ
    public Message find(int messageId);
    
    public Message find(Message message);
    
	//ɾ�����û�����������
	public boolean delMessage(Message message);
	
	//��Ӹ��û�����������
	public boolean addMessage(Message message, User receiver);
	
}
