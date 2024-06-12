<%--
  Created by IntelliJ IDEA.
  User: utkirbek
  Date: 29/05/24
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            margin-bottom: 20px;
            color: #007bff;
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
<h1>Welcome to To Do application!</h1>
<a href="/logout">Logout</a>
<a href="/todo">ToDo</a>
</body>
</html>
