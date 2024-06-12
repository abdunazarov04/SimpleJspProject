<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 12/06/24
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s ease, color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
            color: #fff;
        }
    </style>
</head>
<body>
<a href="/login">Login</a>
<a href="/register">Register</a>
</body>
</html>
