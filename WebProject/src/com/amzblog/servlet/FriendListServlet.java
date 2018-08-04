package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.Friendship;
import com.amzblog.model.User;
import com.amzblog.service.FriendshipService;

public class FriendListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FriendListServlet() {
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
		
		 try{
			 HttpSession session=request.getSession(false);
			 FriendshipService fs=FriendshipService.getInstance();
			 //int userId=(int) session.getAttribute("userId");
			 String userName=(String)session.getAttribute("userName");
			 List<User> fList=fs.getFriendInfo(userName);
			 List<User> recList=new ArrayList<User>();
			 
			 request.setAttribute("fList", fList);
			 
			 
			 //List<Friendship> fList=fs.getFriendInfo(userName);
			 for(User f:fList){
				List<User> uList=fs.getFriendInfo(f.getUsername());
				System.out.println(f.getUserId());
				for(User u:uList){
					if(!u.getUsername().equals(userName)){
						recList.add(u);
					}
				}
			 }
			 //消除重复好友推荐
			 HashSet h = new HashSet(recList);   
			 recList.clear();   
			 recList.addAll(h);
			 recList.removeAll(fList);
			 request.setAttribute("recList", recList);
			 response.setCharacterEncoding("UTF-8");
			 //response.sendRedirect("../page/friends.jsp");
			 request.getRequestDispatcher("../page/friends.jsp").forward(request, response);
		 }finally{
			 
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
