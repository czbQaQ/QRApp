<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/5/5
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div align="center">
    <h1>车辆管理系统</h1>
    <img src="${pageContext.request.contextPath}/static/images/welcome.jpg" width="400" height="277"><br/>
    <button><a href="${pageContext.request.contextPath}/QRApp/login">登录</a></button>
    <button><a href="${pageContext.request.contextPath}/QRApp/register">注册</a></button>
</div>
</body>
</html>
