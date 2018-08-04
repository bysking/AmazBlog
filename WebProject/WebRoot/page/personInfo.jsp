<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.amzblog.model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
</head>
<body style="background:url('${zone.zoneStyle}'); -webkit-background-size:cover; background-size:cover;">
<%
	User user=(User)session.getAttribute("user");
 %>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="nav-header">
            <a class="navbar-brand">AmazingBlog</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../page/login.jsp">退出</a></li>
                <li><a href="../page/help.html" target="_blank">关于</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="zoneName">${zone.zoneName}</h1>
    <div>
        <div class="left-info"><img class="selfie" style="width:8em; height:8em; border-radius:50%;" src="/AmzBlog/upload/${user.userSelfie}"/></div>
        <div class="right-info">
            <h3>${user.userNickname}</h3>
            <ul>
                    <li><a href="../servlet/LoginServlet">主页</a></li>
                    <li><a href="getAllBlog.db">日志</a></li>
                    <li><a href="../servlet/FriendListServlet">好友</a></li>
                    <li><a href="findReceivedMsgs.dm">留言板</a></li>
                    <li><a href="findAllFeeling.df">心情</a></li>
                    <li style="border-bottom: 1px solid #eee; "><a style="color: #eee;">个人档</a></li>
                    <li><a href="../page/setting.jsp"> 个人设置</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="row">
        <div>
            <h3>个人档</h3>
            <a href="../page/modifyInfo.jsp">修改</a>
            <hr>
            <table style="margin-left:1.5em; line-height:2em;" cellpadding="10px" cellspacing="10px">
            	<tr>
            		<td>昵称：</td>
            		<td><%= user.getUserNickname()%></td>
            	</tr>
            	<tr>
            		<td>性别：</td>
            		<td><%= user.getUserSex()%></td>
            	</tr>
            	<tr>
            		<td>年龄：</td>
            		<td><%= user.getUserAge()%></td>
            	</tr>
            	<tr>
            		<td>生日：</td>
            		<td>${userBirthdate}</td>
            	</tr>
            	<tr>
            		<td>邮箱：</td>
            		<td><%= user.getUserEmailAddr()%></td>
            	</tr>
            	<tr>
            		<td>博客：</td>
            		<td><%= user.getUserBlogAddr()%></td>
            	</tr>
            	<tr>
            		<td>微信：</td>
            		<td><%= user.getUserWechat()%></td>
            	</tr>
            	<tr>
            		<td>QQ:</td>
            		<td><%= user.getUserQq()%></td>
            	</tr>
            	<tr>
            		<td>手机：</td>
            		<td><%= user.getUserPhone()%></td>
            	</tr>
            </table>
        </div>

    </div>
</div>


</body>
</html>