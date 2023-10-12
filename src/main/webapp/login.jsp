<%--
  Created by IntelliJ IDEA.
  User: potat
  Date: 2023-02-07
  Time: 11:42 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Login</title>
</head>
<body>
<%if (request.getAttribute("error") != null){%>
<div class="w3-panel w3-red">
    <p><%=request.getAttribute("error")%></p>
</div>
<%}%>
<div style="text-align: center">
    <h1>Login</h1>
    <form action="<%= request.getContextPath()%>/login" method="post">
        <table style="width: 80%">
            <tr>
                <td>UserName: </td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
<a href="signup.jsp">Click To Signup</a>
</body>
</html>
