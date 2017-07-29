<%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 20.06.2017
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h2><%=session.getAttribute("registration.sucess")%></h2>

<button type="button"><a href="../index.jsp"><%=session.getAttribute("errorBan.back")%></a></button>



</body>
</html>
