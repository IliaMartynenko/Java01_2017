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
<h1><%=session.getAttribute("userPage.name")%>:</h1>
<h2><u><%=user.getName()%></u></h2>
<hr>
<h1><%=session.getAttribute("userPage.country")%>:</h1>
<h2><u><%=user.getCountry()%></u></h2>
<hr>
<h1><%=session.getAttribute("userPage.mail")%>:</h1>
<h2><u><%=user.getMail()%></u></h2>
<hr>



<h1><%=session.getAttribute("userPage.sumOfQuestions")%>:</h1>
<h2><u><%=user.getNumberOfQuestions()%></u></h2>
<hr>

<h1><%=session.getAttribute("userPage.rating")%>:</h1>
<h2><u><%=user.getNumberOfRatings()%></u></h2>

<hr>
<h1><%=session.getAttribute("userPage.age")%>:</h1>
<h2><u><%=user.getAge()%></u></h2>
<hr>












</body>
</html>
