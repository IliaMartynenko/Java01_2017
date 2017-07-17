<%@ page import="service.UsefullLinksService" %>
<%@ page import="bean.UsefulLink" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jws.soap.SOAPBinding" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 05.07.2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    UsefullLinksService usefullLinksService=new UsefullLinksService();
    List<UsefulLink> usefulLinks=usefullLinksService.getAllLinks();
    for(UsefulLink use:usefulLinks){
   %>
<h3><%=use.getText()%></h3>

<%}%>
</html>
