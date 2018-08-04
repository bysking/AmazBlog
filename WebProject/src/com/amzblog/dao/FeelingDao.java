package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Comment;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;

public interface FeelingDao {
	
	//通过feelingId查找心情
	public Feeling find(int feelingId);
	
	//查询用户心情
	public Feeling findRecentFeelingByUser(User user);
	//public Feeling findRecentFeelingByUser(int feelingId);
	
	//查询用户所有心情
	public List <Feeling> findAllFeelingByUser(User user);
	
	//删除用户心情
	public boolean delFeelingByUser(Feeling feeling);
	//public int delFeelingByUser(int feelingId);
	
	//批量删除用户心情
	//public int delFeelingByUser(User user);
	
	//添加用户心情
	public boolean insertFeelingByUser(Feeling feeling);
	//public int insertFeelingByUser(Feeling feeling);
	
	//修改指定用户的指定心情
	//public int changeFeelingByUser(User user,int feelingId);
	public boolean changeFeelingByUser(Feeling feeling);

}
