<%@ page import="com.epam.likeit.bean.Review" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.service.impl.ReviewServiceImpl" %>
<%@ page import="com.epam.likeit.service.ReviewService" %>

Created by IntelliJ IDEA.
  User: mts7072572
  Date: 24.06.2017
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/review_style.css">
</head>
<body>
<form action="../index.jsp">
    <button type="submit"><h3>Вернуться на начальную страницу</h3></button>
</form>

<hr>

<form action="/controller" method="post" >
    <h3 class="actual">Напишите ваш отзыв</h3>

   <textarea name="review" rows="8" cols="70">Тексты отзыва</textarea>
    <h3>Выберите свою оценку от 1 до 10.</h3>
    <input name="rating" type="number" min="1" max="10">
    <input type="hidden" name="command" value="add_review">
    <input class="knopka" type="submit">
</form>
<hr>

<h3 class="actual">Список отзывов:</h3>

<%
    ReviewService reviewService=new ReviewServiceImpl();
    List<Review> reviewsList=reviewService.getAllReviews();
%>
<ul>
        <%for(int i=0;i<reviewsList.size();i++){%>
    <li><%=reviewsList.get(i).getTextOfReview()%> <h4>Дата отзыва:<%=reviewsList.get(i).getDate()%>   </h4>    <h4 class="mark">Оценка:<%=reviewsList.get(i).getRating()%>  </h4><hr>  </li>
        <%}%>


</body>
</html>
