<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <div class="content">
                <h1 class="page-header-text center">LitFit.ru</h1>
                <div class="form">
                    <script>
                        /*$(document).ready(function() {
                         $("input.form-btn").on({
                         mouseenter: function() {
                         $(this).addClass("form-action-btn");
                         },
                         mouseleave: function() {
                         $(this).removeClass("form-action-btn");
                         }
                         });
                         });*/
                        function submitForm() {
                            var password = document.forms[0]['Password'].value;
                            var repeatPassword = document.forms[0]['RepeatPassword'].value;

                            var errorMsgForPswd = document.getElementById("errorMsgForPswd");

                            if (password == repeatPassword) {
                                document.forms[0].submit();
                            } else {
                                errorMsgForPswd.innerHTML = "Passwords are not equal!";
                            }
                        }
                    </script>
                    <h1 class="form-header-text center ">Регистрация</h1>
                    <form name="RegistrationForm"  action="RegistrationPage.htm" method="POST">
                        <label class="label-text">Имя</label>
                        <input type="text" name="Login" class="width-full">
                        <label class="label-text">Телефон</label>
                        <input type="text" name="Phone" class="width-full">
                        <label class="label-text">E-mail</label>
                        <input type="text" name="Email" class="width-full">
                        <label class="label-text">Пароль</label>
                        <input type="text" name="Password" class="width-full">
                        <label class="label-text">Повторите пароль</label>
                        <span id="errorMsgForPswd" style="color:red;" class="label-text"></span>
                        <input type="text" name="RepeatPassword" class="width-full">

                        <input type="submit" value="Зарегистрироваться" class="form-btn width-full" onclick="submitForm();
                                return false;">
                        <p class="label-text center">Уже есть аккаунт в LitFit?</p>
                        <p class="label-text center"><a class="label-text" href="LoginPage.htm">Войти</a></p>
                    </form>
                </div>
                <div class="footer"></div>
            </div>
    </body>
</html>

