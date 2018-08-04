package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.User;
import com.amzblog.service.FriendshipService;
import com.amzblog.service.UserService;

public class AddFriendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddFriendServlet() {
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
			//request.getRequestDispatcher("friend.jsp").include(request, response);
			HttpSession session=request.getSession(false);
			String userName=(String) session.getAttribute("userName");
			String friendName=request.getParameter("friendName");
			
			FriendshipService fs=FriendshipService.getInstance();
			UserService us=UserService.getInstance();
			if(us.findUser(friendName)!=null){
//			
//			
//			
//			System.out.println(userName);
//			System.out.println(friendName);
//			
//			
				boolean i=false;
				i=fs.addFriend(userName, friendName);
				if(i){
					request.setAttribute("msg", "您已成功添加！");
					System.out.println(i);
					request.getRequestDispatcher("../servlet/FriendListServlet").forward(request, response);
					//response.sendRedirect("../page/friends.jsp");
				}else{
					request.setAttribute("msg", "添加失败");
					request.getRequestDispatcher("../servlet/FriendListServlet").forward(request, response);
				}
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
