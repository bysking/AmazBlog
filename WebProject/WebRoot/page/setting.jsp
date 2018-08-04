<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.amzblog.model.Zone" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>空间设置</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
    <script>
    	function changeBg(){
    		var val=$('option:selected').attr('value');
    		$('#img').attr('src',val);

    	}
    </script>
</head>

<body style="background:url('${zone.zoneStyle}');-webkit-background-size:cover; background-size:cover;">
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
                    <li><a href="../servlet/ShowServlet">个人档</a></li>
                    <li style="border-bottom: 1px solid #eee; "><a style="color: #eee;">空间设置</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>

            	<div class="row">
            	<div>
            		<form action="../servlet/ZoneServlet" method="post">
            			<div class="col-xs-6 col-ms-6">
            				<h3>空间装扮</h3>
            				<select name="zoneStyle" class="form-control" onchange="changeBg()">
            					<option value="../img/antique.png">古风（默认）</option>
            					<option value="../img/fresh.jpg">小清新</option>
            					<option value="../img/animation.jpg">动漫</option>
            					<option value="../img/pastoral.jpg">田园风</option>
            					<option value="../img/simple.jpg">简约风</option>
            				</select>
            				<br>
            				<img src="../img/antique.png" width="100%" height="100%" id="img">
            			</div>
            			<div class="col-xs-4 col-ms-4">
            				<h3>空间命名</h3>
            				<input class="btn btn-default" placeholder="空间命名" style="margin-left: 2em" value="${zone.zoneName}" name="zoneName">
            			</div>
            			<div class="clearfix"></div>
            			<div class="row" style="padding-left: 40%;">
            				<div class="col-lg-4">
            					<input type="submit" class="form-control" value="提交更改" style="margin-top: .8em">
            				</div>
            			</div>
            			<div class="clearfix"></div>
            		</form>
            	</div>
            	</div>
            </div>


</body>
</html>