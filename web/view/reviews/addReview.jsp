<%@ page import="com.epam.likeit.bean.Review" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.likeit.service.impl.ReviewServiceImpl" %>
<%@ page import="com.epam.likeit.service.ReviewService" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../style/review_style.css">
</head>
<body>
<form action="../index.jsp">
    <button type="submit"><h3><%=session.getAttribute("answerError.back")%></h3></button>
</form>

<hr>

<form action="/controller" method="post" >
    <h3 class="actual"><%=session.getAttribute("addReview.writeReview")%></h3>

   <textarea name="review" rows="8" cols="70"><%=session.getAttribute("addReview.text")%></textarea>
    <h3><%=session.getAttribute("addReview.chooseRating")%></h3>
    <input name="rating" type="number" min="1" max="10">
    <input type="hidden" name="command" value="add_review">
    <input class="knopka" type="submit" value="<%=session.getAttribute("addReview.send")%>">
</form>
<hr>

<h3 class="actual"><%=session.getAttribute("addReview.list")%>:</h3>

<%
    ReviewService reviewService=new ReviewServiceImpl();
    List<Review> reviewsList=reviewService.getAllReviews();
%>
<ul>
        <%for(int i=0;i<reviewsList.size();i++){%>
            <li><%=reviewsList.get(i).getTextOfReview()%> <h4><%=session.getAttribute("addReview.date")%>:<%=reviewsList.get(i).getDate()%>   </h4>
                <h4 class="mark"><%=session.getAttribute("addReview.rating")%>    <%=reviewsList.get(i).getRating()%>  </h4><hr>  </li>
                <%}%>


</body>
</html>
