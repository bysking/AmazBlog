package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.db.HibernateSessionFactory;
import com.amzblog.model.Blog;
import com.amzblog.model.User;
import com.amzblog.model.Zone;
import com.amzblog.service.BlogService;
import com.amzblog.service.FeelingService;
import com.amzblog.service.FriendshipService;
import com.amzblog.service.MessageService;
import com.amzblog.service.UserService;
import com.amzblog.service.ZoneService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

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

		
		doPost(request,response);
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
		PrintWriter out = response.getWriter();
		try{
			String userName=request.getParameter("userName");
			String userPassword=request.getParameter("userPassword");
			HttpSession session=request.getSession();
			
			UserService us=UserService.getInstance();
			ZoneService zs=ZoneService.getInstance();
			
			if(userName==null&&userPassword==null){
				userName=(String) session.getAttribute("userName");
				userPassword=(String) session.getAttribute("userPassword");
			}
			
			//System.out.println("look here!"+userName);
			
			if(us.findUser(userName)!=null){
				if(us.login(userName, userPassword)!=null){
					User user=us.login(userName, userPassword);
					int userId=user.getUserId();
					if(zs.findZone(userId)==null){
						Zone nzone=new Zone();
						nzone.setUser(user);
						nzone.setZoneName(userName);
						nzone.setZoneCreateDate(new Date());
						nzone.setZoneStyle("../img/simple.jpg");
						zs.addZone(nzone);
					}
					Zone zone=(Zone)session.getAttribute("zone");
					if(zone==null)
						zone=zs.findZone(userId);
					System.out.println(zone.getZoneStyle());
					//HttpSession session=request.getSession();
					session.setAttribute("zone", zone);
					session.setAttribute("userName", userName);
					session.setAttribute("userId",userId);
					session.setAttribute("userPassword",userPassword);
					session.setAttribute("user", user);
					//初始化日志，留言，心情列表
					BlogService bs=new BlogService(user);
					FeelingService fs=FeelingService.getInstance();
					MessageService ms=MessageService.getInstance();
					FriendshipService fss=FriendshipService.getInstance();
					

					request.setAttribute("blog_list",bs.getAllBlogService(user));
					request.setAttribute("findAllMessageList",ms.findReceivedMsgsService(user));
					request.setAttribute("feeling_list",fs.findAllFeelingByUserService(user));
					//初始化日志，留言，心情数量
					request.setAttribute("blog_number",bs.getBlogCount(user));
					request.setAttribute("Msg_number",ms.findReceivedMsgsService(user).size());
					request.setAttribute("feeling_number",fs.findAllFeelingByUserService(user).size());
					request.setAttribute("friend_number",fss.getFriendInfo(userName).size());
					
					request.getRequestDispatcher("../page/main.jsp").forward(request,response);
					//response.sendRedirect("../page/main.jsp");
				}else{
					request.setAttribute("msg", "用户名或密码错误！");
					//request.getRequestDispatcher("../page/login.jsp").forward(request, response);
					response.sendRedirect("../page/login.jsp");
				}
			}else{
				request.setAttribute("msg", "该用户不存在！");
				request.getRequestDispatcher("../page/login.jsp").forward(request, response);
			}
		}finally{
			out.close();
		}
		
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
