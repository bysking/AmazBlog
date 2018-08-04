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

		 System.out.println("进入blogservletdopost");
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);
		
		BlogService  cs = BlogService.getInstance();
		request.setAttribute("blog_list",cs.getAllBlogService(user));
		
		//String methodName=null;
	//	String servletPathString=request.getServletPath();System.out.println("全路径："+servletPathString);
		//System.out.println(request.getParameter("task"));
		
		
	    String url = request.getRequestURI();
		System.out.println("匹配的路径目录"+url);
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
				//利用反射获取对应的方法名
				 Method method=getClass().getDeclaredMethod("getAllBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("调用响应函数getAllBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet中未找到对应方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
			
		}
		 else if(isMatch2){

			 try {
				//利用反射获取对应的方法名
				 Method method=getClass().getDeclaredMethod("addBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("调用响应函数addBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet中未找到对应方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch3){

			 try {
				//利用反射获取对应的方法名
				 Method method=getClass().getDeclaredMethod("deleteBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("调用响应函数addBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet中未找到对应方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch4){

			 try {
				//利用反射获取对应的方法名
				 Method method=getClass().getDeclaredMethod("updataBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				 System.out.println("调用响应函数updataBlog");
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 //System.out.println("blogservlet中未找到对应方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch5){
			 System.out.println("匹配成功调用响应函数showBlog");
			 try {
				//利用反射获取对应的方法名
				 System.out.println("匹配成功调用响应函数showBlog");
				 Method method=getClass().getDeclaredMethod("showBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet中未找到对应showBlog方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		 else if(isMatch6){
			 System.out.println("匹配成功调用响应函数modifyBlog");
			 try {
				//利用反射获取对应的方法名
				 System.out.println("匹配成功调用响应函数modifyBlog");
				 Method method=getClass().getDeclaredMethod("modifyBlog",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet中未找到对应modifyBlog方法");
				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
		
		 else if(isMatch7){
			 System.out.println("匹配成功调用响应函数addComment");
			 try {
				//利用反射获取对应的方法名
				 System.out.println("匹配成功调用响应函数addComment");
				 Method method=getClass().getDeclaredMethod("addComment",HttpServletRequest.class, HttpServletResponse.class);				
				 method.invoke(this,request,response);		
				
				 //request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			   } 
			 catch (Exception e) 
			{
				 System.out.println("blogservlet中未找到对应addComment方法");
				 request.getRequestDispatcher("/page/friendZone.jsp").forward(request, response);
				// TODO: handle exception
			}
		 }
//			 try {
//				//利用反射获取对应的方法名
//				 Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);				
//				 method.invoke(this,request,response);		
//				 System.out.println("调用响应函数");
//				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//			   } 
//			 catch (Exception e) 
//			{
//				 System.out.println("blogservlet中未找到对应方法");
//				 request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
//				// TODO: handle exception
//			}
			 
			 //加载界面之前刷新界面
			// flushPage(request,  response); 
		//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	

	public void getAllBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    System.out.println("进入获取所有博客的方法");
			HttpSession session=request.getSession();
			String name=(String)session.getAttribute("userName");
			System.out.println("GETALLBLOG的用户名"+name);
			UserService us=UserService.getInstance();
			User user=us.findUser(name);
						
			BlogService  cs = BlogService.getInstance();
		    List<Blog> blog_list=cs.getAllBlogService(user);
			request.setAttribute("blog_list",blog_list);
			/*for(Blog x:blog_list)
				System.out.println(x.getBlogTitle());
			System.out.println();*/
			////////////////////////////////////(添加博客之后的跳转界面)		
			//request.getRequestDispatcher("../page/blog.jsp").forward(request, response);
			request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
			
			//System.out.println("jsp地址:"+request.getServletPath()+"/page/blog.jsp");
			
		}
    public void addBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	System.out.println("进入添加博客的方法");
    	//从jsp获取用户属性构建用户对象
    	HttpSession session=request.getSession(false);
		String name=(String)session.getAttribute("userName");
		UserService us=UserService.getInstance();
		User user=us.findUser(name);
    	String blogTitle=request.getParameter("blogTitle");
    	System.out.println("后台取得的博客名："+blogTitle);
    	String blogContent=request.getParameter("blogContent");
    	String blogContentHtml=request.getParameter("blogContentHtml");
    	System.out.println("后台取得的博客内容1："+blogContent);
    	System.out.println("后台取得的博客内容2："+blogContentHtml);
			
    	//从jsp获取日志属性构建日志对象
		Blog blog=new Blog();
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setBlogContentHtml(blogContentHtml);
		blog.setUser(user);
		blog.setBlogCreateTime(DateUtils.getCurrTime());
		
		
		/////////////////////////////(等待编写构建代码)

		System.out.println("构建的blog博客内容："+blog.getBlogContentHtml());
		
		BlogService  cs = BlogService.getInstance();
		boolean status=cs.insertBlogByUserService(blog);
		System.out.println(status);
		request.setAttribute("addState",status);
		request.setAttribute("showBlog",blog);
		
		////////////////////////////////////(添加博客之后的跳转界面)

		//getAllBlog(request, response);
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
		
	}
    
    public void showBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	HttpSession session=request.getSession(false);
    	System.out.println("进入响应函数showBlog");
    	int blogId = Integer.parseInt(request.getParameter("blogId"));
    	System.out.println("需要显示的日志id"+blogId);
		BlogService  cs = BlogService.getInstance();
		Blog showBlog=cs.findBlogByBlodIdService(blogId);
		Zone zone=(Zone)session.getAttribute("zone");
		request.setAttribute("zone", zone);
		request.setAttribute("showBlog",showBlog);
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
	}
    
    public void getBlogByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		int pageIndex=0;//目标页面
		/////////////////////////////(等待编写构建代码)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getPageIndex",cs.getBlogByPageService(user, pageIndex));
		
		////////////////////////////////////(添加博客之后的跳转界面)		
		//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("成功反射add");
		
	}
    public void getPageCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		/////////////////////////////(等待编写构建代码)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getPageCount",cs.getPageCount(user));
		
		////////////////////////////////////(添加博客之后的跳转界面)		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("成功反射add");
		
	}
    public void getBlogCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		/////////////////////////////(等待编写构建代码)

		BlogService  cs = BlogService.getInstance();
	
		request.setAttribute("getBlogCount",cs.getBlogCount(user));
		
		////////////////////////////////////(添加博客之后的跳转界面)		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("成功反射add");
	
	}
	public void deleteBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入删除博客");
		
		//从jsp获取用户属性构建用户对象
		//从jsp获取日志
				int blogId=0;
				blogId=Integer.parseInt((String)request.getParameter("BlogId"));
				System.out.println("前台获取blogid"+blogId);
			//	Blog blog = null;
		/////////////////////////////(等待编写构建代码,blogId需要从界面获取)
	
				BlogService  cs = BlogService.getInstance();
				boolean deletestatus=cs.delBlogService(blogId);
				
				request.setAttribute("deleteState",deletestatus);
				////////////////////////////////////(添加博客之后的跳转界面)				
				getAllBlog(request, response);
				//request.getRequestDispatcher("/WebRoot/page/blog.jsp").forward(request, response);
				//request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	public void updataBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入更新博客方法");
		String blogTitle = request.getParameter("blogTitle2");
		String blogContent = request.getParameter("blogContent2");
		String blogContentHtml = request.getParameter("blogContentHtml2");
		
		System.out.println("进入servlet要更新博客名字："+blogTitle);
		System.out.println("更新的博客内容："+blogContent);
		System.out.println("更新的博客html内容："+blogContentHtml);
		
		
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("取得要更新的ID："+blogId);
		//从jsp获取用户属性构建用户对象
		//显示原来的blog
		BlogService cs =BlogService.getInstance();
		Blog blog=cs.findBlogByBlodIdService(blogId);
		
		blog.setBlogTitle(blogTitle);
		blog.setBlogContent(blogContent);
		blog.setBlogContentHtml(blogContentHtml);
		blog.setBlogCreateTime(DateUtils.getCurrTime());
		
		System.out.println("old："+blog.getBlogId());
		System.out.println("old："+blog.getBlogTitle());
		System.out.println("old："+blog.getBlogContent());
		//System.out.println("old："+blog.getUser());
		request.setAttribute("showBlog",blog);
		
		
		cs.changeBlogByUserService(blog);
		
		request.getRequestDispatcher("/page/showBlog.jsp").forward(request, response);
		
		
	}
	
	public void modifyBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入修改博客方法");
		BlogService  cs =BlogService.getInstance();
		
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("修改博客deID"+	blogId);
		Blog blog=cs.findBlogByBlodIdService(blogId);
		System.out.println(blog.getBlogTitle());
        request.setAttribute("modifyBlog",blog);
        
//		System.out.println("进入servlet要修改的博客名字："+blog.getBlogTitle());
//		System.out.println("要修改的博客内容："+blog.getBlogContent());
//		System.out.println("要修改的博客html内容："+blog.getBlogContentHtml());
		/////////////////////////////(等待编写构建代码,user,blog需要构建)
				
				
		//String blogContent = request.getParameter("blogContent");
		//blog.setBlogContent(blogContent);
		
		//request.setAttribute("updataBlogStatus",cs.changeBlogByUserService(blog));
				
		////////////////////////////////////(添加博客之后的跳转界面)
		//getAllBlog(request, response);
		request.getRequestDispatcher("/page/modifyBlog.jsp").forward(request, response);
	}
	@SuppressWarnings("null")
	//利用日志标题进行查找
	public void findBlogByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		//从jsp获取日志的标题
		String blogTitle=null;
/////////////////////////////(等待编写构建代码,user,blogTitle需要构建)
		
		
//String username = request.getParameter("username");
//String pwd = request.getParameter("pwd");
	
		
		BlogService  cs =BlogService.getInstance();
		//取得所有日志列表
		List<Blog> allBlogList=cs.getAllBlogService(user); 
		//结果日志列表
		List<Blog> resultBlogList=null;  
		
		for(Blog x:allBlogList){
			
			if(x.getBlogTitle().equals(blogTitle))
				resultBlogList.add(x);
			
		}
		
		request.setAttribute("resultBlogList",resultBlogList);
		
		////////////////////////////////////(添加博客之后的跳转界面，查询结果界面)
		
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
		//System.out.println("成功反射find");
	}

	public void addComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		System.out.println("进入添加评论方法");
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		UserDao csDao=UserDaoImpl.getInstance();
		User friend=csDao.find(request.getParameter("friendName"));
		request.setAttribute("friend",friend);
		System.out.println("被评论的人的名字："+friend.getUsername());
		//String user = request.getParameter("user");
		int blogId=Integer.parseInt(request.getParameter("blogId"));
		System.out.println("即将评论博客id：："+blogId);
		
		BlogService cs =BlogService.getInstance();
		Blog blog=cs.findBlogByBlodIdService(blogId);
		System.out.println("被评论博客名字：："+blog.getBlogTitle());
		
		String commentContent = request.getParameter("comment");
		System.out.println("评论内容：："+friend.getUsername());
		
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
		if(insert_status)System.out.println("添加评论成功");
		request.setAttribute("addCommentState",insert_status);
		request.setAttribute("friendName",friend.getUsername());		
				////////////////////////////////////(添加博客之后的跳转界面)
		request.getRequestDispatcher("../servlet/FriendZoneServlet").forward(request, response);
	}
	
	public void delComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		int commentId=0;
		/////////////////////////////(等待编写构建代码,user,blog需要构建)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		request.setAttribute("delCommentState",cs.delCommentByUserService(commentId));				
		////////////////////////////////////(添加博客之后的跳转界面)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
	
	public void changeComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		Comment comment = null;
		/////////////////////////////(等待编写构建代码,user,blog需要构建)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		request.setAttribute("changeCommentState",cs.changeCommentByUserService(comment));				
		////////////////////////////////////(添加博客之后的跳转界面)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}

	public void findComment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		User user=null;
		Blog blog = null;
		/////////////////////////////(等待编写构建代码,user,blog需要构建)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
		
		List<Comment> commentList=cs.getAllCommentService(blog);
		
		request.setAttribute("findallCommentState",commentList);	
		
		////////////////////////////////////(添加博客之后的跳转界面)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}

	public void getCommentCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从jsp获取用户属性构建用户对象
		Blog blog = null;
		/////////////////////////////(等待编写构建代码,blog需要构建)
								
		//String username = request.getParameter("username");
		//String pwd = request.getParameter("pwd");
				
		CommentService  cs = CommentService.getInstance();	
	
		int count=cs.getAllCommentService(blog).size();
		request.setAttribute("getCommentCount",count);	
		
		////////////////////////////////////(添加博客之后的跳转界面)				
		request.getRequestDispatcher("/page/blog.jsp").forward(request, response);
	}
}
