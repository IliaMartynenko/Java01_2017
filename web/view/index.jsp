<%@ page import="com.epam.likeit.dao.impl.SQLUserDAO" %>
<%@ page import="com.epam.likeit.bean.User" %>
<%@ page import="java.util.List" %>


<%@ page import="com.epam.likeit.bean.Question" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 21.05.2017
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Форум LikeIT</title>
  <link rel="stylesheet" href="style/style.css">
</head>
<body>


<header>
  <h1>LikeIT</h1>
  <h2>Лучший форум для обсуждения <br>повседневных тем и вопросов</h2>

  <div class="headimg">
    <img src="images/124.jpg" alt="LikeIT">
  </div>



  <div class="block1">

    <form  action="/controller" method="post">
      <b>Логин:</b>
      <input type="text" maxlength="25" size="20" name="login">
      <input type="hidden" name="command" value="sign_in">



      <b>Пароль:</b>
      <input type="password" maxlength="25" size="20" name="password">

      <input type="submit" value="Войти">
      <input type="checkbox" id="ch" ><label for="ch"><b>Запомнить меня</b></label>


    </form>
    <form action="signin/validate.html">
      <input type="submit"  value="Регистрация">
    </form>




  </div>

  <form action="questions/askQuestion.jsp">
    <button class="knopka" type="submit">Создать тему</button>
  </form>
<div align="100%">
  <form  action="questions/allQuestions.jsp">
    <button class="knopka" type="submit">Открыть все темы форума</button>
  </form>
</div>




</header>
<div id='main'>


  <article>



    <h2 class="actual">Актуальные вопросы пользователей</h2>

    <h2>Политика</h2>
    <table class="tftable">
      <tr><th></th><th>Вопрос</th><th>Дата добавления</th><th>Количество ответов</th></tr>
      <%
        List<Question> questionList=(List)application.getAttribute("questions_by_answers");
        List<Question> questionList1=(List)application.getAttribute("allowed_questions");

        List <Question> politicQuestions=(List)application.getAttribute("politic");
        List <Question> sportQuestions=(List)application.getAttribute("sport");
        List <Question> studyQuestions=(List)application.getAttribute("study");






        for(Question q:questionList1){
            if(q.getIdTopic()==1){
      %>


      <tr><td><form action="/controller" method="post">
        <input type="hidden" name="command" value="get_answer">
        <input type="submit" value="Открыть тему">
        <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>


    <h2>Спорт</h2>
    <table class="tftable" >
      <tr><th></th><th>Вопрос</th><th>Дата добавления</th><th>Количество ответов</th></tr>

      <%for(Question q:questionList1){
        if(q.getIdTopic()==2){
      %>






      <tr><td><form action="/controller" method="post">
        <input type="hidden" name="command" value="get_answer">
         <input type="submit" value="Открыть тему">
        <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>



    <h2>Учёба</h2>

    <table class="tftable" >
      <tr><th>Автор</th><th>Вопрос</th><th>Дата добавления</th><th>Количество ответов</th></tr>

      <%for(Question q:studyQuestions){
        if(q.getIdTopic()==3){
      %>

      <tr>
        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
        <input type="submit" value="Открыть страницу пользователя">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
        <input type="hidden" name="command" value="get_answer">
        <input type="submit" value="Открыть тему">
        <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>

  </article>


  <aside>

    <h3>ТОП-10 по рейтингу посетителей форума</h3>

    <form action="/controller" method="post">
      <input type="hidden" name="command" value="get_ratings">
      <input type="submit" class="knopka" value="Открыть рейтинг популярных">

    </form>

    <h3>Самые обсуждаемые темы форума</h3>



    <table class="tftable">
      <%for(int i=0;i<10;i++){
        Question question=questionList.get(i);
      %>
      <tr><th>Тема обсуждения</th>
        <th>Количество комментариев</th>


      <tr>
        <td><a href=""><%=question.getText()%></a></td>
        <td><%=question.getSumOfanswers()%></td>


      </tr>





      <%}%>
    </table>


    <button class="knopka" type="button">Показатель онлайн пользователей на форуме</button>
  </aside>
</div>




<footer>
  <div class="foot">
    <h6> <a href="reviews/addReview.jsp">Оставить отзыв</a></h6>
  </div>

</footer>


</body>

</html>
