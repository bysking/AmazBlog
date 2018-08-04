package com.amzblog.db;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amzblog.model.User;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
}