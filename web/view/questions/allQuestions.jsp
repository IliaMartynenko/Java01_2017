<%@ page import="com.epam.likeit.dao.QuestionDAO" %>
<%@ page import="com.epam.likeit.dao.impl.SQLQuestionDAO" %>
<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.service.impl.QuestionServiceImpl" %>
<%@ page import="com.epam.likeit.service.QuestionService" %>

Created by IntelliJ IDEA.
  User: mts7072572
  Date: 20.06.2017
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All themes</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<%
    List<Question> questionList=(List)application.getAttribute("all_questions");
%>

    <form action="../index.jsp">
        <button type="submit"><h3>Вернуться на начальную страницу</h3></button>
    </form>
<table class="tftable">
    <%for(int i=0;i<questionList.size();i++){
        Question question=questionList.get(i);
    %>




    <tr><th>Автор</th>
        <th>Вопрос</th>
        <th>Дата добавления</th>
        <th>Количество ответов</th></tr>

    <tr>
        <td><a href=""><h4>Илья</h4></a></td>
        <td><a href=""><h4><%=question.getText()%></h4></a></td>
        <td><%=question.getDateOfCreate()%></td>
        <td><a href=""><h4><%=question.getSumOfanswers()%></h4></a></td>

    </tr>





    <%}%>
</table>


</body>
</html>
