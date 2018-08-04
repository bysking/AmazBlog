<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
    <script>
    	window.onload = function () {
    		var userName=document.getElementById("userName");
    		var deleteUser=document.getElementById("deleteUser");
    		
    	}
    </script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="nav-header">
            <a class="navbar-brand">AmazingBlog</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html">退出</a></li>
                <li><a href="help.html" target="_blank">帮助</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1>我是空间名字</h1>
    <div>
        <div class="left-info"><img src="../img/logo.png"></div>
        <div class="right-info">
            <h3>${userName}</h3>
            <ul>
                    <li><a href="../servlet/LoginServlet">主页</a></li>
                    <li><a href="../servlet/BlogServlet">日志</a></li>
                    <li><a href="../servlet/FriendListServlet">好友</a></li>
                    <li><a href="../servlet/MessageServlet">留言板</a></li>
                    <li><a href="../servlet/FeelingServlet">心情</a></li>
                    <li><a href="#">个人档</a></li>
                    <li><a href="#"> 个人设置</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="row">
        <div>
            <h3>管理员</h3>
            <hr>
            <form>
                <table cellspacing="1em" cellpadding="2em">
                    <tr>
                        <td><input type="text" placeholder="输入用户名删除用户" id="userName"> <a id="deleteUser">删除</a>
                        </td>
                    </tr>
                    <tr><td><p></p></td></tr>
                    <tr>
                        <td><input type="text" placeholder="输入日志ID进行删除" id="blogId"><a id="deleteBlog"> 删除</a></td>
                    </tr>
                </table>
            </form>
        </div>

    </div>
</div>


</body>
</html>