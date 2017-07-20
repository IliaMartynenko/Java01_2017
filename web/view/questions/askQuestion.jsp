
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать вопрос</title>
</head>
<body>

<form action="/controller" method="post" >

    <h3 class="actual">Задайте ваш вопрос и мы опубликуем его на форуме</h3>

    <textarea name="question" rows="8" cols="70">Тексты вашего вопроса...</textarea>
<input type="hidden" name="id" value="2">
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
<input type="hidden" value="add_question" name="command">
    <input type="hidden" name="id_user" value="<%=session.getAttribute("user_id")%>">
<input type="submit">
</form>

</body>
</html>
