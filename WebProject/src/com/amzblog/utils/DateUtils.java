package com.amzblog.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date����ת��������
 * @author Bruski
 * Date: 2018/06/29
 */

public class DateUtils {
	
	/**
	 * �� Java Date���� ת���� String(date)���Ա����ݿ�洢
	 * @param Date date
	 * @return
	 */
	
	public static String DatetoString(Date date) {
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	/**
	 * �� Java Date���� ת���� String(datetime)���Ա����ݿ�洢
	 * @param Date date
	 * @return
	 */
	
	public static String TimetoString(Date date) {
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	/**
	 * �� String(datetime) ת���� Java Date���� yyyy-MM-dd
	 * @param String date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date) throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(date);
	}
	

	
	/**
	 * �� String(datetime) ת���� Java Date���� yyyy-MM-dd HH:mm:ss
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
	 * ����Timestamp���͵�ʱ�䣬��ʽΪ yyyy-MM-dd HH:mm:ss
	 * @return Timestamp
	 * @throws ParseException
	 */
	public static Timestamp getCurrTime() {
		return toTimestamp(new Date());
	}

}
