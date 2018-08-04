package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.Feeling;
import com.amzblog.model.Message;
import com.amzblog.model.User;
import com.amzblog.service.FeelingService;
import com.amzblog.service.MessageService;
import com.amzblog.service.UserService;
import com.amzblog.utils.DateUtils;

public class FeelingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("userName");
			UserService us=UserService.getInstance();
			User user=us.findUser(name);				
		    FeelingService ts = FeelingService.getInstance();		
		    List<Feeling> FeelingList=ts.findAllFeelingByUserService(user);
		    request.setAttribute("FeelingList",FeelingList); 
		
		    String url = request.getRequestURI();
			System.out.println("匹配的路径目录"+url);
			String content = url;
			String pattern_findAllFeeling = ".*findAllFeeling.*";
			String pattern_addFeeling= ".*addFeeling.*";
			String pattern_delFeeling= ".*delFeeling.*";
		//	String pattern_updataBlog= ".*updataBlog.*";
			boolean isMatch1 = Pattern.matches(pattern_findAllFeeling, content);
			boolean isMatch2 = Pattern.matches(pattern_addFeeling, content);
			boolean isMatch3 = Pattern.matches(pattern_delFeeling, content);
		//	boolean isMatch4 = Pattern.matches(pattern_updataBlog, content);
			if(isMatch1){

				 try {
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("findAllFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数findAllFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet中未找到对应方法");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
				
			}
			 else if(isMatch2){

				 try {
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("addFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数addFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet中未找到对应方法");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch3){

				 try {
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("delFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数delFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet中未找到对应方法");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
//			 else if(isMatch4){
//
//				 try {
//					//利用反射获取对应的方法名
//					 Method method=getClass().getDeclaredMethod("updataBlog",HttpServletRequest.class, HttpServletResponse.class);				
//					 method.invoke(this,request,response);		
//					 System.out.println("调用响应函数updataBlog");
//					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//				   } 
//				 catch (Exception e) 
//				{
//					 //System.out.println("blogservlet中未找到对应方法");
//					 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//					// TODO: handle exception
//				}
//			 }
//		System.out.println("进入feelingservletpost");
//		String servletPathString=request.getServletPath();	
//		System.out.println(servletPathString+"");
//		String methodName=servletPathString.substring(9);	
//		System.out.println(methodName+"");
//		methodName=methodName.substring(0,methodName.length()-3);
//		System.out.println("解析方法名"+methodName);
//      
//		 try {
//				 //利用反射获取对应的方法名
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);	
//				 System.out.println("调用响应函数");
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("feelingservlet中找不到对应的方法");
//				//若找不到对应的方法，则执行这里
//			}
//			 
	}

     public void findFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	   // User user=null;
    	   ////////////// //从界面解获取用户对象
    	    HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("userName");
			UserService us=UserService.getInstance();
			User user=us.findUser(name);
			
    	    FeelingService ts = FeelingService.getInstance();
			Feeling feeling=ts.findRecentFeelingByUserService(user);  
    		request.setAttribute("RecentFeeling",feeling);
    		
    		////////////////////////////////////(添加博客之后的跳转界面)    		
    		request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
		
	}
	
     //新建心情
     public void addFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//从界面解析出feelingId,user
    	 HttpSession session=request.getSession(false);
		 String name=(String)session.getAttribute("userName");
		 UserService us=UserService.getInstance();
		 User user=us.findUser(name);
		 
 		Feeling feeling=new Feeling();
 		String feelContent=request.getParameter("feeling");
 		feeling.setFeelContent(feelContent);
 		feeling.setUser(user);
 		feeling.setFeelCreateTime(DateUtils.toTimestamp(new Date()));
 		/////////////////////从前台界面获取心情对象
 		
 	    FeelingService ts = FeelingService.getInstance();
		boolean addFeelingStatus=ts.insertFeelingByUserService( feeling); 		
 		request.setAttribute("addFeelingStatus",addFeelingStatus);  	
 		findAllFeeling(request,response);
 		////////////////////////////////////(添加博客之后的跳转界面)    		
 		//request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
		
	}
     //删除心情
     public void delFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int feelingId=Integer.parseInt(request.getParameter("feelingId"));
    	Feeling feeling = null;
    	////////////////////////从前台界面获取Feeling对象
 		FeelingService ts = FeelingService.getInstance();
	    feeling=ts.findById(feelingId);
	    System.out.println("需要删除的心情内容："+feeling.getFeelContent());
		boolean delFeelingStatus=ts.delFeelingByUserService(feeling);
		
  		request.setAttribute("delFeelingStatus",delFeelingStatus);  
  		findAllFeeling(request,response);
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		//request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
	
}
    
     //修改心情
     public void changeFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
 		Feeling feeling=null;
 		//////////////////////////////从前台界面获取Feeling对象
 				
 		FeelingService ts = FeelingService.getInstance();
		boolean changeFeelingStatus=ts.changeFeelingByUserService(feeling);
  		request.setAttribute("changeFeeling",changeFeelingStatus);  
  		
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
	
}
     //修改心情
     public void findAllFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
    	// User user=null;
 		//////////////////////////////从前台界面获取Feeling对象
    	  HttpSession session=request.getSession(false);
		  String name=(String)session.getAttribute("userName");
		  UserService us=UserService.getInstance();
		  User user=us.findUser(name);
 		
			System.out.println("传入心情ser的名字"+name);
			
 		FeelingService ts = FeelingService.getInstance();		
		List<Feeling> FeelingList=ts.findAllFeelingByUserService(user);
		
		System.out.println("心情长度"+FeelingList.size());
		
  		request.setAttribute("FeelingList",FeelingList);  
  		System.out.println("成功进入FeelingServlet");
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
  		//request.getRequestDispatcher("../page/friends.jsp").forward(request, response);
	
}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
