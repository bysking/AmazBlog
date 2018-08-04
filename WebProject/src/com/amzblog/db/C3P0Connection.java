package com.amzblog.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0数据库连接池的使用
 * 配置文件 src/c3p0-config.xml
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
	   * 获取实例,单例
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
	 *  获取数据库连接
	 *  @return
	 *  加上synchronized关键字后，就表明要获得该内置锁才能执行
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
