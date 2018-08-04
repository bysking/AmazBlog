package com.amzblog.utils;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;



public class Util {
	public static Configuration cfg;
	public static SessionFactory sf;
	static {
		//����ԭ���趨�õ����ù����ļ�
		cfg = new Configuration().configure();
		//�����Ự�������������Ự����������ֻ��һ��
		sf = cfg.buildSessionFactory();
	}
	public static Session openSession() {
		return sf.openSession();
	}
	
	public static Transaction beginTransaction(Session session) {
		return session.beginTransaction();
	}
	
}
