<%--
  Created by IntelliJ IDEA.
  User: utkirbek
  Date: 29/05/24
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="/login" method="post">
    <label for="login">Login:</label>
    <input type="text" name="login1" id="login" placeholder="admin">
    <br>
    <label for="pass">Password:</label>
    <input type="password" name="pass1" id="pass">
    <br>
    <button type="submit">OK</button>

    <a href="/logout">Logout</a>


</form>
</body>
</html>
