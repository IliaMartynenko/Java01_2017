<%@ page import="com.epam.likeit.dao.QuestionDAO" %>
<%@ page import="com.epam.likeit.dao.impl.SQLQuestionDAO" %>
<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.service.impl.QuestionServiceImpl" %>
<%@ page import="com.epam.likeit.service.QuestionService" %>


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
        <button type="submit"><h3><%=session.getAttribute("answerError.back")%></h3></button>
    </form>
<table class="tftable">
    <%for(int i=0;i<questionList.size();i++){
        Question question=questionList.get(i);
    %>




    <tr>
        <th><%=session.getAttribute("allQuestions.question")%></th>
        <th><%=session.getAttribute("allQuestions.date")%></th>
        <th><%=session.getAttribute("allQuestions.sumOfAnswers")%></th></tr>

    <tr>

        <td><h4><%=question.getText()%></h4></td>
        <td><%=question.getDateOfCreate()%></td>
        <td><h4><%=question.getSumOfanswers()%></h4></td>

    </tr>





    <%}%>
</table>


</body>
</html>
