<%@ page import="uz.isystem.model.ToDo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 12/06/24
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #0056b3;
        }

        .add-btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px 0;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            text-align: center;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.3s ease;
        }

        .add-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    List<ToDo> todo = (List<ToDo>) request.getAttribute("todo");
    if (todo == null) {
        todo = new ArrayList<>();
    }
%>
<table>
    <tr>
        <th>Message</th>
        <th>Is Done</th>
        <th></th>
        <th></th>
    </tr>
    <% for (ToDo t : todo) { %>
    <tr>
        <td><%= t.getMessage() %></td>
        <td><%= t.getIsDone() %></td>
        <td><a href="<%= "/del-todo?id=" + t.getId() %>">Delete</a></td>
        <td><a href="<%= "/edit-todo?id=" + t.getId() %>">Update</a></td>
    </tr>
    <% } %>
</table>

<a class="add-btn" href="/todos">Add</a>

</body>
</html>
