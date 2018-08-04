package com.amzblog.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.transport.RxTaskPool.TaskCreator;

import com.amzblog.dao.UserDao;
import com.amzblog.daoImpl.UserDaoImpl;
import com.amzblog.model.Blog;
import com.amzblog.model.Comment;
import com.amzblog.model.User;
import com.amzblog.model.Zone;
import com.amzblog.service.BlogService;
import com.amzblog.service.CommentService;
import com.amzblog.service.UserService;
import com.amzblog.utils.DBUtils;
import com.amzblog.utils.DateUtils;
public class BlogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		doPost(request, response);
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

		 System.out.println("����blogservletdopost");
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);
		
		BlogService  cs = BlogService.getInstance();
		request.setAttribute("blog_list",cs.getAllBlogService(user));
		
		//String methodName=null;
	//	String servletPathString=request.getServletPath();System.out.println("ȫ·����"+servletPathString);
		//System.out.println(request.getParameter("task"));
		
		
	    String url = request.getRequestURI();
		System.out.println("ƥ���·��Ŀ¼"+url);
		String content = url;
		String pattern_getAllBlog = ".*getAllBlog.*";
		String pattern_addBlog= ".*addBlog.*";
		String pattern_deleteBlog= ".*deleteBlog.*";
		String pattern_updataBlog= ".*updataBlog.*";
		String pattern_showBlog= ".*showBlog.*";
		String pattern_modifyBlog= ".*modifyBlog.*";
		String pattern_addComment= ".*addComment.*";
		boolean isMatch1 = Pattern.matches(pattern_getAllBlog, content);
		boolean isMatch2 = Pattern.matches(pattern_addBlog, content);
		boolean isMatch3 = Pattern.matches(pattern_deleteBlog, content);
		boolean isMatch4 = Pattern.matches(pattern_updataBlog, content);
		boolean isMatch5 = Pattern.matches(pattern_showBlog, content);
		boolean isMatch6 = Pattern.matches(pattern_modifyBlog, content);
		boolean isMatch7 = Pattern.matches(pattern_addComment, content);
		if(isMatch1){

			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 Method method=getClass().getDeclaredMethod("getAllBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("������Ӧ����getAllBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
			
		}
		 else if(isMatch2){

			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 Method method=getClass().getDeclaredMethod("addBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("������Ӧ����addBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch3){

			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 Method method=getClass().getDeclaredMethod("deleteBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("������Ӧ����addBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch4){

			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 Method method=getClass().getDeclaredMethod("updataBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("������Ӧ����updataBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet��δ�ҵ���Ӧ����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch5){
			 System.out.println("ƥ��ɹ�������Ӧ����showBlog");
			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 System.out.println("ƥ��ɹ�������Ӧ����showBlog");
				 Method method=getClass().getDeclaredMethod("showBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet��δ�ҵ���ӦshowBlog����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch6){
			 System.out.println("ƥ��ɹ�������Ӧ����modifyBlog");
			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 System.out.println("ƥ��ɹ�������Ӧ����modifyBlog");
				 Method method=getClass().getDeclaredMethod("modifyBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet��δ�ҵ���ӦmodifyBlog����");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		
		 else if(isMatch7){
			 System.out.println("ƥ��ɹ�������Ӧ����addComment");
			 try {
				//���÷����ȡ��Ӧ�ķ�����
				 System.out.println("ƥ��ɹ�������Ӧ����addComment");
				 Method method=getClass().getDeclaredMethod("addComment",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet��δ�ҵ���ӦaddComment����");
				 request.getRequestDispatcher("/page/friendZone.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
//			 try {
//				//���÷����ȡ��Ӧ�ķ�����
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);		
//				 System.out.println("������Ӧ����");
//				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("blogservlet��δ�ҵ���Ӧ����");
//				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//				// TODO: handle exception
//			}
			 
			 //���ؽ���֮ǰˢ�½���
			// flushPage(request,  response); 
		//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	

	public void getAllBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    System.out.println("�����ȡ���в��͵ķ���");
			HttpSession session=request.getSession();
			String name=(String)session.getAttribute("userName");
			System.out.println("GETALLBLOG���û���"+name);
			UserService us=UserService.getInstance();
			User user=us.findUser(name);
						
			BlogService  cs = BlogService.getInstance();
		    List<Blog> blog_list=cs.getAllBlogService(user);
			request.setAttribute("blog_list",blog_list);
			/*for(Blog x:blog_list)
				System.out.println(x.getBlogTitle());
			System.out.println();*/
			////////////////////////////////////(��Ӳ���֮�����ת����)		
			//request.getRequestDispatcher("../page/blog.jsp").forward(request, response);
			request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			
			//System.out.println("jsp��ַ:"+request.getServletPath()+"/page/blog.jsp");
			
		}
    public void addBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	System.out.println("������Ӳ��͵ķ���");
    	//��jsp��ȡ�û����Թ����û�����
    	HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);
    	String blogTitle=request.getParameter("blogTitle");
    	System.out.println("��̨ȡ�õĲ�������"+blogTitle);
    	String blogContent=request.getParameter("blogContent");
    	String blogContentHtml=request.getParameter("blogContentHtml");
    	System.out.println("��̨ȡ�õĲ�������1��"+blogContent);
    	System.out.println("��̨ȡ�õĲ�������2��"+blogContentHtml);
			
    	//��jsp��ȡ��־���Թ�����־����
		Blog blog=new Blog();
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setBlogContentHtml(blogContentHtml);
		blog.setUser(user);
		blog.setBlogCreateTime(DateUtils.getCurrTime());
		
		
		/////////////////////////////(�ȴ���д��������)

		System.out.println("������blog�������ݣ�"+blog.getBlogContentHtml());
		
		BlogService  cs = BlogService.getInstance();
		boolean status=cs.insertBlogByUserService(blog);
		System.out.println(status);
		request.setAttribute("addState",status);
		request.setAttribute("showBlog",blog);
		
		////////////////////////////////////(��Ӳ���֮�����ת����)

		//getAllBlog(request, response);
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
		
	}
    
    public void showBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	HttpSession session=request.getSession(false);
    	System.out.println("������Ӧ����showBlog");
    	int blogId = Integer.parseInt(request.getParameter("blogId"));
    	System.out.println("��Ҫ��ʾ����־id"+blogId);
		BlogService  cs = BlogService.getInstance();
		Blog showBlog=cs.findBlogByBlodIdService(blogId);
		Zone zone=(Zone)session.getAttribute("zone");
		request.setAttribute("zone", zone);
		request.setAttribute("showBlog",showBlog);
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
	}
    
    public void getBlogByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		int pageIndex=0;//Ŀ��ҳ��
		/////////////////////////////(�ȴ���д��������)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getPageIndex",cs.getBlogByPageService(user, pageIndex));
		
		////////////////////////////////////(��Ӳ���֮�����ת����)		
		//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("�ɹ�����add");
		
	}
    public void getPageCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		/////////////////////////////(�ȴ���д��������)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getPageCount",cs.getPageCount(user));
		
		////////////////////////////////////(��Ӳ���֮�����ת����)		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("�ɹ�����add");
		
	}
    public void getBlogCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		/////////////////////////////(�ȴ���д��������)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getBlogCount",cs.getBlogCount(user));
		
		////////////////////////////////////(��Ӳ���֮�����ת����)		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("�ɹ�����add");
	
	}
	public void deleteBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����ɾ������");
		
		//��jsp��ȡ�û����Թ����û�����
		//��jsp��ȡ��־
				int blogId=0;
				blogId=Integer.parseInt((String)request.getParameter("BlogId"));
				System.out.println("ǰ̨��ȡblogid"+blogId);
			//	Blog blog = null;
		/////////////////////////////(�ȴ���д��������,blogId��Ҫ�ӽ����ȡ)
	
				BlogService  cs = BlogService.getInstance();
				boolean deletestatus=cs.delBlogService(blogId);
				
				request.setAttribute("deleteState",deletestatus);
				////////////////////////////////////(��Ӳ���֮�����ת����)				
				getAllBlog(request, response);
				//request.getRequestDispatcher("/WebRoot/page/blog.jsp").forward(request, response);
				//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	public void updataBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("������²��ͷ���");
		String blogTitle = request.getParameter("blogTitle2");
		String blogContent = request.getParameter("blogContent2");
		String blogContentHtml = request.getParameter("blogContentHtml2");
		
		System.out.println("����servletҪ���²������֣�"+blogTitle);
		System.out.println("���µĲ������ݣ�"+blogContent);
		System.out.println("���µĲ���html���ݣ�"+blogContentHtml);
		
		
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("ȡ��Ҫ���µ�ID��"+blogId);
		//��jsp��ȡ�û����Թ����û�����
		//��ʾԭ����blog
		BlogService cs =BlogService.getInstance();
		Blog blog=cs.findBlogByBlodIdService(blogId);
		
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setBlogContentHtml(blogContentHtml);
		blog.setBlogCreateTime(DateUtils.getCurrTime());
		
		System.out.println("old��"+blog.getBlogId());
		System.out.println("old��"+blog.getBlogTitle());
		System.out.println("old��"+blog.getBlogContent());
		//System.out.println("old��"+blog.getUser());
		request.setAttribute("showBlog",blog);
		
		
		cs.changeBlogByUserService(blog);
		
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
		
		
	}
	
	public void modifyBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("�����޸Ĳ��ͷ���");
		BlogService  cs =BlogService.getInstance();
		
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("�޸Ĳ���deID"+	blogId);
		Blog blog=cs.findBlogByBlodIdService(blogId);
		System.out.println(blog.getBlogTitle());
        request.setAttribute("modifyBlog",blog);
        
//		System.out.println("����servletҪ�޸ĵĲ������֣�"+blog.getBlogTitle());
//		System.out.println("Ҫ�޸ĵĲ������ݣ�"+blog.getBlogContent());
//		System.out.println("Ҫ�޸ĵĲ���html���ݣ�"+blog.getBlogContentHtml());
		/////////////////////////////(�ȴ���д��������,user,blog��Ҫ����)
				
				
		//String blogContent = request.getParameter("blogContent");
		//blog.setBlogContent(blogContent);
		
		//request.setAttribute("updataBlogStatus",cs.changeBlogByUserService(blog));
				
		////////////////////////////////////(��Ӳ���֮�����ת����)
		//getAllBlog(request, response);
		request.getRequestDispatcher("/page/modifyBlog.jsp").forward(request, response);
	}
	@SuppressWarnings("null")
	//������־������в���
	public void findBlogByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		//��jsp��ȡ��־�ı���
		String blogTitle=null;
