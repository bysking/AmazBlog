/**
 * Created by asus on 2018/6/28.
 */
window.onload = function () {
    var submit = document.getElementById("submit");
    var userName = document.getElementById("userName");
    var userPassword = document.getElementById("userPassword");
    submit.onclick = function () {
        if (userName.value == ''|| userPassword.value == '') {
            document.getElementById("message").innerHTML = "用户名和密码不能为空"
            if (userName.value == '') {
                userName.focus();
            }else if (userPassword.value == '') {
                userPassword.focus();
            }
            return false;
        } else if (userName.value.length > 8 || userName.value.length < 2) {
            document.getElementById("message").innerHTML = "用户名长度为2-8";
            return false;
        } else if (userPassword.value.length > 16 || userPassword.value.length < 8) {
            document.getElementById("message").innerHTML = "密码长度为8-16";
            return false;
        }


        var loginType = document.getElementsByName("loginType");
        var form = document.getElementById("loginForm");
        if (loginType[0].checked) {
            form.action = "../servlet/LoginServlet";
        } else {
            form.action = "../servlet/AdminServlet";
        }
    }
    userName.onblur = function () {
        if (userName.value.length > 8 || userName.value.length < 2) {
            document.getElementById("message").innerHTML = "用户名长度为2-8";
            return false;
        } else {
            document.getElementById("message").innerHTML = "";
        }
    }
    userPassword.onblur = function () {
        if (userPassword.value.length > 16 || userPassword.value.length < 8) {
            document.getElementById("message").innerHTML = "密码长度为8-16";
            return false;
        } else {
            document.getElementById("message").innerHTML = "";

        }
    }

}