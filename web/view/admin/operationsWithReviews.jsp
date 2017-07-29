
<%@ page import="com.epam.likeit.bean.Review" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operations with reviews</title>
    <link rel="stylesheet" href="../style/style.css">
</head>
<body>
<form action="admin.jsp">
    <button type="submit"><h3><%=session.getAttribute("operationsWithReviews.back1")%></h3></button>
</form>







<h2><%=session.getAttribute("operationsWithReviews.table")%></h2>
<%
    List<Review> reviewList=(List)session.getAttribute("reviews");

    for(Review review:reviewList){

%>




<table class="tftable">





    <tr><th><%=session.getAttribute("operationsWithReviews.id")%></th>
        <th><%=session.getAttribute("operationsWithReviews.idAuthor")%></th>

        <th><%=session.getAttribute("operationsWithReviews.text")%></th>
        <th><%=session.getAttribute("operationsWithReviews.rating")%></th>
        <th><%=session.getAttribute("operationsWithReviews.date")%></th>
        <th><%=session.getAttribute("operationsWithReviews.delete")%></th>
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
                <input type="submit" value="<%=session.getAttribute("operationsWithReviews.delete")%>">
            </form>


        </td>

    </tr>





<%}%>

</table>









</body>
</html>
