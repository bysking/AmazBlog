package com.amzblog.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amzblog.dao.FeelingDao;
import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.FeelingDaoImpl;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;
import com.amzblog.service.CommentService;

public class FeelingServiceTestTestTest {

	@Test
	public void findtest() {	
		
		//获取指定id的comment
		
		UserDao dao2 = UserDaoImpl.getInstance();
		User user = dao2.find(1);

		//comment.setCommContent("000000000000000000000000");
		//comment.setCommCreateTime(DateUtils.toTimestamp(new Date()));
		
		//CommentService ts=CommentService.getInstance();
		//ts.changeCommentByUserService(comment);
		FeelingDao dao=FeelingDaoImpl.getInstance();
		dao.findRecentFeelingByUser(user);
		
	}

}
