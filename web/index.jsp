<%--
  author: Demon
  date: 2018/9/6 11:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登陆页面</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.js"></script>

</head>

<body>

<div class="container">

    <form class="form-signin" action="/loginServlet" method="post">
        <div class="text-center">
            <h2 class="form-signin-heading">登陆</h2>
        </div>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" style="display: <c:if test="${not empty errorMsg}">block</c:if><c:if test="${empty errorMsg}">none</c:if>" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>&times;</span></button>
            <strong>${errorMsg}</strong>
        </div>
        <label for="inputText" class="sr-only">用户名</label>
        <input type="text" id="inputText" value="${cookie.username.value}" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" value="${cookie.password.value}" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember" checked value="rememberMe"> 记住用户名和密码
            </label>
        </div>
        <button class="btn btn-lg btn-info btn-block" type="submit">登陆</button>
        <button class="btn btn-lg btn-primary btn-block" id="register" onclick="registerAdmin()" type="button">注册</button>
    </form>

</div> <!-- /container -->
</body>
<script>
    function registerAdmin() {
        location.href = "/register.jsp";
    }
</script>
</html>
