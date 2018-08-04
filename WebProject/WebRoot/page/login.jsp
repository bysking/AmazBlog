<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>login</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../css/login-register.css">
	<script src="../js/login.js"></script>
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
    <div class="container">
        <h1>登 录</h1>
    	<form method="post" id="loginForm">
    		<table>
                <tr>
                    <td colspan="2">
                        <input type="radio" name="loginType" value="userLogin" checked>用户登录
                        <input type="radio" name="loginType" value="managerLogin">管理员登录
                    </td>
                </tr>
    			<tr>
    				<td class="right-label"><label for="userName">用户名: &nbsp;</label></td>
    				<td><input type="text" id="userName" name="userName" placeholder="请输入用户名"></td>
    			</tr>
    			<tr>
    				<td class="right-label"><label for="userPassword">密码: &nbsp;</label></td>
    				<td><input type="password" id="userPassword" name="userPassword" placeholder="请输入密码"></td>
    			</tr>
    		</table>
            <p id="message" style="color: orangered"> </p>
            <input type="submit" id="submit" value="登录">
            <input type="reset" value="重置">
    	</form>
        <a href="register.jsp">还没有账号？ 去注册</a>
        <br>
        <a href="findPassword.jsp">忘记密码？ 去找回</a>
    </div>
    <div class="logo">
        <table>
            <tr style="line-height: .5em">
                <td><img src="../img/logo.png" width="80em"></td>
                <td><h1>Amazing Blog</h1></td>
            </tr>
            <tr>
                <td colspan="2"><p>记录点滴&nbsp;分享生活</p></td>
            </tr>
        </table>
    </div>
  </body>
</html>
