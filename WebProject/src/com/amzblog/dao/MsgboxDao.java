package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Message;
import com.amzblog.model.Msgbox;
import com.amzblog.model.User;

public interface MsgboxDao {

	//msgbox实际上指的是一段“消息由哪个用户收到”的关系，无法主动删除，只能在Message处级联删除
	
	//当一个消息被发出，就有用户收到消息，即增加一个Msgbox关系
	public boolean addMsgbox(User user, Message message);
		
}
