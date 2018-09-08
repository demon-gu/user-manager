<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr>
            <td colspan="8" style="text-align: right"><a class="btn btn-primary" href="/addUserCheckoutServlet?pageNum=${totalPageCount}&pageSize=${pageSize}">添加联系人</a></td>
        </tr>
        <tr class="success">
            <th class="col-md-1">编号</th>
            <th class="col-md-1">姓名</th>
            <th class="col-md-1">性别</th>
            <th class="col-md-1">年龄</th>
            <th class="col-md-1">籍贯</th>
            <th class="col-md-2">QQ</th>
            <th class="col-md-2">邮箱</th>
            <th class="col-md-2">操作</th>
        </tr>

        <c:forEach items="${pageUsers}" var="user" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="/queryUserByIdServlet?id=${user.id}&pageNum=${pageNum}&pageSize=${pageSize}">修改</a>
                    &nbsp;
                    <a class="btn btn-default btn-sm" onclick="deleteUserById(${user.id})" href="javascript:void(0)">删除</a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                <form class="form-inline">
                    <c:if test="${pageNum > 1}">
                        <a href="/pageQueryServlet?pageNum=${pageNum - 1}&pageSize=${pageSize}" style="margin-right: 10px;color: #31b0d5">
                            <span class="glyphicon glyphicon-menu-left"></span>
                        </a>
                    </c:if>
                    <c:forEach begin="1" end="${totalPageCount}" var="currentPageNum">
                        <c:if test="${currentPageNum != pageNum}">
                            <a href="/pageQueryServlet?pageNum=${currentPageNum}&pageSize=${pageSize}" class="btn btn-default">${currentPageNum}</a>
                        </c:if>
                        <c:if test="${currentPageNum == pageNum}">
                            <a href="/pageQueryServlet?pageNum=${currentPageNum}&pageSize=${pageSize}" class="btn btn-info">${currentPageNum}</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageNum < totalPageCount}">
                        <a href="/pageQueryServlet?pageNum=${pageNum + 1}&pageSize=${pageSize}" style="margin-left: 10px;color: #31b0d5">
                            <span class="glyphicon glyphicon-menu-right" style="text-align: center"></span>
                        </a>
                    </c:if>

                    <span style="text-align: center;margin-left: 10px">
                        共${totalItemCount}条
                    </span>

                    <select name="pageSize" id="pageSizeSelect" class="form-control" style="margin-left: 10px">
                        <option value="5">5 条/页</option>
                        <option value="10">10 条/页</option>
                        <option value="15">15 条/页</option>
                    </select>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
<script>
    function deleteUserById(id) {
        var confirmFlag = confirm("确认删除吗？");
        if(confirmFlag) {
            location.href = "/deleteUserByIdServlet?id=" + id + "&pageNum=" + ${pageNum} + "&pageSize=" + ${pageSize};
        }
    }

    $("#pageSizeSelect").change(function () {
        var pageSize = this.value;
        location.href = "/pageQueryServlet?pageNum=1&pageSize="+pageSize;
    });

    $(function () {
        $("#pageSizeSelect").val(${pageSize});
    });
</script>

</html>