/////////////////////////////(�ȴ���д��������,user,blogTitle��Ҫ����)
		
		
//String username = request.getParameter("username");
//String pwd = request.getParameter("pwd");
	
		
		BlogService  cs =BlogService.getInstance();
		//ȡ��������־�б�
		List<Blog> allBlogList=cs.getAllBlogService(user); 
		//�����־�б�
		List<Blog> resultBlogList=null;  
		
		for(Blog x:allBlogList){
			
			if(x.getBlogTitle().equals(blogTitle))
				resultBlogList.add(x);
			
		}
		
		request.setAttribute("resultBlogList",resultBlogList);
		
		////////////////////////////////////(��Ӳ���֮�����ת���棬��ѯ�������)
		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("�ɹ�����find");
	}

	public void addComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		System.out.println("����������۷���");
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		UserDao csDao=UserDaoImpl.getInstance();
		User friend=csDao.find(request.getParameter("friendName"));
		request.setAttribute("friend",friend);
		System.out.println("�����۵��˵����֣�"+friend.getUsername());
		//String user = request.getParameter("user");
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("�������۲���id����"+blogId);
		
		BlogService cs =BlogService.getInstance();
		Blog blog=cs.findBlogByBlodIdService(blogId);
		System.out.println("�����۲������֣���"+blog.getBlogTitle());
		
		String commentContent = request.getParameter("comment");
		System.out.println("�������ݣ���"+friend.getUsername());
		
		Comment comment=new Comment();
		comment.setBlog(blog);
		comment.setCommContent(commentContent);
		comment.setCommCreateTime(DateUtils.getCurrTime());
		comment.setUser(user);
		
		
		
		Set<Comment> blogSet=blog.getComments();
		blogSet.add(comment);
		//cs.changeBlogByUserService(blog);
