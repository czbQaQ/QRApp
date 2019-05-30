<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/5/5
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
<form method="post" action="${pageContext.request.contextPath}/QRApp/loginOperation">
    <table>
        <tr>
            <td>车牌号</td>
            <td><input type="text" name="carID"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr align="right">
            <td></td>
            <td>
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
