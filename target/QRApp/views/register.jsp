<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/5/5
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/QRApp/registerOperation">
        <table>
            <tr>
                <td>车牌号</td>
                <td><input type="text" name="carID"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="pass"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="rePass"></td>
            </tr>
            <tr>
                <td>车主姓名</td>
                <td><input type="text" name="ownerName"></td>
            </tr>
            <tr>
                <td>车辆类型</td>
                <td><input type="text" name="carType"></td>
            </tr>
            <tr>
                <td>颜色</td>
                <td><input type="text" name="carColor"></td>
            </tr>
            <tr>
                <td>发动机编号</td>
                <td><input type="text" name="engineID"></td>
            </tr>
            <tr align="right">
                <td></td>
                <td><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
