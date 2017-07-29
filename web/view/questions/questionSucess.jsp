<%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 03.07.2017
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<form action="../index.jsp">
    <button type="submit"><h3><%=session.getAttribute("answerError.back")%></h3></button>
</form>

<h2><%=session.getAttribute("questionSucess.message")%></h2>

</body>
</html>
