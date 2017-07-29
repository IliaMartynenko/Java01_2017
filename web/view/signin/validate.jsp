<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../style/style_validate.css">
    <script language="javascript">
        var items=1;
        function AddItem() {
            div=document.getElementById("div");
            button=document.getElementById("add");

            newitem="<strong id='str'>Дополнительный email: </strong>";
            newitem+="<input type=\"text\" class=\"del\"   id=\"item\" ";
            newitem+="\" size=\"180\"  pattern=\"^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$\" ><br>";
            newnode=document.createElement("span");
            newnode.innerHTML=newitem;
            div.insertBefore(newnode,button);
            addButton();
        }
        function removeButton() {



           var card = document.getElementById("butt");
            var text = document.getElementById("item");
            var str = document.getElementById("str");
            str.parentNode.removeChild(str);
            text.parentNode.removeChild(text);
        card.parentNode.removeChild(card);

        }
        function addButton() {
            div=document.getElementById("div");
            button=document.getElementById("add");

            newitem="<input type=\"button\" id=\"butt\" class=\"butt\" value=\"Удалить поле\" onClick=\"removeButton()\";>";

            newnode=document.createElement("span");
            newnode.innerHTML=newitem;
            div.insertBefore(newnode,button);
        }
    </script>
</head>

<body>

<form onsubmit="return validateForm()" method="post" action="/controller">
    <section class="container one">
        <p><label id="user_name"><%=session.getAttribute("validate.login")%></label>
            <input required type="text" title="<%=session.getAttribute("validate.login.message")%>" name="user_login" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{4,}$"><span class="err" id="err-uname"></span></p>

        <p><label id="password"><%=session.getAttribute("validate.password")%></label>
            <input required type="password"  name="password" title="<%=session.getAttribute("validate.password.message")%>" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}"><span class="err" id="err-pwd1"></span></p>


        <p><label id="name"><%=session.getAttribute("validate.name")%></label>
            <input required name="name" type="text" title="<%=session.getAttribute("validate.name.message")%>" name="name" pattern="^[A-Z][a-zA-Z0-9-_\.]{4,}$"><span class="err" id="namee"></span></p>


        <p><label id="age"><%=session.getAttribute("validate.age")%></label>
            <input required type="number" name="age" title="<%=session.getAttribute("validate.age.message")%>" min="7" max="120" ><span></span></p>



        <p><label id="country"><%=session.getAttribute("validate.country")%></label>
            <input required type="text" name="country" title="<%=session.getAttribute("validate.country.message")%>" pattern="^[A-Z][a-z]{1,50}$" ><span></span></p>


      <div id="items" > <p><label id="email"><%=session.getAttribute("validate.mail")%></label>
            <input required type="text" title="<%=session.getAttribute("validate.mail.message")%>" name="email" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" ><span></span></p>


<input type="hidden" name="command" value="registration">



        </div>




    </section>

    <section class="container two">
        <button type="submit"><%=session.getAttribute("validate.registration")%></button>
    </section>
</form>




</body>
</html>