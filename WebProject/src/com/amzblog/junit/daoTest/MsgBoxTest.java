package com.amzblog.junit.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.amzblog.dao.MessageDao;
import com.amzblog.dao.MsgboxDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.MessageDaoImpl;
import com.amzblog.daoImpl.MsgboxDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Message;
import com.amzblog.model.User;

public class MsgBoxTest {
	static MsgboxDao msgboxDao = MsgboxDaoImpl.getInstance();
	static MessageDao messageDao = MessageDaoImpl.getInstance();

//	@Test
//	public void Test(){
//		UserDao dao = new UserDaoImpl();
//		User user = dao.find(1);
//		
//		List<Message> msg=msgboxDao.findReceivedMsgs(user);
//		for(Message i:msg){
//			System.out.println(i.getMsgId());
//		}
//	}


}
