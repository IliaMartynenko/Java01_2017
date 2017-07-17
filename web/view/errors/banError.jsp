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
<%SQLBannedUserDAO sqlBannedUserDAO=new SQLBannedUserDAO();
    BannedUser bannedUser=sqlBannedUserDAO.readByUserId(((Integer)session.getAttribute("id")).intValue());
%>
<h3>По причине бана вы не можете оставлять сообщения под темами форума!</h3>
<h4>Дата бана:
</h4>
<h5><%=bannedUser.getDateOfBan()%></h5>
<h4>Причина бана:
</h4>
<h5><%=bannedUser.getReasonOfBan()%></h5>
<h4>Длительность бана(количество дней):
</h4>
<h5><%=bannedUser.getBanDuration()%></h5>



</body>
</html>
