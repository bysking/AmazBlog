<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>find password</title>

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
    <h1>找回密码</h1>
    <form action="../servlet/FindPasswordServlet" method="post">
        <table>
            <tr>
                <td class="right-label"><label for="userName">Name: &nbsp;</label></td>
                <td><input type="text" id="userName" name="userName" placeholder="输入用户名"></td>
            </tr>
            <tr>
                <td class="right-label"><label for="userEmailAddr">Email: &nbsp;</label></td>
                <td><input type="text" id="userEmailAddr" name="userEmailAddr" placeholder="输入用户邮箱验证"></td>
            </tr>
            <tr>
                <td class="right-label"><label for="userPassword">新密码: &nbsp;</label></td>
                <td><input type="password" id="userPassword" name="userPassword" placeholder="输入新的密码"></td>
            </tr>
            <tr>
                <td class="right-label"><label for="confirmPassword">确认密码: &nbsp;</label></td>
                <td><input type="password" id="confirmPassword" name="confirmPassword" placeholder="确认密码"></td>
            </tr>
        </table>
        <br>
        <input type="submit" id="submit" value="注册">
        <input type="reset" value="重置">
    </form>
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
