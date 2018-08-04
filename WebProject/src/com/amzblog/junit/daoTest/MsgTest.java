package com.amzblog.junit.daoTest;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.amzblog.dao.MessageDao;
import com.amzblog.dao.MsgboxDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.MessageDaoImpl;
import com.amzblog.daoImpl.MsgboxDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Message;
import com.amzblog.model.Msgbox;
import com.amzblog.model.User;
import com.amzblog.utils.DateUtils;

public class MsgTest {
	static MsgboxDao msgboxDao = MsgboxDaoImpl.getInstance();
	static MessageDao messageDao = MessageDaoImpl.getInstance();
	
//	@Test
//	public void addMsgboxTest() {
//		UserDao dao = new UserDaoImpl();
//		User user1 = dao.find(1);
//		User user2 = dao.find(2);
//		
//		
//		Message message = new Message();
//		message.setUser(user2);
//		message.setMsgContent("Hello fellow");
//		message.setMsgCreateTime(DateUtils.toTimestamp(new Date()));
//		messageDao.addMessage(user2, message);
//		
//		Msgbox msgbox = new Msgbox();
//		msgbox.setMsgBoxId(1);
//		msgbox.setUser(user1);
//		msgbox.setMessage(message);
//		msgboxDao.addMsgbox(user1, msgbox);	
//		
//		System.out.println("add a msgbox to user " + user1.getUsername()+ " msgboxId:" + msgboxDao.findMsgbox(user1).getMsgBoxId());
//		System.out.println("msg in msgbox is :" + msgboxDao.findMsgbox(user1).getMessage().getMsgContent());
//	}
	
//	@Test
//	public void find() {
//		UserDao dao = new UserDaoImpl();
//		User user = dao.find(1);
//		
//		List<Message> msg=msgboxDao.findReceivedMsgs(user);
//		for(Message i:msg){
//			System.out.println(i.getMsgId());
//	}
	
	
//	@Test
//	public void addMsgTest() {
//		UserDao dao = new UserDaoImpl();
//		User user = dao.find(1);
//		
//		Msgbox msgbox = new Msgbox();
//		msgbox.setUser(user);
//		msgbox.setMessage(null);
//		msgboxDao.addMsgbox(user, msgbox);	
//	}
}
