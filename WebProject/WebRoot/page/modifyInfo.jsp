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
    <title>修改个人信息</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"  href="../css/common.css">
    <style>
    	input{
    		margin-bottom:1em;
    	}
    </style>
    <%
	User user=(User)session.getAttribute("user");
 	%>
 	<%String sex=user.getUserSex(); %>
 	<script>
 	$(document).ready(function(){
 	 	var sex = "<%= sex%>";
 		if (sex == "男"){
 			$("#male").attr("checked","checked");
 		}else{
 			$("#female").attr("checked","checked");
 		}
 	
 	});
 	function loadImg(obj){
    	var file = obj.files[0];
    	var reader = new FileReader();
    	var imgFile;
    	reader.onload=function(e) {
        	imgFile = e.target.result;
        	$("#showImg").attr('src', imgFile);
    	};
    	reader.readAsDataURL(file);
	}
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
                <li><a href="../page/login.jsp">退出</a></li>
                <li><a href="../page/help.html" target="_blank">关于</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="zoneName">${zone.zoneName} 的空间</h1>
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
                    <li><a href="../page/setting.jsp"> 个人设置</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="row">
        <div>
            <h3>个人档</h3>
            <hr>
            <form role="form" action="../servlet/InfoServlet" method="post"  enctype="multipart/form-data" style="margin:0 0 2em 2em;">
                <table style="line-height:3em;">
                    <tr>
                        <td><label>头像：</label></td>
                        <td>
                        	<div class=""row>
                        		<div class="col-xs-5 col-ms-5">
                        			<input type="file" accept="image/*" name="file" value="/AmzBlog/upload/<%=user.getUserSelfie()%>" onchange="loadImg(this);">
                        		</div>
                        		<div class="col-xs-5 col-ms-5">
                        			<img src="" id="showImg" style="width:5em; height:5em;">
                        		</div>
                        	</div>
                        	
                        </td>
                    </tr>
                    <tr>
                        <td><label for="userName">昵称：</label></td>
                        <td><input type="text" id=userNickname name="userNickname" class="form-control" value="<%= user.getUserNickname()%>"></td>
                    </tr>
                    <tr>
                        <td><label>性别：</label></td>
                        <td>
                            <input type="radio" name="userSex" value="男" id="male">男
                            <input type="radio" name="userSex" value="女" id="female">女
                        </td>
                    </tr>
                    <tr>
                        <td><label for="birthday">生日</label></td>
                        <td><input type="date" id="userBirthdate" name="userBirthdate" class="form-control" value="${userBirthdate}"></td>
                    </tr>
                    <tr>
                        <td><label for="userEmailAddr">邮箱：</label></td>
                        <td><input type="text" id="userEmailAddr" name="userEmailAddr" class="form-control" value="<%=user.getUserEmailAddr()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="userBlogAddr">博客：</label></td>
                        <td><input type="text" id="userBlogAddr" name="userBlogAddr" class="form-control" value="<%=user.getUserBlogAddr()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="userWechat">微信：</label></td>
                        <td><input type="text" id="userWechat" name="userWechat" class="form-control" value="<%=user.getUserWechat()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="userQq">QQ：</label></td>
                        <td><input type="text" id="userQq" name="userQq" class="form-control" value="<%=user.getUserQq()%>"></td>
                    </tr>
                    <tr>
                        <td><label for="userPhone">手机：</label></td>
                        <td><input type="text" id="userPhone" name="userPhone" class="form-control" value="<%=user.getUserPhone()%>"></td>
                    </tr>
                </table>
                <input type="submit" value="保存" class="btn btn-default" style="margin-left:35%;padding:.4em 2em">
            </form>
        </div>
    </div>
</div>


</body>
</html>