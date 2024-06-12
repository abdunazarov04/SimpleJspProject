<%@ page import="uz.isystem.model.ToDo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 12/06/24
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDo</title>

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

        form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        form label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        form input[type="text"],
        form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        form button {
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        form button:hover {
            background: #0056b3;
        }

        a {
            display: block;
            margin-top: 20px;
            text-align: center;
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #0056b3;
        }
    </style>



</head>
<body>
<form action="/todos" method="post">
    <label for="message">Message:</label>
    <input type="text" name="message" id="message" placeholder="message" required>
    <br>
    <label for="isDone">Is Done:</label>
    <select name="isDone" id="isDone" required>
        <option value="" disabled selected>Select</option>
        <option value="done">Done</option>
        <option value="no">No</option>
        <option value="no-yet">No Yet</option>
    </select>
    <button type="submit">OK</button>
</form>
<a href="/">Back</a>
</body>
</html>
