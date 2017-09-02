<%-- 
    Document   : LoginPageView
    Created on : 15.07.2017, 10:07:34
    Author     : Игорь
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <div class="content">
                <h1 class="page-header-text center">LitFit.ru</h1>

                <div class="form">
                    <h1 class="form-header-text center">Войти в систему</h1>

                    <form name="LoginForm" action="/j_spring_security_check" method="POST">
                        <label class="label-text">Логин</label>
                        <input type="text" name="j_username" class="width-full">

                        <span style="float:right;" class="label-text"><a href="">Забыли пароль?</a></span>
                        <label class="label-text">Пароль</label>
                        <input type="text" name="j_password" class="width-full">
                        
                        <label class="label-text">Запомнить меня</label><input type="checkbox" name="_spring_security_remember_me" checked>
                        
                        <input type="submit" value="Войти" class="form-btn width-full">
                    </form>

                    <p class="label-text center">Или войти через социальные сети</p>

                    <div>
                        VK/FACEBOOK/MAIL.RU/ (See ulogin.ru)
                    </div>

                    <hr style="width:180px;">

                    <p class="label-text center">Еще не зарегистрировались в LitFit?</p>
                    <p class="label-text center"><a href="RegistrationPage.htm" >Регистрация</a></p>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
