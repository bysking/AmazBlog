<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>写博客</title>
    
    <meta charset="UTF-8">
    <meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../AmzBlog/editor/css/editormd.min.css">
	<script type="text/javascript" src="../AmzBlog/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../AmzBlog/editor/editormd.min.js"></script>
 	
 	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../AmzBlog/css/common.css">
 	
 	<script type="text/javascript">
  var testEditor;

  testEditor=$(function() {
      editormd("test-editormd", {
           width   : "80%",
           height  : 640,
           //markdown : md,
           codeFold : true,
           syncScrolling : "single",
           //你的lib目录的路径
           path    : "../AmzBlog/editor/lib/",
           imageUpload: false,//关闭图片上传功能
          /*  theme: "dark",//工具栏主题
           previewTheme: "dark",//预览主题
           editorTheme: "pastel-on-dark",//编辑主题 */
           emoji: false,
           taskList: true, 
           tocm: true,         // Using [TOCM]
           tex: true,                   // 开启科学公式TeX语言支持，默认关闭
           flowChart: true,             // 开启流程图支持，默认关闭
           sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
          //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
           saveHTMLToTextarea : true            
      });

  });

</script>
	

  </head>
  
  <body style="background:url('${zone.zoneStyle}'); -webkit-background-size:cover; background-size:cover;">
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="nav-header">
            <a class="navbar-brand">AmazingBlog</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html">退出</a></li>             
                <li><a href="../page/help.html" target="_blank">关于</a></li>
            </ul>
        </div>
    </div>
</nav>
	<form action="/AmzBlog/servlet/addBlog.db" method="post">
		<input type="text" name="blogTitle" id="blogTitle" placeholder="输入博客标题" class="form-control" style="display: inline-block; margin:.5em 10%; width:80%">
		<div class="editormd" id="test-editormd">
    		<textarea  class="editormd-markdown-textarea" name="blogContent" id="editormd"></textarea>
    		<!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
    		<!-- html textarea 需要开启配置项 saveHTMLToTextarea == true -->
    		<textarea class="editormd-html-textarea" name="blogContentHtml" id="editorhtml"></textarea>       
    	</div>
    	<input type="submit" value="提交博客" style="margin:.5em 48%" class="btn btn-default" >
	</form>
   
    <!-- editormd 测试  start 
    
    <p id="p1"></p><br>
    <p id="p2"></p><br>
    <button id="btn">按钮</button><br>
      <script type="text/javascript">
     $('#btn').click(function() {
       //获取第二个textarea的值，即生成的HTML代码   实际开发中此值存入后台数据库
       var editorhtml=$("#editorhtml").val();
       $("#p1").text(editorhtml+" editorhtml");
       //获取第一个textarea的值，即md值  实际开发中此值存入后台数据库
        var editormd2=$("#editormd").val();
       $("#p2").text(editormd2+" editormd");

     });
    --> 


   

     <script type="text/javascript"> 
     $(document).ready(function() {
       $("#editormd").text("A New Amazing Blog");
     });
     </script>
      <!-- editormd 测试 end --> 
  </body>
</html>
