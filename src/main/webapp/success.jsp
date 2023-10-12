<%@ page import="bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: potat
  Date: 2023-02-07
  Time: 11:42 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div style="text-align: center">
    Greetings <%=request.getAttribute("Name")%> thank you for signing in!
</div>
</body>
</html>
