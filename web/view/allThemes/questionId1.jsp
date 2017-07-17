
<%@ page import="com.epam.likeit.bean.Question" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.bean.User" %>

<%@ page import="com.epam.likeit.bean.Answer" %>
<%@ page import="com.epam.likeit.service.impl.QuestionServiceImpl" %>
<%@ page import="com.epam.likeit.service.impl.AnswerServiceImpl" %>
<%@ page import="com.epam.likeit.service.AnswerService" %>
<%@ page import="com.epam.likeit.service.QuestionService" %>
<%@ page import="com.epam.likeit.service.impl.UserServiceImpl" %>
<%@ page import="com.epam.likeit.service.UserService" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Посоветуйте хороших книг в жанре фантастика</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<% QuestionService questionService=new QuestionServiceImpl();
    AnswerService answerService=new AnswerServiceImpl();

    List<Answer> answers=answerService.getAnswersByQuestion(1);


    UserService userService=new UserServiceImpl();
    List<Question> questionList=questionService.getQuestionByTopicId(1);
    Question question1=questionService.getQuestion(1);
    User user=userService.getUser(question1.getIdUser());
%>



<header>
    <h5>Имя пользователя:
        <em><%=user.getName()%></em></h5>

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

<td> <em>Имя пользователя:</em><h3><%=userService.getUser(answer.getIdUser()).getName()%></h3>
    <em>Количество плюсов:</em>
    <h3><%=userService.getUser(answer.getIdUser()).getNumberOfRatings()%></h3>

    <em>Страна проживания:</em>
    <h3><%=userService.getUser(answer.getIdUser()).getCountry()%></h3>
    <hr>
    <em>Дата ответа:</em>
    <h3><%=answer.getDateOfAnswer()%></h3>

    <form action="/addPlus" method="post">
        <input type="submit" value="Поставить плюс">
        <input type="hidden" name="id_user" value="<%=answer.getIdUser()%>">
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
                <th>Количество просмотров</th>
                <th>Количество ответов</th></tr>

            <tr>
                <td><a href=""><h4>Илья</h4></a></td>
                <td><a href=""><h4><%=question.getText()%></h4></a></td>
                <td><%=question.getDateOfCreate()%></td>
                <td><a href=""><h4><%=question.getSumOfViews()%></h4></a></td>
                <td><a href=""><h4><%=question.getSumOfanswers()%></h4></a></td>

            </tr>





            <%}%>
        </table>



    </aside>
</div>




<footer>
   <form action="/controller" method="post">
       <textarea name="answer" rows="8" cols="70"><%= session.getAttribute("id") %></textarea>
       <input type="hidden" name="id_user" value="12">
       <input type="hidden" name="id_question" value="1">
       <input type="hidden" name="command"  value="add_answer">

       <input type="submit">
   </form>
</footer>








</body>
</html>
