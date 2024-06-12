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
        table, tr, th, td {
            border: 1px solid black;
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
    <tr><th>Message:</th><th>Is Done:</th><th></th><th></th></tr>
    <% for (ToDo t : todo) { %>
    <tr>
        <td><%= t.getMessage() %></td>
        <td><%= t.getIsDone() %></td>
        <td><a href="<%= "/del-todo?id=" + t.getId() %>">Delete</a></td>
        <td><a href="<%= "/edit-todo?id=" + t.getId() %>">Update</a></td>
    </tr>
    <% } %>
</table>

<a href="/todo">ToDo</a>

</body>
</html>
