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
import com.amzblog.service.UserService;

public class RecFriendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RecFriendServlet() {
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
			HttpSession session=request.getSession(false);
			FriendshipService fs=FriendshipService.getInstance();
			//UserService us=UserService.getInstance();
			String userName=(String)session.getAttribute("userName");
			List<User> recList=new ArrayList<User>();
			List<Friendship> fList=fs.getFriendInfo(userName);
			for(Friendship f:fList){
				List<User>uList=fs.getFriendInfo(f.getUserByFriendId().getUsername());			
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
		    request.setAttribute("recList", recList);
			request.getRequestDispatcher("friend.jsp").forward(request, response);
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
