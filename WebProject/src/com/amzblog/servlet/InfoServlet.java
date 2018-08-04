package com.amzblog.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.amzblog.model.User;
import com.amzblog.service.UserService;
import com.amzblog.utils.Form2Bean;
import com.amzblog.utils.DateUtils;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@MultipartConfig
public class InfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InfoServlet() {
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
	private ServletConfig config;

	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession(false);
		
		SmartUpload mySmartUpload=new SmartUpload();
		int count=0;
		
		//PrintWriter out = response.getWriter();
		try{
			User user=(User)session.getAttribute("user");
			// 初始化
			mySmartUpload.initialize(config, request, response);
			//设置上传文件
			mySmartUpload.setMaxFileSize(1024*1024*10);
			//设置所有文件的大小
			mySmartUpload.setTotalMaxFileSize(1024*1024*100);
			//设置文件的类型
			mySmartUpload.setAllowedFilesList("txt,jpg,png,gif,JPG");
			// 上传
			mySmartUpload.upload();
			
			// 设置文件在服务器的保存位置
			String path = "/upload";
			String realPath = config.getServletContext().getRealPath(path);
			String fileName="";
			System.out.println(realPath);
			java.io.File myFilePath = new java.io.File(realPath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
			if(mySmartUpload.getFiles().getSize()!=0){
				com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(0);
				fileName = myfile.getFileName();
				String userSelfie=realPath+"\\"+fileName;
				System.out.println(fileName);
				System.out.println(user.getUserSelfie());
				myfile.saveAs(userSelfie);
				System.out.println(userSelfie);	
			}else{
				fileName=user.getUserSelfie();
			}
			// 文件另存为
			count = mySmartUpload.save(path);
			System.out.println(count + " file uploaded.");			
			
			UserService us=UserService.getInstance();
			String userName=user.getUsername();
			int userId=user.getUserId();
			String userPassword=user.getUserPassword();

			System.out.println(mySmartUpload.getRequest().getParameter("userBlogAddr"));
			user=Form2Bean.userF2B(mySmartUpload.getRequest());
			user.setUserId(userId);
			user.setUsername(userName);
			user.setUserPassword(userPassword);
			user.setUserSelfie(fileName);
			System.out.println(user.getUserSelfie());

			//String userBirthdate=mySmartUpload.getRequest().getParameter("userBirthdate");
			us.updateInfo(user);
			
			session.setAttribute("user", user);
			request.getRequestDispatcher("../servlet/ShowServlet").forward(request,response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
