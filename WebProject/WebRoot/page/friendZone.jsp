<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.amzblog.model.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>好友空间</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
    <style>
    .panel{
    border:none;
    }
    </style>
</head>
<body style="background:url('${fzone.zoneStyle}'); -webkit-background-size:cover; background-size:cover;">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="nav-header">
                <a class="navbar-brand">AmazingBlog </a>
                <span class="navbar-brand">||</span>
                <a href="../servlet/LoginServlet" class="navbar-brand"> 返回我的空间</a>
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
        <h1>${fzone.zoneName}</h1>
        <div>
            <div class="left-info"><img class="selfie" style="width:8em; height:8em; border-radius:50%;" src="/AmzBlog/upload/${friend.userSelfie}"/></div>
            <div class="right-info">
                <h3>${friend.userNickname}</h3>
            </div>
            <div class="clearfix"></div>
        </div>
        
        
        <div class="row">
            <div class="col-xs-3 col-ms-3">
                <ul>
                    <li><a>日志 (<span>${blog_number}</span>)</a></li>
                    <li><a>心情 (<span>${feeling_number}</span>)</a></li>

                    <li><a>留言板 (<span>${Msg_number}</span>)</a></li>
                </ul>
                <hr>
                <div>
                	<form action="addMessage.dm?friendName=${friend.username}" method="post">
                		<textarea name="msg" class="form-control input-lg" placeholder="给好友留言" style="font-size:.8em"></textarea>
                		<input type="submit" class="btn btn-default" value="发布留言" style="margin-top:1em; font-size:.8em">
                	</form>
                </div>
            </div>
            <div class="col-xs-8 col-ms-8">
                <h3>最近动态</h3>
                <hr>
                <div class="panel-group">
                	<div class="panel panel-default">
                		<div class="panel-heading">
                			<h4 class="panel-title">
                				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#recentBlog">最近博客</a>
                			</h4>
                		</div>
                		<div id="recentBlog" class="panel-collapse collapse">
                			<div class="panel-body">
                				<ul>
                    				<c:forEach var="t" items="${blog_list}">
                    					<li style="border-bottom: 1px solid #aaa;">
                    						<h5>日志标题：<a style="color:#337ab7;" href="/AmzBlog/servlet/showBlog.db?blogId=${t.getBlogId()}">${t.getBlogTitle()}</a></h5>
                    						<span style="font-size:.8em">${t.blogCreateTime}</span>
                    						<ul>
                    							<br>
                    							<p>评论：</p>
                    							<c:forEach var="comment" items="${t.getComments() }">
                    								<li>
                    									<p><a href="../servlet/FriendZoneServlet?friendName=${comment.getUser().getUsername()}" style="color:#337ab7;" ><img style="width:2em; height:2em; border-radius:50%;" src="/AmzBlog/upload/${comment.getUser().getUserSelfie()}">${comment.getUser().getUserNickname()}</a></p>
                    									<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${comment.getCommContent() }</p>
                    								</li>
                    							</c:forEach>
                    							<form action="addComment.db?friendName=${friend.username}&blogId=${t.getBlogId()}" method="post">
                    								<input type="text" name="comment" placeholder="添加评论" class="form-control">
                    								<input type="submit" value="评论" style="margin:1em 0;" class="btn btn-default">
                    							</form>
                    							
                    						</ul>
                    					</li>
                    				</c:forEach>
                    			</ul>
                			</div>
                		</div>
                	</div>
                	<div class="panel panel-default">
                		<div class="panel-heading">
                			<h4 class="panel-title">
                				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#recentFeeling">最近心情</a>
                			</h4>
                		</div>
                		<div id="recentFeeling" class="panel-collapse collapse">
                			<div class="panel-body">
                				<ul>
                        			<c:forEach var="t" items="${feeling_list}">
                    					<li style="border-bottom: 1px solid #aaa;">
                    						<p>${t.getFeelContent() }</p>
                    						<span style="font-size:.8em">${t.getFeelCreateTime() }&nbsp;&nbsp;</span>
                    					</li>
                    				</c:forEach>
                    			</ul>
                			</div>
                		</div>
                	</div>
                	<div class="panel panel-default">
                		<div class="panel-heading">
                			<h4 class="panel-title">
                				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#recentMsg">最近留言</a>
                			</h4>
                		</div>
                		<div id="recentMsg" class="panel-collapse collapse">
                			<div class="panel-body">
                				<ul>
                        			<c:forEach var="t" items="${MsgBox_list}">
                    					<li>
                    						<p>
                    							<a href="../servlet/FriendZoneServlet?friendName=${t.getUser().getUsername()}" style="color:#337ab7;">
                    								<img style="width:2em; height:2em; border-radius:50%;" src="/AmzBlog/upload/${t.getUser().getUserSelfie()}">&nbsp;&nbsp;${t.getUser().getUserNickname() }
                    							</a>
                    						</p>
                  							<p>&nbsp;&nbsp;${t.msgContent }
                  							</p>
                  								<span style="font-size:.8em">&nbsp;&nbsp;${t.msgCreateTime }&nbsp;&nbsp;&nbsp;</span> 
                    					</li>
                    				</c:forEach>
                    			</ul>
                			</div>
                		</div>
                	</div>
                </div>
            </div>
        </div>
</div>


</body>
</html>