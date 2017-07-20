<%@ page import="com.epam.likeit.bean.User" %>
<%@ page import="java.util.List" %>

<%@ page import="com.epam.likeit.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 05.07.2017
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<form action="admin.jsp">
    <button type="submit"><h3>Вернуться на главную страницу Администратора</h3></button>
</form>

<form action="/c" method="post">
    <h4>Забанить пользователя по имени</h4>
    <input name="name" value="Введите имя..." type="text">
    <br>
    <br>
    <textarea rows="5" cols="35"  name="reason_of_ban">Причина бана...</textarea>
    <br>
    <h5>Количество дней блокировки:</h5>
    <input name="duration" type="number" min="1" max="365">

    <button type="submit">Удалить</button>
</form>

<hr>
<hr>
<hr>


<h2>Таблица всех пользователей форума</h2>




<%

    List<User> allUsers=(List)session.getAttribute("users");%>
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
        <th>Рейтинг</th>
        <th>Забанить пользователя</th>

        <th>Удалить пользователя</th>

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
        <td><form action="/controller" method="post"><input type="text" name="duration" value="Количество дней бана" >
            <textarea name="reason_of_ban" rows="7" cols="20">Введите причину бана</textarea>
            <input type="hidden" name="id_user" value="<%=us.getId()%>">
            <input type="hidden" name="command" value="ban_user">
            <input type="submit">
        </form>

        </td>

        <td>
            <form action="/controller" method="post"><input type="hidden" name="id" value="<%=us.getId()%>" >
                <input type="hidden" name="command" value="delete_user">
                <input type="submit">
        </form>

        </td>



    </tr>






    <%}%>
</table>

</body>
</html>
