<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 12/06/24
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resister</title>
</head>
<body>

<form action="/register" method="post">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" placeholder="name" required>
    <br>

    <label for="username">Username:</label>
    <input type="text" name="username" id="username" placeholder="username" required>
    <br>

    <label for="password">Password:</label>
    <input type="password" name="password" id="password" placeholder="password" required>
    <br>

    <label for="gender">Gender:</label>
    <select name="gender" id="gender" required>
        <option value="" disabled selected>Select your gender</option>
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
    </select>
    <br>
    <br>
    <a href="/logout">Logout</a>


    <button type="submit">OK</button>
</form>


</body>
</html>
