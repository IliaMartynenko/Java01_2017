function validateForm() {
    var result = true; // результат, используем, чтобы проверять сразу все поля ввода
// Константы
    var FILL_FIELD = "*заполните поле",
        PWD_NOT_EQUAL = "*не совпадают значения паролей",
        BAD_FIRST_SYMBOL = "*некорректный первый символ(A-z)";
// Находим ссылки на элементы сообщений об ошибках
    var errUname = document.getElementById("err-uname"),
        errPwd1 =  document.getElementById("err-pwd1"),
        errPwd2 =  document.getElementById("err-pwd2");
// Предварительно очищаем сообщения об ошибках
    errUname.innerHTML = "";
    errPwd1.innerHTML = "";
    errPwd2.innerHTML = "";
// Читаем значения из полей формы
    var usr = document.forms[0]["usrname"].value,    // или document.testForm.usrname.value
        pwd1 = document.forms[0]["pwd1"].value,      // или document.testForm.pwd1.value
        pwd2 = document.forms[0]["pwd2"].value;      // или document.testForm.pwd2.value
// Проверка поля "Пользователь"
    if (!usr) {
        errUname.innerHTML = FILL_FIELD;
        result = false;
    }  // обязательное заполнение
    if (usr && usr.search(/[a-z]/i) !== 0) {
        errUname.innerHTML = BAD_FIRST_SYMBOL;
        result = false;
    }  // Первый символ - латинская буква в любом регистре
// Проверка паролей
    if (!pwd1) {
        errPwd1.innerHTML = FILL_FIELD;
        result = false;
    }  // обязательное заполнение
    if (!pwd2) {
        errPwd2.innerHTML = FILL_FIELD;
        result = false;
    }  // обязательное заполнение
    if (pwd1 && pwd2 && pwd1 !== pwd2) {
        errPwd1.innerHTML = PWD_NOT_EQUAL;
        errPwd2.innerHTML = PWD_NOT_EQUAL;
        document.forms[0]["pwd1"].value = "";   // сброс
        document.forms[0]["pwd2"].value = "";   // сброс
        result = false;
    }   // должны совпадать
// возвращаем итог проверки
    return result;
}