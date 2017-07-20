
<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.bean.User" %>

<%@ page import="com.epam.likeit.bean.Answer" %>
<%@ page import="java.util.Map" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Посоветуйте хороших книг в жанре фантастика</title>
    <link rel="stylesheet" href="../users/style.css">
</head>
<body>

<%

    List<Answer> answers=(List)session.getAttribute("answers");
    List<Question> questionList=(List)session.getAttribute("questions_by_topic");
    Question question1=(Question)session.getAttribute("question");
    Map<Integer,String> users_map=(Map)session.getAttribute("users_by_answers");
    String name_user=(String)(session.getAttribute("user_name"));

    Map<Integer,Integer> users_ratings=(Map)session.getAttribute("user_ratings");
%>



<header>
    <h5>Имя пользователя:
        <em><%=name_user%></em></h5>

    <hr>

    <h5>Дата создания:
        <em><%=question1.getDateOfCreate()%></em>
        <hr>
    </h5><h4>Текст вопроса:</h4>
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

    <em>Количество плюсов пользователя:</em>
    <h3><%=users_ratings.get(answer.getIdAnswer())%></h3>




    <em>Дата ответа:</em>
    <h3><%=answer.getDateOfAnswer()%></h3>

    <form action="/controller" method="post">
        <input type="submit" value="Поставить плюс">
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


    <aside>
        <h3>Список недавних вопросов по теме политики</h3>
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



    </aside>
</div>




<footer>
   <form action="/controller" method="post">
       <textarea name="answer" rows="8" cols="70"><%=session.getAttribute("user_id") %></textarea>
       <input type="hidden" name="id_user" value="<%=session.getAttribute("user_id")%>">
       <input type="hidden" name="id_question" value="<%=question1.getIdQuestion()%>">
       <input type="hidden" name="command"  value="add_answer">

       <input type="submit">
   </form>
</footer>








</body>
</html>
