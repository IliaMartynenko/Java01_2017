<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operations with questions</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>

<form action="/controller">
    <button type="submit"><h3><%=session.getAttribute("operationWithQuestions.back")%></h3></button>
</form>


<%
    List<Question> allowedquestionList=(List)session.getAttribute("allowed_questions");
    List<Question> notAllowedList=(List)session.getAttribute("not_allowed_questions");
    application.setAttribute("allowed_questions",allowedquestionList);

%>
<form action="admin.jsp">
    <button type="submit"><h3><%=session.getAttribute("operationWithQuestions.back1")%></h3></button>
</form>


<h3><%=session.getAttribute("operationWithQuestions.notAllowed")%></h3>


<table class="tftable">
    <%for(int i=0;i<notAllowedList.size();i++){
        Question questions=notAllowedList.get(i);
    %>




    <tr><th><%=session.getAttribute("operationWithQuestions.id")%></th>
        <th><%=session.getAttribute("operationWithQuestions.text")%></th>
        <th><%=session.getAttribute("operationWithQuestions.date")%></th>

        <th><%=session.getAttribute("operationWithQuestions.numberOf")%></th>
        <th><%=session.getAttribute("operationWithQuestions.allowed")%></th>
        <th><%=session.getAttribute("operationWithQuestions.allow")%></th>
        <th><%=session.getAttribute("operationWithQuestions.delete")%></th>
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
            <input type="submit" value="<%=session.getAttribute("operationWithQuestions.allow")%>"></form></td>

       <td> <form action="/controller" method="POST">
           <input type="hidden" name="id_question" value="<%=questions.getIdQuestion()%>">
           <input type="hidden" name="command" value="delete_question">
           <input type="submit" value="<%=session.getAttribute("operationWithQuestions.delete")%>"></form></td>


    </tr>





    <%}%>
</table>





<h3><%=session.getAttribute("operationWithQuestions.allowed")%></h3>


<table class="tftable">
    <%for(int i=0;i<allowedquestionList.size();i++){
        Question question=allowedquestionList.get(i);
    %>




    <tr><th><%=session.getAttribute("operationWithQuestions.id")%></th>
        <th><%=session.getAttribute("operationWithQuestions.text")%></th>
        <th><%=session.getAttribute("operationWithQuestions.date")%></th>

        <th><%=session.getAttribute("operationWithQuestions.numberOf")%></th>
        <th><%=session.getAttribute("operationWithQuestions.allowed")%></th>

        <th><%=session.getAttribute("operationWithQuestions.delete")%></th>
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
            <input type="submit" value="<%=session.getAttribute("operationWithQuestions.delete")%>"></form></td>


    </tr>





    <%}%>
</table>






</body>
</html>
