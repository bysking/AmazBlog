package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.User;
import com.amzblog.service.BlogService;
import com.amzblog.service.FeelingService;
import com.amzblog.service.FriendshipService;
import com.amzblog.service.MessageService;
import com.amzblog.service.UserService;

public class FindPasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FindPasswordServlet() {
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
			 HttpSession session=request.getSession();
			 String userName=request.getParameter("userName");
			 String userEmailAddr=request.getParameter("userEmailAddr");
			 String userPassword=request.getParameter("userPassword");
			 String confirmPassword=request.getParameter("confirmPassword");
			 
			 UserService us=UserService.getInstance();
				if(us.findUser(userName)!=null){
					User user=us.findUser(userName);
					if(user.getUserEmailAddr().equals(userEmailAddr)){
						if(userPassword.equals(confirmPassword)){
							user.setUserPassword(userPassword);
							us.updateInfo(user);
							request.setAttribute("msg", "设置密码成功！");
							request.getRequestDispatcher("../page/login.jsp").forward(request, response);
						}else{
							request.setAttribute("msg", "密码不一致！");
							request.getRequestDispatcher("findPassword.jsp").forward(request, response);
						}
						
					}else{
						request.setAttribute("msg", "回答错误！");
						request.getRequestDispatcher("findPassword.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("msg", "该用户不存在！");
					request.getRequestDispatcher("findPassword.jsp").forward(request, response);
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
