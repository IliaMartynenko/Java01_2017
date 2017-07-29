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
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>LikeIT</title>
  <link rel="stylesheet" href="style/style.css">
</head>
<body>


<header>
  <h1>LikeIT</h1>
  <h2><%=session.getAttribute("index.name")%></h2>

  <div class="headimg">
    <img src="images/124.jpg" alt="LikeIT">
  </div>



  <div class="block1">

    <form  action="/controller" method="post">
      <b><%=session.getAttribute("index.login")%></b>
      <input type="text" maxlength="25" size="20" name="login">
      <input type="hidden" name="command" value="sign_in">



      <b><%=session.getAttribute("index.password")%></b>
      <input type="password" maxlength="25" size="20" name="password">

      <input type="submit" value="<%=session.getAttribute("index.signin")%>">



    </form>
    <form action="signin/validate.jsp">
      <input type="submit"  value="<%=session.getAttribute("index.registration")%>">
    </form>




  </div>

  <form action="questions/askQuestion.jsp">
    <button class="knopka" type="submit"><%=session.getAttribute("index.createQuestion")%></button>
  </form>
<div align="100%">
  <form  action="questions/allQuestions.jsp">
    <button class="knopka" type="submit"><%=session.getAttribute("index.openThemes")%></button>
  </form>
</div>




</header>
<div id='main'>


  <article>



    <h2 class="actual"><%=session.getAttribute("index.actual")%></h2>

    <h2><%=session.getAttribute("index.politic")%></h2>
    <table class="tftable">
      <tr><th><%=session.getAttribute("index.author")%></th>
        <th></th>
        <th><%=session.getAttribute("index.question")%></th>
        <th><%=session.getAttribute("index.date")%></th>
        <th><%=session.getAttribute("index.sumofquestions")%></th></tr>
      <%

        List<Question> questionList1=(List)application.getAttribute("allowed_questions");
        for(Question q:questionList1){
            if(q.getIdTopic()==1){
      %>


      <tr>
        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
          <input type="submit" value="<%=session.getAttribute("index.openUserPage")%>">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
          <input type="hidden" name="command" value="get_answer">
          <input type="submit" value="<%=session.getAttribute("index.openTheme")%>">
          <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>



    <h2><%=session.getAttribute("index.sport")%></h2>
    <table class="tftable">
      <tr><th><%=session.getAttribute("index.author")%></th>
        <th></th>
        <th><%=session.getAttribute("index.question")%></th>
        <th><%=session.getAttribute("index.date")%></th>
        <th><%=session.getAttribute("index.sumofquestions")%></th></tr>








      <%for(Question q:questionList1){
        if(q.getIdTopic()==2){
      %>






      <tr>



        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
          <input type="submit" value="<%=session.getAttribute("index.openUserPage")%>">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
          <input type="hidden" name="command" value="get_answer">
          <input type="submit" value="<%=session.getAttribute("index.openTheme")%>">
          <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>




      <h2><%=session.getAttribute("index.study")%></h2>
      <table class="tftable">
        <tr><th><%=session.getAttribute("index.author")%></th>
          <th></th>
          <th><%=session.getAttribute("index.question")%></th>
          <th><%=session.getAttribute("index.date")%></th>
          <th><%=session.getAttribute("index.sumofquestions")%></th></tr>

      <%for(Question q:questionList1){
        if(q.getIdTopic()==3){
      %>

      <tr>
        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
          <input type="submit" value="<%=session.getAttribute("index.openUserPage")%>">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
          <input type="hidden" name="command" value="get_answer">
          <input type="submit" value="<%=session.getAttribute("index.openTheme")%>">
          <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

      </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>


    <h2><%=session.getAttribute("index.book")%></h2>
    <table class="tftable">
      <tr><th><%=session.getAttribute("index.author")%></th>
        <th></th>
        <th><%=session.getAttribute("index.question")%></th>
        <th><%=session.getAttribute("index.date")%></th>
        <th><%=session.getAttribute("index.sumofquestions")%></th></tr>

      <%for(Question q:questionList1){
        if(q.getIdTopic()==4){
      %>

      <tr>
        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
          <input type="submit" value="<%=session.getAttribute("index.openUserPage")%>">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
          <input type="hidden" name="command" value="get_answer">
          <input type="submit" value="<%=session.getAttribute("index.openTheme")%>">
          <input type="hidden" name="id_question" value="<%=q.getIdQuestion()%>">

        </form></td>
        <td><a href=""><%=q.getText()%></a></td>
        <td><%=q.getDateOfCreate()%></td>
        <td><%=q.getSumOfanswers()%></td></tr>
      <%}%>
      <%}%>
    </table>


    <h2><%=session.getAttribute("index.travel")%></h2>
    <table class="tftable">
      <tr><th><%=session.getAttribute("index.author")%></th>
        <th></th>
        <th><%=session.getAttribute("index.question")%></th>
        <th><%=session.getAttribute("index.date")%></th>
        <th><%=session.getAttribute("index.sumofquestions")%></th></tr>
      <%for(Question q:questionList1){
        if(q.getIdTopic()==5){
      %>

      <tr>
        <td><form action="/controller" method="post"><input type="hidden" name="id_user" value="<%=q.getIdUser()%>" >
          <input type="submit" value="<%=session.getAttribute("index.openUserPage")%>">
          <input type="hidden" value="get_user" name="command">
        </form></td>
        <td><form action="/controller" method="post">
          <input type="hidden" name="command" value="get_answer">
          <input type="submit" value="<%=session.getAttribute("index.openTheme")%>">
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
    <h3><%=session.getAttribute("index.mostpopular")%></h3>
    <form action="/controller" method="post">
      <input type="hidden" name="command" value="get_question_by_rating">
      <input type="submit" class="knopka" value="<%=session.getAttribute("index.openPopularQuestions")%>">

    </form>



    <h3><%=session.getAttribute("index.topofusers")%></h3>


    <form action="/controller" method="post">
      <input type="hidden" name="command" value="get_ratings">
      <input type="submit" class="knopka" value="<%=session.getAttribute("index.openRating")%>">

    </form>








  </aside>
</div>




<footer>
  <div class="foot">
    <h6> <a href="reviews/addReview.jsp"><%=session.getAttribute("index.review")%></a></h6>
  </div>

</footer>


</body>

</html>
