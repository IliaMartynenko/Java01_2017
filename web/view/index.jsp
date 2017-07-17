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

    <form  action="/SignIn" method="post">
      <b>Логин:</b>
      <input type="text" maxlength="25" size="20" name="login">



      <b>Пароль:</b>
      <input type="password" maxlength="25" size="20" name="password">

      <input type="submit" value="Войти">
      <input type="checkbox" id="ch" ><label for="ch"><b>Запомнить меня</b></label>


    </form>
    <form action="signin/validate.html">
      <input type="submit"  value="Регистрация">
    </form>

    <form action="/SignIn" method="get">
      <p><input type="search" name="q" placeholder="Поиск по сайту">
        <input type="submit" value="Найти"></p>
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
      <tr><th>Автор</th><th>Вопрос</th><th>Дата добавления</th><th>Количество просмотров</th><th>Количество ответов</th></tr>
      <%
        List<Question> questionList=(List)application.getAttribute("questions_by_answers");
        List<User> userList=(List)application.getAttribute("users");
        List <Question> politicQuestions=(List)application.getAttribute("politic");
        List <Question> sportQuestions=(List)application.getAttribute("sport");
        List <Question> studyQuestions=(List)application.getAttribute("study");
        List <Question> booksQuestions=(List)application.getAttribute("books");
        List <Question> travelsQuestions=(List)application.getAttribute("travels");
        List <Question> computersQuestions=(List)application.getAttribute("computers");
        List <Question> cinemaQuestions=(List)application.getAttribute("cinema");
        List <Question> musicQuestions=(List)application.getAttribute("music");
        List <Question> carsQuestions=(List)application.getAttribute("cars");


        for(Question q:politicQuestions){
      %>


      <tr><td><a href="index.html"></a></td><td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
    </table>


    <h2>Спорт</h2>
    <table class="tftable" >
      <tr><th>Автор</th><th>Вопрос</th><th>Дата добавления</th><th>Количество просмотров</th><th>Количество ответов</th></tr>

      <%for(Question q:sportQuestions){
      %>


      <tr><td><a href="index.html"></a></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>






    </table>



    <h2>Учёба</h2>

    <table class="tftable" >
      <tr><th>Автор</th><th>Вопрос</th><th>Дата добавления</th><th>Количество просмотров</th><th>Количество ответов</th></tr>

      <%for(Question q:studyQuestions){
      %>


      <tr><td><a href="index.html"></a></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
    </table>


    <h2>Книги</h2>

    <table class="tftable" >
      <tr><th>Автор</th>
        <th>Вопрос</th>
        <th>Дата добавления</th>
        <th>Количество просмотров</th>
        <th>Количество ответов</th>
      </tr>
      <%for(Question q:booksQuestions){
      %>
      <tr><td><a href="index.html"></a></td><td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
    </table>


    <h2>Путешествия</h2>

    <table class="tftable" >
      <tr><th>Автор</th>
        <th>Вопрос</th>
        <th>Дата добавления</th>
        <th>Количество просмотров</th>
        <th>Количество ответов</th></tr>
      <%for(Question q:travelsQuestions){
      %>


      <tr><td><a href="index.html"></a></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
    </table>



    <h2>Компьютеры</h2>

    <table class="tftable" >
      <tr><th>Автор</th>
        <th>Вопрос</th>
        <th>Дата добавления</th>
        <th>Количество просмотров</th>
        <th>Количество ответов</th>
      </tr>
      <%for(Question q:computersQuestions){
      %>


      <tr><td><a href="index.html"></a></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
    </table>





  </article>


  <aside>

    <h3>ТОП-10 по рейтингу посетителей форума</h3>

    <ol class="rounded">
      <%for(User user:userList){%>
      <li><a href="#"><%=user.getName()%>    <%=user.getNumberOfRatings()%></a></li>
      <%}%>


    </ol>




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
