<%@ page import="com.epam.likeit.bean.User" %>
<%@ page import="java.util.List" %>

  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 27.05.2017
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<h3>Добрый день,Администратор!</h3>
<form action="operationsWithQuestions.jsp">

    <input type="submit" value="Операции с темами форума">
</form>

<hr>

<form action="/controller" method="post">
<input type="hidden" name="command" value="get_all_reviews">
    <input type="submit" value="Операции с отзывами форума">
</form>

<hr>
<form action="operationsWithUser.jsp">

    <input type="submit" value="Операции с пользователями форума">
</form>




















</body>
</html>
