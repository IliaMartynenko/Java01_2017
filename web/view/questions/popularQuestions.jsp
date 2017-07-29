<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 20.07.2017
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Popular questions</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<table class="tftable">
    <% List<Question> questionList=(List)session.getAttribute("question_by_rating");
        for(int i=0;i<10;i++){
        Question question=questionList.get(i);
    %>
    <tr><th><%=session.getAttribute("popularQuestion.theme")%></th>
        <th><%=session.getAttribute("popularQuestion.sumOfComments")%></th>


    <tr>
        <td><a href=""><%=question.getText()%></a></td>
        <td><%=question.getSumOfanswers()%></td>


    </tr>





    <%}%>
</table>

</body>
</html>
