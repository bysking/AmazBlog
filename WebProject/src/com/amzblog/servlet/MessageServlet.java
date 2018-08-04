package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Message;
import com.amzblog.model.User;
import com.amzblog.service.FeelingService;
import com.amzblog.service.MessageService;
import com.amzblog.service.UserService;
import com.amzblog.utils.DateUtils;

public class MessageServlet extends HttpServlet {

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
	    System.out.println("进入messageservletpost");
		    String url = request.getRequestURI();
			System.out.println("匹配的路径目录"+url);
			String content = url;
			String pattern_delMessage = ".*delMessage.*";
			String pattern_addMessage = ".*addMessage.*";
			String pattern_findAllMessage= ".*findAllMessage.*";
			String pattern_findReceivedMsgs= ".*findReceivedMsgs.*";
		//	String pattern_delFeeling= ".*delFeeling.*";
		//	String pattern_updataBlog= ".*updataBlog.*";
			boolean isMatch1 = Pattern.matches(pattern_delMessage, content);
			boolean isMatch2 = Pattern.matches(pattern_findAllMessage, content);
			boolean isMatch3 = Pattern.matches(pattern_addMessage, content);
			boolean isMatch4 = Pattern.matches(pattern_findReceivedMsgs, content);
			if(isMatch1){

				 try {
					 //利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("delMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数delMessagege");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("delMessage中未找到对应方法");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
				
			}
			 else if(isMatch2){

				 try {
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("findAllMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数findAllMessage");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("messageservlet中未找到对应findAllMessage方法");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch3){

				 try {
					 System.out.println("进入相应函数addMessage");
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("addMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数addMessage");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("blogservlet中未找到对应addMessage方法");
					 request.getRequestDispatcher("/page/friendZone.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch4){

				 try {
					 System.out.println("进入相应函数pattern_findReceivedMsgs");
					//利用反射获取对应的方法名
					 Method method=getClass().getDeclaredMethod("findReceivedMsgs",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("调用响应函数findReceivedMsgs");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("blogservlet中未找到对应addMessage方法");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
//		String servletPathString=request.getServletPath();
//		String methodName=servletPathString.substring(9);	
//		methodName=methodName.substring(0,methodName.length()-3);
//		System.out.println("解析方法名"+methodName);
//		 
//		 //System.out.println(methodName);
//			 try {
//				//利用反射获取对应的方法名
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);				 
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("messageservlet中未找到对应方法");
//				// TODO: handle exception
//			}
//			 
	
	}

	/**
	 * Initialization of the servlet. <br>
	 * @throws IOException 
	 *
	 * @throws ServletException if an error occurs
	 */
    //添加留言
	public void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//构建留言接收的用户对象，以及留言对象
		System.out.println("进入添加留言方法");
		HttpSession session=request.getSession(false);
		UserDao csDao=UserDaoImpl.getInstance();
		User user=(User)session.getAttribute("user");
		User receiver=csDao.find(request.getParameter("friendName"));
		//User user=(User)request.getAttribute("user");
		//User receiver=(User)request.getAttribute("friend");
		String msgContent="默认留言";
 		 msgContent=request.getParameter("msg");
 		System.out.println("接收到的receiver名字"+receiver.getUserNickname());
        System.err.println("接收到的内容："+msgContent);
 		//////////////////////////////// 	
 		Message message=new Message();
		
 		message.setMsgContent(msgContent);
 		message.setMsgCreateTime(DateUtils.getCurrTime());
 		message.setUser(user);
 		
 		MessageService ts = MessageService.getInstance();
		boolean addMessageStatus=ts.addMessageService(message, receiver);
		if(addMessageStatus)System.out.println("留言很成功");
  		request.setAttribute("addMessageStatus",addMessageStatus);
  		request.setAttribute("friendName", receiver.getUsername());
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("FriendZoneServlet").forward(request, response);
		
	}
	
	public void delMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//构建Message对象
		//Message message=null;
		////////////////////////从控制台获得留言参数
		System.out.println("进入删除方法");
 		MessageService ts = MessageService.getInstance();
 		int messageId=Integer.parseInt(request.getParameter("msg_Id"));
 		System.out.println(messageId);
		Message message=ts.findMessageService(messageId);
		boolean delMessageStatus=ts.delMessageService(message);
  		request.setAttribute("delMessageStatus",delMessageStatus);  
  		
  		findReceivedMsgs(request, response);
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		//request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
		
	}
	
//没有用这个函数
//	public void changeMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		//构建user
//		int messageId = 0;
//		String MsgContent=null;
//		
// 		MessageService ts = MessageService.getInstance();			
//		int changeMessageStatus=ts.
//  		request.setAttribute("changeMessageStatus",changeMessageStatus);  		
//  		////////////////////////////////////(添加博客之后的跳转界面)    		
//  		request.getRequestDispatcher("/page/message.jsp").forward(request, response);
//		
//	}
	
	//获取用户的所有发出的留言
	public void findAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		System.out.println("进入findallmesage方法");
	    HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);				
		///////////////////////////////////////
		MessageService ts = MessageService.getInstance();			
		List<Message> findAllMessageList=ts.findAllMessageService(user);
  		request.setAttribute("findAllMessageList",findAllMessageList);  
  		System.out.println("find成功");
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("../page/messageBoard.jsp").forward(request, response);
		
	}
	//获取用户的所有收到的留言
	public void findReceivedMsgs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		System.out.println("进入findReceivedMsgs方法");
	    HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);				
		///////////////////////////////////////
		MessageService ts = MessageService.getInstance();			
		List<Message> findReceivedMsgsList=ts.findReceivedMsgsService(user);
  		request.setAttribute("findReceivedMsgsList",findReceivedMsgsList);  
  		System.out.println("findreceive成功");
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("../page/messageBoard.jsp").forward(request, response);
		
	}
	public void getMessageCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		//////////////////从前台获取User 对象
		HttpSession session=request.getSession(false);
		User user1=(User)session.getAttribute("friend");
		UserService us=UserService.getInstance();
		MessageService ts = MessageService.getInstance();	
		int count=ts.getMessageCount(user1);//返回留言数量
  		request.setAttribute("getMessageCount",count);  		
  		////////////////////////////////////(添加博客之后的跳转界面)    		
  		request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
