<%@ page import="com.epam.likeit.bean.User" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<h3>Добрый день,Администратор!</h3>
<form action="/controller" method="post">
    <input type="hidden" name="command" value="get_all_questions">
    <input type="submit" value="Операции с темами форума">
</form>

<hr>

<form action="/controller" method="post">
<input type="hidden" name="command" value="get_all_reviews">
    <input type="submit" value="Операции с отзывами форума">
</form>

<hr>
<form action="/controller" method="post">
    <input type="hidden" name="command" value="get_all_users">
    <input type="submit" value="Операции с пользователями форума">
</form>




















</body>
</html>
