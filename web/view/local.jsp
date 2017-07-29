<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: mts7072572
  Date: 21.07.2017
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String lang = request.getParameter("lang");

    if (lang == null) {
%>
<html>
<head>
    <title>
        Music Without Borders
    </title>
</head>
<body bgcolor="#33CCFF">

<hr>

    Please select a language:
    <form action="local.jsp" method="post">
        English <input type="radio" name="lang" value="English" checked>
        Russia <input type="radio" name="lang" value="Russia">
        Franзais <input type="radio" name="lang" value="French">

    <input type="submit" value="Continue">
    </form>
</body>
</html>
<%
} else {
    Locale locale=null;
    if (lang.equals("Russia")) {
        locale=new Locale("ru","RU");
    } else if (lang.equals("French")) {
        locale=Locale.FRANCE;
    } else if (lang.equals("Swedish")) {
        locale=new Locale("sv","SE");
    } else {
        locale=Locale.US;
    }
    session.setAttribute("myLocale",locale);
    ResourceBundle bundle =
            ResourceBundle.getBundle("Message",locale);

    for (Enumeration e = bundle.getKeys(); e.hasMoreElements();) {
        String key = (String)e.nextElement();
        String s = bundle.getString(key);
        session.setAttribute(key,s);
    }
%>

<%
    }
%>
