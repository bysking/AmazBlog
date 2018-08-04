package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.model.User;
import com.amzblog.service.UserService;
import com.amzblog.utils.DateUtils;
import com.amzblog.utils.Form2Bean;

public class ShowServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowServlet() {
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
		//PrintWriter out = response.getWriter();
		try{
			request.setCharacterEncoding("utf-8");
			HttpSession session=request.getSession(false);
			String userName=(String)session.getAttribute("userName");
			//User user=(User) session.getAttribute("user");
			UserService us=UserService.getInstance();
			User user=us.findUser(userName);
			//User user=us.findUser(userName);
			//request.setAttribute("user", user);
			Date date=user.getUserBirthdate();
			String birthdate=DateUtils.DatetoString(date);
			session.setAttribute("userBirthdate", birthdate);
			System.out.println("123");
				//user=Form2Bean.userF2B(request);
				//us.updateInfo(user);
				
			request.getRequestDispatcher("../page/personInfo.jsp").forward(request,response);
			//response.sendRedirect("../page/personInfo.jsp");
		}finally{
			//out.close();
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
