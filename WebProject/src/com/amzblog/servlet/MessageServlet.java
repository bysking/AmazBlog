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
	    System.out.println("����messageservletpost");
		    String url = request.getRequestURI();
			System.out.println("ƥ���·��Ŀ¼"+url);
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
					 //���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("delMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����delMessagege");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("delMessage��δ�ҵ���Ӧ����");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
				
			}
			 else if(isMatch2){

				 try {
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("findAllMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����findAllMessage");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("messageservlet��δ�ҵ���ӦfindAllMessage����");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch3){

				 try {
					 System.out.println("������Ӧ����addMessage");
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("addMessage",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����addMessage");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("blogservlet��δ�ҵ���ӦaddMessage����");
					 request.getRequestDispatcher("/page/friendZone.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch4){

				 try {
					 System.out.println("������Ӧ����pattern_findReceivedMsgs");
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("findReceivedMsgs",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����findReceivedMsgs");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 System.out.println("blogservlet��δ�ҵ���ӦaddMessage����");
					 request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
//		String servletPathString=request.getServletPath();
//		String methodName=servletPathString.substring(9);	
//		methodName=methodName.substring(0,methodName.length()-3);
//		System.out.println("����������"+methodName);
//		 
//		 //System.out.println(methodName);
//			 try {
//				//���÷����ȡ��Ӧ�ķ�����
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);				 
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("messageservlet��δ�ҵ���Ӧ����");
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
    //�������
	public void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//�������Խ��յ��û������Լ����Զ���
		System.out.println("����������Է���");
		HttpSession session=request.getSession(false);
		UserDao csDao=UserDaoImpl.getInstance();
		User user=(User)session.getAttribute("user");
		User receiver=csDao.find(request.getParameter("friendName"));
		//User user=(User)request.getAttribute("user");
		//User receiver=(User)request.getAttribute("friend");
		String msgContent="Ĭ������";
 		 msgContent=request.getParameter("msg");
 		System.out.println("���յ���receiver����"+receiver.getUserNickname());
        System.err.println("���յ������ݣ�"+msgContent);
 		//////////////////////////////// 	
 		Message message=new Message();
		
 		message.setMsgContent(msgContent);
 		message.setMsgCreateTime(DateUtils.getCurrTime());
 		message.setUser(user);
 		
 		MessageService ts = MessageService.getInstance();
		boolean addMessageStatus=ts.addMessageService(message, receiver);
		if(addMessageStatus)System.out.println("���Ժܳɹ�");
  		request.setAttribute("addMessageStatus",addMessageStatus);
  		request.setAttribute("friendName", receiver.getUsername());
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		request.getRequestDispatcher("FriendZoneServlet").forward(request, response);
		
	}
	
	public void delMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//����Message����
		//Message message=null;
		////////////////////////�ӿ���̨������Բ���
		System.out.println("����ɾ������");
 		MessageService ts = MessageService.getInstance();
 		int messageId=Integer.parseInt(request.getParameter("msg_Id"));
 		System.out.println(messageId);
		Message message=ts.findMessageService(messageId);
		boolean delMessageStatus=ts.delMessageService(message);
  		request.setAttribute("delMessageStatus",delMessageStatus);  
  		
  		findReceivedMsgs(request, response);
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		//request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
		
	}
	
//û�����������
//	public void changeMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		//����user
//		int messageId = 0;
//		String MsgContent=null;
//		
// 		MessageService ts = MessageService.getInstance();			
//		int changeMessageStatus=ts.
//  		request.setAttribute("changeMessageStatus",changeMessageStatus);  		
//  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
//  		request.getRequestDispatcher("/page/message.jsp").forward(request, response);
//		
//	}
	
	//��ȡ�û������з���������
	public void findAllMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		System.out.println("����findallmesage����");
	    HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);				
		///////////////////////////////////////
		MessageService ts = MessageService.getInstance();			
		List<Message> findAllMessageList=ts.findAllMessageService(user);
  		request.setAttribute("findAllMessageList",findAllMessageList);  
  		System.out.println("find�ɹ�");
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		request.getRequestDispatcher("../page/messageBoard.jsp").forward(request, response);
		
	}
	//��ȡ�û��������յ�������
	public void findReceivedMsgs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		System.out.println("����findReceivedMsgs����");
	    HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);				
		///////////////////////////////////////
		MessageService ts = MessageService.getInstance();			
		List<Message> findReceivedMsgsList=ts.findReceivedMsgsService(user);
  		request.setAttribute("findReceivedMsgsList",findReceivedMsgsList);  
  		System.out.println("findreceive�ɹ�");
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		request.getRequestDispatcher("../page/messageBoard.jsp").forward(request, response);
		
	}
	public void getMessageCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//User user=null;
		//////////////////��ǰ̨��ȡUser ����
		HttpSession session=request.getSession(false);
		User user1=(User)session.getAttribute("friend");
		UserService us=UserService.getInstance();
		MessageService ts = MessageService.getInstance();	
		int count=ts.getMessageCount(user1);//������������
  		request.setAttribute("getMessageCount",count);  		
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		request.getRequestDispatcher("/page/messageBoard.jsp").forward(request, response);
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
