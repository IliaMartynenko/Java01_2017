<%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 10.07.2017
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/createQuestion" method="post" >
    <h3 class="actual">Задайте ваш вопрос и мы опубликуем его на форуме</h3>

    <textarea name="question" rows="8" cols="70">Тексты вашего вопроса...</textarea>

    <h3>Выберите тему вашего вопроса</h3>
    <select name="topic">
        <option>Политика</option>
        <option>Спорт</option>
        <option>Учёба</option>
        <option>Книги</option>
        <option>Путешествия</option>
        <option>Компьютеры</option>
        <option>Кино</option>
        <option>Музыка</option>
        <option>Автомобили</option>
        <option>Компьютерные игры</option>
        <option>Разное</option>
    </select>
    <%=session.getAttribute("id")%>

    <input type="submit">
</form>

</body>
</html>
