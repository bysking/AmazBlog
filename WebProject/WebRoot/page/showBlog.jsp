<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.amzblog.model.Blog" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>查看博客</title>
    <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--editormd.preview start  -->
    <link rel="stylesheet" href="../test/editor/css/editormd.preview.min.css" />
    <link rel="stylesheet" href="../test/editor/css/editormd.css" />
    <!-- <div class="content" id="content">${faq.text }</div>   ${faq.text }内容为从服务器获取的HTML
    
        <div class="content" id="content"><hr> <p>rewtf<strong>erwefgfewfwsvc</strong></p> <blockquote> <blockquote> <hr style="page-break-after:always;" class="page-break editormd-page-break" /></blockquote> </blockquote> <hr style="page-break-after:always;" class="page-break editormd-page-break" /><p>[========]<br>| | |ul<br>| —————— | —————— |<br>| | |<br>| | |</p> <h1 id="h1-erftewg"><a name="erftewg" class="reference-link"></a><span class="header-link octicon octicon-link"></span>erftewg</h1><pre><code>@RequestMapping(&quot;/activatemail&quot;) private String activatemail(String actiCode,String email){ logger.debug(&quot;ws-----activatemail----actiCode=&quot;+actiCode+&quot; email=&quot;+email); Person person = new Person(); person.setActiCode(actiCode); person.setMail(email); boolean isAc = this.personService.activatEmail(person); if(isAc){//激活成功，3秒跳转 return &quot;activateCode&quot;; }else{ //激活失败页面 return &quot;activateCode&quot;; } }jyghjmmkghmkghm </code></pre><p>```uluil,ui.,u.,uo.uokiulk</p></div>
    
    -->

    <script type="text/javascript" src="../AmzBlog/js/jquery.min.js"></script>
    <script src="../AmzBlog/editor/lib/marked.min.js"></script>
    <script src="../AmzBlog/editor/lib/prettify.min.js"></script>
    <script src="../AmzBlog/editor/editormd.min.js"></script>
    
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../AmzBlog/css/common.css">
 
  <script type="text/javascript">
    editormd.markdownToHTML("content",{
          htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });
  </script>

  </head>
  <%
  	Blog showBlog=(Blog)request.getAttribute("showBlog");
   %>
  <body style="background:#ccc; -webkit-background-size:cover; background-size:cover;">
    <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="nav-header">
            <a class="navbar-brand" href="/AmzBlog/servlet/LoginServlet">AmazingBlog</a>
            <a class="navbar-brand" href="/AmzBlog//servlet/getAllBlog.db" >返回日志页</a>
            
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html">退出</a></li>
                <li><a href="../page/help.html" target="_blank">关于</a></li>
            </ul>
        </div>
    </div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="content" id="content">
				
				<h3 class="text-center">标题：<%= showBlog.getBlogTitle()%></h3>
				<div>
					
					<%=showBlog.getBlogContentHtml()%>
				</div>
			</div>
			
		</div>
	</div>
  </body>
</html>
