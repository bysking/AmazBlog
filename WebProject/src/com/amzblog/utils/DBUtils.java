package com.amzblog.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/**
 * Title: 封装关闭数据库各种连接的操作
 * @author Bruski
 * Date: 2018/06/29
 */

public class DBUtils {
	
	public static void Close(PreparedStatement st) throws SQLException {
		if (st != null)
			st.close();
	}
	
	public static void Close(PreparedStatement st, ResultSet rs) throws SQLException {
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
	
	public static void Close(Connection conn, PreparedStatement st, ResultSet rs) throws SQLException {
		if (conn != null)
			conn.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}
