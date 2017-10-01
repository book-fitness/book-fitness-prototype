<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create an account</title>

    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">
 <div class="header"></div>
 <div class="content">
 <h1 class="page-header-text center">LitFit.ru</h1>
 <div class="form">


    <form:form method="POST" modelAttribute="userForm" class="width-full">

        <h1 class="form-header-text center ">Регистрация</h1>
        <spring:bind path="username">
            <label class="label-text">Ваше имя</label>
            <form:errors path="username" cssClass="error-msg"></form:errors>
            <form:input type="text" path="username" class="width-full" placeholder="Введите свое имя"
                            autofocus="true"></form:input>
        </spring:bind>
		
		
		
        <spring:bind path="phone">
            <label class="label-text">Телефон</label>
            <form:input type="text" path="phone" class="width-full" placeholder="Введите Ваш номер телефона"></form:input>
        </spring:bind>
		
        <spring:bind path="email">
            <label class="label-text">E-mail</label>
            <form:errors path="email" cssClass="error-msg"></form:errors>
            <form:input type="text" path="email" class="width-full" placeholder="E-mail"></form:input>
        </spring:bind>
            
        <spring:bind path="password">
            <label class="label-text">Пароль</label>
            <form:errors path="password" cssClass="error-msg"></form:errors>
            <form:input type="password" path="password" class="width-full" placeholder="Ваш пароль"></form:input>
        </spring:bind>
        
        <spring:bind path="confirmPassword">
            <label class="label-text">Повторите пароль</label>
            <form:errors path="confirmPassword" cssClass="error-msg"></form:errors>
            <form:input type="password" path="confirmPassword" class="width-full"
                            placeholder="Подтвердите пароль"></form:input>
        </spring:bind>

        <input type="submit" value="Зарегистрироваться" class="form-btn width-full">
        <p class="label-text center">Уже есть аккаунт в LitFit?</p>
        <p class="label-text center"><a class="label-text" href="login">Войти</a></p>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>