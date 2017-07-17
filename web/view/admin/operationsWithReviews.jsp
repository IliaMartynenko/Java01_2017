
<%@ page import="com.epam.likeit.bean.Review" %>
<%@ page import="java.util.List" %>


<%@ page import="com.epam.likeit.service.ReviewService" %>
<%@ page import="com.epam.likeit.service.impl.ReviewServiceImpl" %>
<%@ page import="com.epam.likeit.service.UserService" %>
<%@ page import="com.epam.likeit.service.impl.UserServiceImpl" %>
<%@ page import="com.epam.likeit.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 05.07.2017
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operations with reviews</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<form action="admin.jsp">
    <button type="submit"><h3>Вернуться на главную страницу Администратора</h3></button>
</form>


<h2>Операции с отзывами о форуме</h2>
<form action="/controller" method="post">
    <h4>Удаление отзыва по его ID</h4>
    <input name="id_review" type="text">
    <button type="submit">Удалить</button>
</form>





<h2>Таблица всех отзывов о форуме</h2>
<%
    List<Review> reviewList=(List)application.getAttribute("reviews");
    List<Review> users=(List)application.getAttribute("users");
    for(Review review:reviewList){

%>
<%=reviewList.get(0).getTextOfReview()%>



<table class="tftable">





    <tr><th>ID отзыва</th>
        <th>ID автора отзыва</th>

        <th>Текст отзыва</th>
        <th>Оценка сайту</th>
        <th>Дата отзыва</th>
        <th>Удалить отзыв</th>
    </tr>

    <tr>
        <td><%=review.getIdReviews()%></td>
        <td><%=review.getIdUser()%></td>

        <td><%=review.getTextOfReview()%></td>
        <td><%=review.getDate()%></td>
        <td><%=review.getRating()%></td>
        <td>
            <form action="/controller" method="post"><input type="hidden" name="id_review" value="<%=review.getIdReviews()%>" >

                <input type="hidden" name="command" value="delete_review">
                <input type="submit" value="Удалить">
            </form>


        </td>

    </tr>





<%}%>

</table>









</body>
</html>
