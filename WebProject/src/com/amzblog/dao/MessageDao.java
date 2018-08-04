package com.amzblog.dao;


import java.util.List;

import com.amzblog.model.Message;
import com.amzblog.model.User;

public interface MessageDao {

	//获取该用户发出的所有留言
    public List<Message> findAllMessage(User user);
    
    //查询留言板上的用户留言列表信息
    public List<Message> findReceivedMsgs(User user);

    //通过ID查询一条消息
    public Message find(int messageId);
    
    public Message find(Message message);
    
	//删除该用户发出的留言
	public boolean delMessage(Message message);
	
	//添加该用户发出的留言
	public boolean addMessage(Message message, User receiver);
	
}
