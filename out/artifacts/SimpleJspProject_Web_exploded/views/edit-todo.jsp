<%@ page import="uz.isystem.model.ToDo" %><%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 12/06/24
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit-todo</title>
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
            text-align: center;
        }

        h1 {
            color: #007bff;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }

        button[type="submit"] {
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

        button[type="submit"]:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<%
    ToDo todo = (ToDo) request.getAttribute("todo");
    boolean isEdit = todo != null;
%>
<h1><%= isEdit ? "Edit Todo" : "Add Todo" %></h1>

<form action="/edit-todo" method="post">
    <input type="hidden" name="id" value="<%= isEdit ? todo.getId() : "" %>">
    <label for="message">Message:</label>
    <input type="text" id="message" name="message" value="<%= isEdit ? todo.getMessage() : "" %>" required>
    <br>
    <label for="isDone">Is Done:</label>
    <select name="isDone" id="isDone" required>
        <option value="" disabled <%= !isEdit ? "selected" : "" %>>Select</option>
        <option value="done" <%= isEdit && "done".equals(todo.getIsDone()) ? "selected" : "" %>>Done</option>
        <option value="no" <%= isEdit && "no".equals(todo.getIsDone()) ? "selected" : "" %>>No</option>
        <option value="no-yet" <%= isEdit && "no-yet".equals(todo.getIsDone()) ? "selected" : "" %>>No Yet</option>
    </select>
    <br>
    <button type="submit"><%= isEdit ? "Update" : "Add" %></button>
</form>

</body>
</html>
