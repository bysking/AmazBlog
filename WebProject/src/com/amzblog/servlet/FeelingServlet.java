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
			System.out.println("ƥ���·��Ŀ¼"+url);
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
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("findAllFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����findAllFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
				
			}
			 else if(isMatch2){

				 try {
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("addFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����addFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
			 else if(isMatch3){

				 try {
					//���÷����ȡ��Ӧ�ķ�����
					 Method method=getClass().getDeclaredMethod("delFeeling",HttpServletRequest.class, HttpServletResponse.class);				
					 method.invoke(this,request,response);		
					 System.out.println("������Ӧ����delFeeling");
					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				   } 
				 catch (Exception e) 
				{
					 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
					 request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
					// TODO: handle exception
				}
			 }
//			 else if(isMatch4){
//
//				 try {
//					//���÷����ȡ��Ӧ�ķ�����
//					 Method method=getClass().getDeclaredMethod("updataBlog",HttpServletRequest.class, HttpServletResponse.class);				
//					 method.invoke(this,request,response);		
//					 System.out.println("������Ӧ����updataBlog");
//					 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//				   } 
//				 catch (Exception e) 
//				{
//					 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
//					 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//					// TODO: handle exception
//				}
//			 }
//		System.out.println("����feelingservletpost");
//		String servletPathString=request.getServletPath();	
//		System.out.println(servletPathString+"");
//		String methodName=servletPathString.substring(9);	
//		System.out.println(methodName+"");
//		methodName=methodName.substring(0,methodName.length()-3);
//		System.out.println("����������"+methodName);
//      
//		 try {
//				 //���÷����ȡ��Ӧ�ķ�����
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);	
//				 System.out.println("������Ӧ����");
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("feelingservlet���Ҳ�����Ӧ�ķ���");
//				//���Ҳ�����Ӧ�ķ�������ִ������
//			}
//			 
	}

     public void findFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	   // User user=null;
    	   ////////////// //�ӽ�����ȡ�û�����
    	    HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("userName");
			UserService us=UserService.getInstance();
			User user=us.findUser(name);
			
    	    FeelingService ts = FeelingService.getInstance();
			Feeling feeling=ts.findRecentFeelingByUserService(user);  
    		request.setAttribute("RecentFeeling",feeling);
    		
    		////////////////////////////////////(��Ӳ���֮�����ת����)    		
    		request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
		
	}
	
     //�½�����
     public void addFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//�ӽ��������feelingId,user
    	 HttpSession session=request.getSession(false);
		 String name=(String)session.getAttribute("userName");
		 UserService us=UserService.getInstance();
		 User user=us.findUser(name);
		 
 		Feeling feeling=new Feeling();
 		String feelContent=request.getParameter("feeling");
 		feeling.setFeelContent(feelContent);
 		feeling.setUser(user);
 		feeling.setFeelCreateTime(DateUtils.toTimestamp(new Date()));
 		/////////////////////��ǰ̨�����ȡ�������
 		
 	    FeelingService ts = FeelingService.getInstance();
		boolean addFeelingStatus=ts.insertFeelingByUserService( feeling); 		
 		request.setAttribute("addFeelingStatus",addFeelingStatus);  	
 		findAllFeeling(request,response);
 		////////////////////////////////////(��Ӳ���֮�����ת����)    		
 		//request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
		
	}
     //ɾ������
     public void delFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int feelingId=Integer.parseInt(request.getParameter("feelingId"));
    	Feeling feeling = null;
    	////////////////////////��ǰ̨�����ȡFeeling����
 		FeelingService ts = FeelingService.getInstance();
	    feeling=ts.findById(feelingId);
	    System.out.println("��Ҫɾ�����������ݣ�"+feeling.getFeelContent());
		boolean delFeelingStatus=ts.delFeelingByUserService(feeling);
		
  		request.setAttribute("delFeelingStatus",delFeelingStatus);  
  		findAllFeeling(request,response);
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		//request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
	
}
    
     //�޸�����
     public void changeFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
 		Feeling feeling=null;
 		//////////////////////////////��ǰ̨�����ȡFeeling����
 				
 		FeelingService ts = FeelingService.getInstance();
		boolean changeFeelingStatus=ts.changeFeelingByUserService(feeling);
  		request.setAttribute("changeFeeling",changeFeelingStatus);  
  		
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
  		request.getRequestDispatcher("/page/feeling.jsp").forward(request, response);
	
}
     //�޸�����
     public void findAllFeeling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
   
    	// User user=null;
 		//////////////////////////////��ǰ̨�����ȡFeeling����
    	  HttpSession session=request.getSession(false);
		  String name=(String)session.getAttribute("userName");
		  UserService us=UserService.getInstance();
		  User user=us.findUser(name);
 		
			System.out.println("��������ser������"+name);
			
 		FeelingService ts = FeelingService.getInstance();		
		List<Feeling> FeelingList=ts.findAllFeelingByUserService(user);
		
		System.out.println("���鳤��"+FeelingList.size());
		
  		request.setAttribute("FeelingList",FeelingList);  
  		System.out.println("�ɹ�����FeelingServlet");
  		////////////////////////////////////(��Ӳ���֮�����ת����)    		
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