//		Comment comment=new Comment();
//		//comment.setBlog(blog);
//		comment.setCommContent(commentContent);
//		comment.setCommCreateTime(DateUtils.getCurrTime());
//		comment.setUser(friend);
		//String pwd = request.getParameter("pwd");	
		
		CommentService  cs2 = CommentService.getInstance();	
		boolean insert_status=cs2.insertCommentByUserService(comment);
		if(insert_status)System.out.println("������۳ɹ�");
		request.setAttribute("addCommentState",insert_status);
		request.setAttribute("friendName",friend.getUsername());		
				////////////////////////////////////(��Ӳ���֮�����ת����)
		request.getRequestDispatcher("../servlet/FriendZoneServlet").forward(request, response);
	}
	
	public void delComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		int commentId=0;
		/////////////////////////////(�ȴ���д��������,user,blog��Ҫ����)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		request.setAttribute("delCommentState",cs.delCommentByUserService(commentId));				
		////////////////////////////////////(��Ӳ���֮�����ת����)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	
	public void changeComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		Comment comment = null;
		/////////////////////////////(�ȴ���д��������,user,blog��Ҫ����)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		request.setAttribute("changeCommentState",cs.changeCommentByUserService(comment));				
		////////////////////////////////////(��Ӳ���֮�����ת����)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}

	public void findComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		User user=null;
		Blog blog = null;
		/////////////////////////////(�ȴ���д��������,user,blog��Ҫ����)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		
		List<Comment> commentList=cs.getAllCommentService(blog);
		
		request.setAttribute("findallCommentState",commentList);	
		
		////////////////////////////////////(��Ӳ���֮�����ת����)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}

	public void getCommentCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��jsp��ȡ�û����Թ����û�����
		Blog blog = null;
		/////////////////////////////(�ȴ���д��������,blog��Ҫ����)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
	
		int count=cs.getAllCommentService(blog).size();
		request.setAttribute("getCommentCount",count);	
		
		////////////////////////////////////(��Ӳ���֮�����ת����)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
}
