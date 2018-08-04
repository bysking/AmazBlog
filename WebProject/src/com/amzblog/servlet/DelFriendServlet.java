package com.amzblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzblog.service.FriendshipService;

public class DelFriendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DelFriendServlet() {
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
			String userName=(String)session.getAttribute("userName");
			String friendName=request.getParameter("friendName");
			FriendshipService fs=FriendshipService.getInstance();
			
			boolean i=fs.deleteFriend(userName, friendName);
			if(i){
				request.setAttribute("msg", "���ѳɹ�ɾ����");
				//response.sendRedirect("../page/friend.jsp");
				request.getRequestDispatcher("../servlet/FriendListServlet").forward(request, response);
			}else{
				request.setAttribute("msg", "ɾ��ʧ��");
				//response.sendRedirect("../page/friend.jsp");
				request.getRequestDispatcher("../servlet/FriendListServlet").forward(request, response);
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
