<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Вход</title>
        <script src="//ulogin.ru/js/ulogin.js"></script>
        <meta charset="utf-8">
       	<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1 class="page-header-text center">LitFit.ru</h1>
            </div>
            
            <div class="content">
                <div class="form">
                    <h1 class="form-header-text center">Войти в систему</h1>
                    <form method="POST" action="${contextPath}/login" class="width-full">
                        <label class="label-text">Логин</label><span class="error-msg">${message}</span>
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <input type="text" name="username" class="width-full" placeholder="Ваше Имя" autofocus="true">
                            

                            <span style="float:right;" class="label-text"><a href="">Забыли пароль?</a></span>
                            <label class="label-text">Пароль</label>
                            <input type="text" name="password" class="width-full" placeholder="Ваш пароль"/>
                            <span class="error-msg">${error}</span>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <!--<label class="label-text">Запомнить меня</label><input type="checkbox" name="_spring_security_remember_me" checked>-->

                            <input type="submit" value="Войти" class="form-btn width-full">
                        </div>
                    </form>

                    <p class="label-text center">Или войти через социальные сети</p>
                    <!--<div>VK/FACEBOOK/MAIL.RU/ (See ulogin.ru)</div>-->
        
<div class="center" id="uLogin" data-ulogin="display=panel;theme=classic;fields=first_name,last_name;providers=vkontakte,odnoklassniki,mailru,facebook;hidden=other;redirect_uri=http%3A%2F%2F;mobilebuttons=0;"></div>
                    <hr style="width:180px;">
                    <p class="label-text center">Еще не зарегистрировались в LitFit?</p>
                    <p class="label-text center"><a href="${contextPath}/registration">Регистрация</a></p>
                </div>
                <div class="footer"></div>
            </div>
            <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>-->
    </body>
</html>
