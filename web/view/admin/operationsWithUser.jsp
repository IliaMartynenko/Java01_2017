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
    <button type="submit"><h3><%=session.getAttribute("operationsWithUsers.back1")%></h3></button>
</form>



<hr>
<hr>
<hr>


<h2><%=session.getAttribute("operationsWithUsers.table")%></h2>




<%

    List<User> allUsers=(List)session.getAttribute("users");%>
<table class="tftable">
    <%for(User us:allUsers){

    %>




    <tr><th><%=session.getAttribute("operationsWithUsers.id")%></th>
        <th><%=session.getAttribute("operationsWithUsers.login")%></th>

        <th><%=session.getAttribute("operationsWithUsers.name")%></th>
        <th><%=session.getAttribute("operationsWithUsers.mail")%></th>
        <th><%=session.getAttribute("operationsWithUsers.age")%></th>
        <th><%=session.getAttribute("operationsWithUsers.country")%></th>
        <th><%=session.getAttribute("operationsWithUsers.numberOfThemes")%></th>
        <th><%=session.getAttribute("operationsWithUsers.rating")%></th>
        <th><%=session.getAttribute("operationsWithUsers.ban")%></th>

        <th><%=session.getAttribute("operationsWithUsers.delete")%></th>

    </tr>

    <tr>
        <td><a href=""><%=us.getId()%></a></td>
        <td><a href=""><%=us.getLogin()%></a></td>

        <td><%=us.getName()%></td>
        <td><%=us.getMail()%></td>
        <td><%=us.getAge()%></td>
        <td><%=us.getCountry()%></td>
        <td><%=us.getNumberOfQuestions()%></td>
        <td><%=us.getNumberOfRatings()%></td>
        <td><form action="/controller" method="post"><input type="text" name="duration" value="<%=session.getAttribute("operationsWithUsers.numberOfDays")%>" >
            <textarea name="reason_of_ban" rows="7" cols="20"><%=session.getAttribute("operationsWithUsers.reasonOfBan")%></textarea>
            <input type="hidden" name="id_user" value="<%=us.getId()%>">
            <input type="hidden" name="command" value="ban_user">
            <input type="submit" value="<%=session.getAttribute("operationsWithUsers.ban")%>">
        </form>

        </td>

        <td>
            <form action="/controller" method="post"><input type="hidden" name="id" value="<%=us.getId()%>" >
                <input type="hidden" name="command" value="delete_user">
                <input type="submit" value="<%=session.getAttribute("operationsWithUsers.delete")%>">
        </form>

        </td>



    </tr>






    <%}%>
</table>

</body>
</html>
