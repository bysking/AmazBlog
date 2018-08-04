package com.amzblog.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0���ݿ����ӳص�ʹ��
 * �����ļ� src/c3p0-config.xml
 * @author: Bruski
 * Date: 2018/06/29
 */

public class C3P0Connection {

	private static C3P0Connection instance;
	private static ComboPooledDataSource dataSource;
	
	private C3P0Connection() throws Exception {
		dataSource=new ComboPooledDataSource();
	}
	
	/**
	   * ��ȡʵ��,����
	   * @return
	   */
	public static final C3P0Connection getInstance() {
		if (instance == null) {
			try {
				instance = new C3P0Connection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/**
	 *  ��ȡ���ݿ�����
	 *  @return
	 *  ����synchronized�ؼ��ֺ󣬾ͱ���Ҫ��ø�����������ִ��
	 */
	public synchronized final Connection getConnection() {
		Connection conn = null;
		try {
			conn =dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
