<%@ page import="com.epam.likeit.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 20.07.2017
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information about user</title>
</head>
<body>
<% User user=(User)session.getAttribute("user_information");%>
<h1>Имя пользователя:</h1>
<%=user.getName()%>

<h1>Страна проживания пользователя:</h1>
<%=user.getCountry()%>
<h1>Mail пользователя:</h1>
<%=user.getMail()%>

<h1>Mail пользователя:</h1>
<%=user.getMail()%>

<h1>Количество заданных вопросов пользователя:</h1>
<%=user.getNumberOfQuestions()%>

<h1>Количество оценок:</h1>
<%=user.getNumberOfRatings()%>

<h1>Возраст пользователя:</h1>
<%=user.getAge()%>












</body>
</html>
