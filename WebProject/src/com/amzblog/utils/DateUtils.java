package com.amzblog.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date类型转换工具类
 * @author Bruski
 * Date: 2018/06/29
 */

public class DateUtils {
	
	/**
	 * 将 Java Date对象 转换成 String(date)，以便数据库存储
	 * @param Date date
	 * @return
	 */
	
	public static String DatetoString(Date date) {
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	/**
	 * 将 Java Date对象 转换成 String(datetime)，以便数据库存储
	 * @param Date date
	 * @return
	 */
	
	public static String TimetoString(Date date) {
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	/**
	 * 将 String(datetime) 转换成 Java Date对象 yyyy-MM-dd
	 * @param String date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date) throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(date);
	}
	

	
	/**
	 * 将 String(datetime) 转换成 Java Date对象 yyyy-MM-dd HH:mm:ss
	 * @param String datetime
	 * @return
	 * @throws ParseException
	 */
	public static Date toDatetime(String date) throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.parse(date);
	}
	
	public static Timestamp toTimestamp(Date date) {
		Timestamp  ts = new Timestamp(date.getTime());
		return ts;
	}
	
	/**
	 * 返回Timestamp类型的时间，格式为 yyyy-MM-dd HH:mm:ss
	 * @return Timestamp
	 * @throws ParseException
	 */
	public static Timestamp getCurrTime() {
		return toTimestamp(new Date());
	}

}
