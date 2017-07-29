

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<h3><%=session.getAttribute("admin.hello")%></h3>
<form action="/controller" method="post">
    <input type="hidden" name="command" value="get_all_questions">
    <input type="submit" value="<%=session.getAttribute("admin.themes")%>">
</form>

<hr>

<form action="/controller" method="post">
<input type="hidden" name="command" value="get_all_reviews">
    <input type="submit" value="<%=session.getAttribute("admin.reviews")%>">
</form>

<hr>
<form action="/controller" method="post">
    <input type="hidden" name="command" value="get_all_users">
    <input type="submit" value="<%=session.getAttribute("admin.users")%>">
</form>




















</body>
</html>
