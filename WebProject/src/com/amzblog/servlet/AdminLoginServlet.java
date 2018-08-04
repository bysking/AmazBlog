package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.Admin;
import com.amzblog.model.User;
import com.amzblog.service.AdminService;
import com.amzblog.service.BlogService;
import com.amzblog.service.FeelingService;
import com.amzblog.service.MessageService;
import com.amzblog.service.UserService;

public class AdminLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminLoginServlet() {
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
			String adminName=request.getParameter("adminName");
			String adminPassword=request.getParameter("adminPassword");
			
			AdminService as=AdminService.getInstance();
			if(as.adminLogin(adminName, adminPassword)!=null){
				Admin admin=as.adminLogin(adminName, adminPassword);
				
				HttpSession session=request.getSession();
				session.setAttribute("adminName", adminName);
				
				response.sendRedirect("../page/admin.jsp");
				//request.getRequestDispatcher("Admin.jsp").forward(request,response);
			}else{
				request.setAttribute("msg", "不存在该管理员！");
				
				response.sendRedirect("../page/login.jsp");
				//request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
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
