<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2019/5/8
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<button><a href="/index.jsp">退出</a></button>

<table align="center" border="2px" >
    <tr align="center">
        <td>车牌号</td>
        <td>${carID}</td>
    </tr>
    <tr align="center">
        <td>车主姓名</td>
        <td>${ownerName}</td>
    </tr>
    <tr align="center">
        <td>汽车型号</td>
        <td>${carType}</td>
    </tr>
    <tr align="center">
        <td>汽车颜色</td>
        <td>${carColor}</td>
    </tr>
    <tr align="center">
        <td>发动机编号</td>
        <td>${engineID}</td>
    </tr>
</table>

<form align="center" action="${pageContext.request.contextPath}/QRApp/displayOperation" method="post">
    <tr align="center">
        <td><input id="det" value="注销" type="submit" name="selectBtn"></td>
        <td><input id="update" value="修改密码" type="submit" name="selectBtn"></td>
        <td><input id="qrcode" value="生成二维码" type="submit" name="selectBtn"></td>

    </tr>
 </form>

</body>
</html>
