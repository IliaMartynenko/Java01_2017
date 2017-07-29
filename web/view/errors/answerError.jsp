<%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 20.07.2017
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<form action="../index.jsp">
    <button type="submit"><h3><%=session.getAttribute("answerError.back")%></h3></button>
</form>

<h2><%=session.getAttribute("answerError.message")%></h2>

<form action="../signin/validate.jsp">

    <button type="submit"><h3><%=session.getAttribute("answerError.registration")%></h3></button>
</form>

</body>
</html>
