<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 25/11/2021
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="table.jsp" method="post">
        <input type="number" name="rows" id="rows" min="0" max="16">
        <label>rows</label>
        <input type="number" name="columns" id="columns" min="0" max="16">
        <label>columns</label>
        <button type="submit">Create Table</button>
    </form>
</head>
<body>

</body>
</html>
