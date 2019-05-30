<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/5/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div align="center">
<form method="post" action="${pageContext.request.contextPath}/QRApp/updatePassOperation">
    <table>
        <tr>
            <td>原密码</td>
            <td><input type="password" name="oldPass"/></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" name="newPass"></td>
        </tr>
        <tr>
            <td>确认新密码</td>
            <td><input type="password" name="reNewPass"></td>
        </tr>
        <tr align="right">
            <td></td>
            <td>
                <input type="submit" value="修改"/>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
