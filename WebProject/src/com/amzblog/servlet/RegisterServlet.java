package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amzblog.model.User;
import com.amzblog.service.UserService;
import com.amzblog.utils.*;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
			String confirmPassword=request.getParameter("confirmPassword");
			String userBlogAddr=request.getRequestURL()+"?"+request.getQueryString();
			//String userBlogAddr="www.test.com";
			User user=new User();
			user.setUsername(userName);
			user.setUserPassword(userPassword);
			user.setUserBlogAddr(userBlogAddr);
			user.setUserNickname(userName);
			String birth="2000-01-01";
			Date bir=DateUtils.toDate(birth);
			user.setUserBirthdate(bir);
			
			UserService us=UserService.getInstance();
			System.out.println("hello");
			System.out.println(user.getUsername());
			System.out.println(user.getUserBlogAddr());
			if(us.findUser(userName)!=null){
				request.setAttribute("msg", "该用户已存在！");
				response.sendRedirect("../page/register.jsp");
				//request.getRequestDispatcher("register.jsp").forward(request,response);
			}else{
				if(userPassword.equals(confirmPassword)){
					us.register(user);
					request.setAttribute("msg", "注册成功，请登录！");
					response.sendRedirect("../page/login.jsp");
					//request.getRequestDispatcher("../page/login.jsp").forward(request,response);
				}else{
					request.setAttribute("msg", "两次密码不一致！");
					response.sendRedirect("../page/register.jsp");
				}
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
