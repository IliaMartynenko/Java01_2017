
<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>


<%@ page import="com.epam.likeit.bean.Answer" %>
<%@ page import="java.util.Map" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=session.getAttribute("question1.question")%></title>
    <link rel="stylesheet" href="../users/style.css">
</head>
<body>

<button type="button"><a href="../index.jsp">Back to home page!</a></button>

<%

    List<Answer> answers=(List)session.getAttribute("answers");
    Question question1=(Question)session.getAttribute("question");
    Map<Integer,String> users_map=(Map)session.getAttribute("users_by_answers");
    String name_user=(String)(session.getAttribute("user_name"));
    Map<Integer,Integer> users_ratings=(Map)session.getAttribute("user_ratings");
%>



<header>
    <h5><%=session.getAttribute("question1.name")%>:
        <em><%=name_user%></em></h5>

    <hr>

    <h5><%=session.getAttribute("question1.date")%>:
        <em><%=question1.getDateOfCreate()%></em>
        <hr>
    </h5><h4><%=session.getAttribute("question1.text")%>:</h4>
    <p>
       <%=question1.getText()%>
    </p>

</header>
<div id='main'>


    <article>
        <%for(Answer answer:answers){%>
        <table class="tftable">

<td> <em>Имя пользователя:</em>
    <h3><%=users_map.get(answer.getIdAnswer())%></h3>
    <form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=answer.getIdUser()%>" >
    <input type="submit" value="<%=session.getAttribute("question1.openPage")%>">
    <input type="hidden" value="get_user" name="command">
    </form>

    <em><%=session.getAttribute("question1.ratingOfUser")%>:</em>
    <h3><%=users_ratings.get(answer.getIdAnswer())%></h3>




    <em><%=session.getAttribute("question1.dateOfAnswer")%>:</em>
    <h3><%=answer.getDateOfAnswer()%></h3>

    <form action="/controller" method="post">
        <input type="submit" value="<%=session.getAttribute("question1.addPlus")%>">
        <input type="hidden" name="id_answer" value="<%=answer.getIdAnswer()%>">
        <input type="hidden" name="id_user" value="<%=answer.getIdUser()%>">

        <input type="hidden" name="command" value="add_plus">

    </form>
   </td>
            <td style="font-size: 25px;width: 1150px;">
               <%=answer.getAnswerText()%>
            </td>
        </table>

        <hr>

<%}%>
    </article>



</div>




<footer>
   <form action="/controller" method="post">
       <textarea name="answer" rows="10" cols="120"><%=session.getAttribute("question1.addAnswer")%> </textarea>
       <input type="hidden" name="id_user" value="<%=session.getAttribute("user_id")%>">
       <input type="hidden" name="id_question" value="<%=question1.getIdQuestion()%>">
       <input type="hidden" name="command"  value="add_answer">

       <input type="submit" value="<%=session.getAttribute("question1.send")%>">
   </form>
</footer>








</body>
</html>
