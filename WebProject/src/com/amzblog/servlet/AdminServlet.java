package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.service.BlogService;
import com.amzblog.service.FriendshipService;
import com.amzblog.service.UserService;

public class AdminServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminServlet() {
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
			String action=request.getParameter("action");
			UserService us=UserService.getInstance();
			BlogService bs=BlogService.getInstance();
			
			if(action.equals("deleteUser")){
				String userName=request.getParameter("userName");
				us.delete(userName);
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
			}
			if(action.equals("editUser")){
				String userName=request.getParameter("userName");
				session.setAttribute("userName", userName);
				request.getRequestDispatcher("Info.jsp").forward(request, response);
			}
			if(action.equals("deleteBlog")){
				int blogId=Integer.parseInt(request.getParameter("blogId"));
				bs.delBlogService(blogId);
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
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
