
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=session.getAttribute("createQuestion.create1")%></title>
</head>
<body>

<form action="/controller" method="post" >

    <h3 class="actual"><%=session.getAttribute("createQuestion.create")%></h3>

    <textarea name="question" rows="8" cols="70"><%=session.getAttribute("user_id")%></textarea>
<input type="hidden" name="id" value="2">
    <h3><%=session.getAttribute("createQuestion.choose")%></h3>
    <select name="topic">
        <option><%=session.getAttribute("createQuestion.politic")%></option>
        <option><%=session.getAttribute("createQuestion.sport")%></option>
        <option><%=session.getAttribute("createQuestion.study")%></option>
        <option><%=session.getAttribute("createQuestion.books")%></option>
        <option><%=session.getAttribute("createQuestion.travelling")%></option>
        <option><%=session.getAttribute("createQuestion.computers")%></option>
        <option><%=session.getAttribute("createQuestion.cinema")%></option>
        <option><%=session.getAttribute("createQuestion.music")%></option>

    </select>
<input type="hidden" value="add_question" name="command">
    <input type="hidden" name="id_user" value="<%=session.getAttribute("user_id")%>">
<input type="submit" value="<%=session.getAttribute("createQuestion.send")%>">
</form>

</body>
</html>
