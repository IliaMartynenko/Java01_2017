<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>

<%@ page import="com.epam.likeit.service.QuestionService" %>
<%@ page import="com.epam.likeit.service.impl.QuestionServiceImpl" %>
<%@ page import="com.epam.likeit.service.impl.UserServiceImpl" %>
<%@ page import="com.epam.likeit.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operations with questions</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<form action="/controller">
    <button type="submit"><h3>Вернуться на начальную страницу</h3></button>
</form>



<h2>Операции с темами форума</h2>
<form action="/controller" method="post">
    <h4>Удаление темы по его ID</h4>
    <input name="id_question" type="text">
    <input type="hidden" name="command" value="delete_question">
    <button type="submit">Удалить</button>
</form>
<hr>
<hr>
<hr>
<form action="/allowedQuestion" method="post">
    <h4>Одобрить вопрос</h4>
    <input name="id_question" type="text">
    <button type="submit">Одобрить</button>
</form>

<%
    List<Question> allowedquestionList=(List)session.getAttribute("allowed_questions");
    List<Question> notAllowedList=(List)session.getAttribute("not_allowed_questions");
    application.setAttribute("allowed_questions",allowedquestionList);

%>
<form action="admin.jsp">
    <button type="submit"><h3>Вернуться на главную страницу Администратора</h3></button>
</form>


<h3>Неодобренные вопросы</h3>


<table class="tftable">
    <%for(int i=0;i<notAllowedList.size();i++){
        Question questions=notAllowedList.get(i);
    %>




    <tr><th>ID вопроса</th>
        <th>Текст вопроса</th>
        <th>Дата добавления</th>

        <th>Количество ответов</th>
        <th>Одобрен администратором</th>
        <th>Одобрить вопрос</th>
        <th>Удалить вопрос</th>
    </tr>

    <tr>
        <td><a href=""><h4><%=questions.getIdQuestion()%></h4></a></td>

        <td><a href=""><h4><%=questions.getText()%></h4></a></td>
        <td><%=questions.getDateOfCreate()%></td>

        <td><a href=""><h4><%=questions.getSumOfanswers()%></h4></a></td>
        <td><a href=""><h4><%=questions.getAllowed()%></h4></a></td>
        <td> <form action="/controller" method="POST">
            <input type="hidden" name="id_question" value="<%=questions.getIdQuestion()%>">
            <input type="hidden" name="command" value="allow_question">
            <input type="submit" value="Одобрить вопрос"></form></td>

       <td> <form action="/controller" method="POST">
           <input type="hidden" name="id_question" value="<%=questions.getIdQuestion()%>">
           <input type="hidden" name="command" value="delete_question">
           <input type="submit" value="Удалить вопрос"></form></td>


    </tr>





    <%}%>
</table>





<h3>Одобренные вопросы</h3>


<table class="tftable">
    <%for(int i=0;i<allowedquestionList.size();i++){
        Question question=allowedquestionList.get(i);
    %>




    <tr><th>ID вопроса</th>

        <th>Текст вопроса</th>
        <th>Дата добавления</th>

        <th>Количество ответов</th>
        <th>Одобрен администратором</th>
        <th>Удалить вопрос</th>

    </tr>

    <tr>
        <td><a href=""><h4><%=question.getIdQuestion()%></h4></a></td>

        <td><a href=""><h4><%=question.getText()%></h4></a></td>
        <td><%=question.getDateOfCreate()%></td>

        <td><a href=""><h4><%=question.getSumOfanswers()%></h4></a></td>
        <td><a href=""><h4><%=question.getAllowed()%></h4></a></td>
        <td> <form action="/controller" method="POST">
            <input type="hidden" name="id_question" value="<%=question.getIdQuestion()%>">
            <input type="hidden" name="command" value="delete_question">
            <input type="submit" value="Удалить вопрос"></form></td>


    </tr>





    <%}%>
</table>






</body>
</html>
