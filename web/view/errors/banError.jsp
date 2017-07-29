<%@ page import="com.epam.likeit.dao.BannedUserDAO" %>
<%@ page import="com.epam.likeit.dao.impl.SQLBannedUserDAO" %>
<%@ page import="com.epam.likeit.bean.BannedUser" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 12.07.2017
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бан</title>
</head>
<body>
<%BannedUser user=(BannedUser)session.getAttribute("banned_user");
%>
<h2>По причине бана вы не можете оставлять сообщения под темами форума!</h2>
<h3>Дата бана:
</h3>
<h3><u><%=user.getDateOfBan()%></u></h3>
<h3>Причина бана:
</h3>
<h3><u><%=user.getReasonOfBan()%></u></h3>
<h3>Длительность бана(количество дней):
</h3>
<h3><u><%=user.getBanDuration()%></u></h3>



</body>
</html>
