package com.amzblog.dao;

import java.util.List;

import com.amzblog.model.Comment;
import com.amzblog.model.Feeling;
import com.amzblog.model.User;

public interface FeelingDao {
	
	//ͨ��feelingId��������
	public Feeling find(int feelingId);
	
	//��ѯ�û�����
	public Feeling findRecentFeelingByUser(User user);
	//public Feeling findRecentFeelingByUser(int feelingId);
	
	//��ѯ�û���������
	public List <Feeling> findAllFeelingByUser(User user);
	
	//ɾ���û�����
	public boolean delFeelingByUser(Feeling feeling);
	//public int delFeelingByUser(int feelingId);
	
	//����ɾ���û�����
	//public int delFeelingByUser(User user);
	
	//����û�����
	public boolean insertFeelingByUser(Feeling feeling);
	//public int insertFeelingByUser(Feeling feeling);
	
	//�޸�ָ���û���ָ������
	//public int changeFeelingByUser(User user,int feelingId);
	public boolean changeFeelingByUser(Feeling feeling);

}
