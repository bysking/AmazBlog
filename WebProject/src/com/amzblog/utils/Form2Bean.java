package com.amzblog.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.amzblog.model.*;
import com.amzblog.utils.DateUtils;
import com.jspsmart.upload.Request;

public class Form2Bean {
	
	    public static User userF2B(Request request)throws ServletException, IOException, ParseException{
		Map value=new HashMap();
		
		//HttpSession session=request.getSession(false);
		
		String userBirthdate=request.getParameter("userBirthdate");
		String biry=userBirthdate.substring(0, 4);
		Date date=DateUtils.toDate(userBirthdate);
		String cd=DateUtils.DatetoString(new Date()).substring(0,4);
		
		//ServletRequest session=request.gets;
		
		
		int cy = Integer.parseInt(cd);
		int by=Integer.parseInt(biry);
		int age=cy-by;
		
		value.put("userNickname", request.getParameter("userNickname"));
		value.put("userSex", request.getParameter("userSex"));
		value.put("userAge", age);
		value.put("userBirthdate",date);
		//value.put("userSelfie", request.getParameter("userSelfie"));
		value.put("userEmailAddr", request.getParameter("userEmailAddr"));
		value.put("userBlogAddr", request.getParameter("userBlogAddr"));
		value.put("userWechat", request.getParameter("userWechat"));
		value.put("userQq", request.getParameter("userQq"));
		value.put("userPhone", request.getParameter("userPhone"));
		User bean=new User();
		try{
			BeanUtils.populate(bean, value);
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
		
		
	}

}
