<%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 27.05.2017
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<button type="button"><a href="../index.jsp"><h3><%=session.getAttribute("errorBan.back")%></h3></a></button>
<%=session.getAttribute("helloUser.message")%>
</body>

</html>
