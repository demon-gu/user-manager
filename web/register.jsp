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

    <title>注册页面</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/login.css" rel="stylesheet">

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.js"></script>

</head>

<body>

<div class="container">

    <form class="form-signin" action="/registerServlet" method="post">
        <div class="text-center">
            <h2 class="form-signin-heading">注册</h2>
        </div>
        <!-- 出错显示的信息框 -->
        <div class="alert alert-warning alert-dismissible" style="display: <c:if test="${not empty errorMsg}">block</c:if><c:if test="${empty errorMsg}">none</c:if>" role="alert">
            <button type="button" class="close" data-dismiss="alert" >
                <span>&times;</span></button>
            <strong>${errorMsg}</strong>
        </div>
        <label for="inputText" class="sr-only">用户名</label>
        <input type="text" id="inputText" name="username" class="form-control" placeholder="用户名" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required autofocus>

        <label for="inputAffirmPassword" class="sr-only">确认密码</label>
        <input type="password" id="inputAffirmPassword" name="affirmPassword" class="form-control" placeholder="确认密码" required autofocus>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->
</body>
<style>
    #inputPassword{
        margin-bottom: 0px;
    }
</style>
</html>
