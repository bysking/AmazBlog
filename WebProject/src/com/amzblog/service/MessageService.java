package com.amzblog.service;

import java.util.List;

import com.amzblog.dao.MessageDao;
import com.amzblog.daoImpl.MessageDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.Message;
import com.amzblog.model.User;

public class MessageService {
	
    private MessageDao dao;
	
	private static MessageService instance;
	
	private  MessageService() {
		dao =  MessageDaoImpl.getInstance();
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static final MessageService getInstance() {
		if (instance == null) {
			try {
				instance = new MessageService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public Message findMessageService(int messageId) {
		// TODO Auto-generated method stub
		return dao.find(messageId);
	}

	//获得留言数量
	public int getMessageCount(User user){
		
        List<Message> messageList =dao.findAllMessage(user);
		
		return messageList.size();
		
	}
	
	
	public List<Message> findAllMessageService(User user) {
		// TODO Auto-generated method stub
		return dao.findAllMessage(user);
	}

	public List<Message> findReceivedMsgsService(User user) {
		// TODO Auto-generated method stub
		return dao.findReceivedMsgs(user);
	}

	public boolean delMessageService(Message message) {
		// TODO Auto-generated method stub
		return dao.delMessage(message);
	}


	public boolean addMessageService(Message message,User receiver) {
		// TODO Auto-generated method stub
		return dao.addMessage(message, receiver);
	}


//	public int changeMessageService(Message message) {
//		// TODO Auto-generated method stub
//		return dao.
//	}
	
	
}
