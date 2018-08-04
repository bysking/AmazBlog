package com.amzblog.utils;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;



public class Util {
	public static Configuration cfg;
	public static SessionFactory sf;
	static {
		//启动原本设定好的配置管理文件
		cfg = new Configuration().configure();
		//建立会话工厂用来产生会话，工厂可以只有一个
		sf = cfg.buildSessionFactory();
	}
	public static Session openSession() {
		return sf.openSession();
	}
	
	public static Transaction beginTransaction(Session session) {
		return session.beginTransaction();
	}
	
}
