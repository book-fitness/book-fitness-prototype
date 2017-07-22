<%-- 
    Document   : LoginPageView
    Created on : 15.07.2017, 10:07:34
    Author     : Игорь
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form name="LoginForm" action="LoginPage" method="POST">
            Login <input type="text" name="login">
            Password <input type="text" name="password">
            <input type="submit" value="Login">
        </form>
        <div>
            VK/FACEBOOK/MAIL.RU/ (See ulogin.ru)
        </div>
        <a href="RegistrationPage" >Registration</a><br>
    </body>
</html>
