<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的留言板</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
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
                <li><a href="../page/help.html" target="_blank">帮助</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="zoneName">${zone.zoneName}</h1>
    <div>
        <div class="left-info"><img class="selfie" style="width:8em; height:8em; border-radius:50%;" src="/AmzBlog/upload/${user.userSelfie}"></div>
        <div class="right-info">
            <h3>${user.userNickname}</h3>
            <ul>
                    <li><a href="../servlet/LoginServlet">主页</a></li>
                    <li><a href="getAllBlog.db">日志</a></li>
                    <li><a href="../servlet/FriendListServlet">好友</a></li>
                    <li style="border-bottom: 1px solid #eee; "><a style="color: #eee;" href="findReceivedMsgs.dm">留言板</a></li>
                    <li><a href="findAllFeeling.df">心情</a></li>
                    <li><a href="../servlet/ShowServlet">个人档</a></li>
                    <li><a href="../page/setting.jsp"> 个人设置</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="row">
        <div>
            <h3>
                留言板
            </h3>
            <hr>
            <ul>
                <c:forEach var="t" items="${findReceivedMsgsList}">
                  <li style="border-bottom: 1px solid #aaa;">
                  	<p><a href="../servlet/FriendZoneServlet?friendName=${t.getUser().getUsername()}" style="color:#337ab7;"><img style="width:2em; height:2em; border-radius:50%;" src="/AmzBlog/upload/${t.getUser().getUserSelfie()}">&nbsp;&nbsp;${t.getUser().getUserNickname() }</a></p>
                  	<p>&nbsp;&nbsp;${t.msgContent }</p>
                  	<span style="font-size:.8em">&nbsp;&nbsp;${t.msgCreateTime }&nbsp;&nbsp;&nbsp;</span> <a href="delMessage.dm?msg_Id=${t.msgId}" style="color:#337ab7;">删除</a>
                  </li>
                </c:forEach>
            </ul>
        </div>

    </div>
</div>


</body>
</html>