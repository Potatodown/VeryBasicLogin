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
    <title>Employee Signup</title>
</head>
<body>
<div style="text-align: center">
    <h1>Sign up</h1>
    <form action="<%= request.getContextPath()%>/signup" method="post">
        <table style="width: 80%">
            <tr>
                <td>UserName: </td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>Email Address: </td>
                <td><input type="text" name="emailAddress"></td>
            </tr>
            <tr>
                <td>Hire Date: </td>
                <td><input type="date" name="hireDate"></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
