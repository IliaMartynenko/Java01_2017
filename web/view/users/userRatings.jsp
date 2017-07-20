<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 19.07.2017
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Рейтинг пользователей</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%  List<User> userList=(List)session.getAttribute("users");
%>

<ol class="rounded">
    <%for(User user:userList){%>
    <li><h1><%=user.getName()%></h1>
        <h3>Количество плюсов:</h3> <h2><u><%=user.getNumberOfRatings()%></u></h2>
        <h3>Страна проживания:</h3>   <h2><u><%=user.getCountry()%></u></h2>
    </li>
    <%}%>


</ol>

</body>
</html>
