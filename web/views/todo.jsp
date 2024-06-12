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
</head>
<body>


<form action="/todo" method="post">
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
