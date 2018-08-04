package com.amzblog.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.amzblog.utils.DBUtils;
import com.amzblog.utils.DateUtils;

/**
 * 记录空间访客
 * @author Bruski
 * Date: 2018/06/29
 * 状态: 未完成
 */

public class VisitorDB {
	
	private static final Connection conn = C3P0Connection.getInstance().getConnection();
	
	/**
	 * 记录浏览者信息，添加到VISITOR表里
	 */
	public static void visit(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String localAddr = request.getLocalAddr();
		String remoteHost = request.getRemoteHost();
		String time = DateUtils.DatetoString(new Date());
		
		String sql ="insert into VISITOR values(null,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, remoteAddr);
			ps.setString(2, time);
			ps.setString(3, localAddr);
			ps.setString(4, remoteHost);
			
			ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回全部浏览者数
	 * @return
	 */
	public static int getTotalVisit() {
		Connection conn = C3P0Connection.getInstance().getConnection();
		int result = 0;
		String sql = "select count(id) from VISITOR";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
