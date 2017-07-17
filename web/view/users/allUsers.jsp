<%@ page import="service.UserService" %>
<%@ page import="com.epam.likeit.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 04.07.2017
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список всех пользователей</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<h2>Таблица всех пользователей форума</h2>
<%UserService userService=new UserService();
List<User> allUsers=userService.getAll();%>
    <table class="tftable">
<%for(User us:allUsers){

%>




<tr><th>ID пользователя</th>
    <th>Логин</th>
    <th>Пароль</th>
    <th>Имя</th>
    <th>Почтовый ящик</th>
    <th>Возраст</th>
    <th>Страна</th>
    <th>Количество вопросов</th>
    <th>Количество оценок</th>
    <th>Сумма оценок</th>
    <th>Рейтинг</th>
    <th>Удаление пользователя</th>
    <th>Забанить пользователя</th>
</tr>

<tr>
    <td><a href=""><%=us.getId()%></a></td>
    <td><a href=""><%=us.getLogin()%></a></td>
    <td><%=us.getPassword()%></td>
    <td><%=us.getName()%></td>
    <td><%=us.getMail()%></td>
    <td><%=us.getAge()%></td>
    <td><%=us.getCountry()%></td>
    <td><%=us.getNumberOfQuestions()%></td>
    <td><%=us.getNumberOfRatings()%></td>
    <td><%=us.getSumOfRatings()%></td>
    <td><%=us.getRating()%></td>
    <td> <form  action="/deleteUserName" method="post"><input type="submit" value="Удалить пользователя" ></form></td>
    <td> <form action="/banByName" method="post"><input type="submit" value="Забанить пользователя  ">
    <input type="number" name="duration" min="1" max="365">Количество дней</form>
    </td>

</tr>






<%}%>
</table>
</body>
</html>
