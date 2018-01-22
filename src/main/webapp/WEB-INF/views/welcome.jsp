<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Добро пожаловать!</title>
        
        <script src="${contextPath}/resources/js/jquery-3.1.1.js"></script>
        <script src="${contextPath}/resources/js/knockout-3.4.2.js"></script>
        <script src="${contextPath}/resources/js/global.js"></script>
        
        <link rel="stylesheet" href="${contextPath}/resources/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/global.css">
        <link rel="stylesheet" href="${contextPath}/resources/css/welcome.css">
        
        <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    </head>
    <body>

        <div id="welcome" class="container">
            <div class="header">
                <div id="project-logo">
                    <h1>LitFit.ru</h1>
                </div>
                <div class="search">
                    <input id="search" type="text" size="32" placeholder="Поиск людей "><i class="fa fa-search" aria-hidden="true"></i>
                </div>
                <div class="top-buttons">
                    <ul>
                        <li><a href="about">О проекте</a></li>
                        <li><a href="registration">Регистрация</a></li>
                        <li><a href="login">Войти</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="left-side-bar">
                <div class="user-info">
                    <img class="user-avatar" src="" width="50" height="50" alt="Нет фото">
                    <span class="user-name">Александр Иванов</span>
                    <span class="user-status">Новичек</span>
                    <hr>
                    <table>
                        <tr>
                            <td>Статей</td>
                            <td>Постов</td>
                        </tr>
                        <tr>
                            <td>260</td>
                            <td>1565</td>
                        </tr>
                    </table>
                </div>
                <div class="user-menu">
                    <ul>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Задания</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Мои книги</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Интересное</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Моя команда</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Рейтинг</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>О проекте</li>
                        <li><i class="fa fa-smile-o" aria-hidden="true"></i>Мой профиль</li>
                    </ul>
                </div>
            </div>
            
            <div class="content">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
                </c:if>
                
                <hr>
                
                <div id="news">
                    <ul class="tab-header">
                        <li>Лента</li>
                        <li>Новости</li>
                    </ul>

                    <div class="news-line">
                        <div class="article">
                            <h2>Заголовок статьи заголовок статьи</h2>
                            <div class="date"><i class="fa fa-calendar" aria-hidden="true"></i>17.08.2017</div>
                            <p>Текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи. <a href="">Читать полностью</a></p>
                            <div>
                                <div class="likes-count"><i class="fa fa-heart" aria-hidden="true"></i>135</div>
                                <div class="comments-count"><i class="fa fa-comment-o" aria-hidden="true"></i>35</div>
                                <div class=""><i class="fa fa-bullhorn" aria-hidden="true"></i>vk,fb,ok,g+,etc.</div>
                            </div>
                        </div>
                        <div class="article">
                            <h2>Заголовок статьи заголовок статьи</h2>
                            <div class="date"><i class="fa fa-calendar" aria-hidden="true"></i>17.08.2017</div>
                            <p>Текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи. <a href="">Читать полностью</a></p>
                            <div>
                                <div class="likes-count"><i class="fa fa-heart" aria-hidden="true"></i>135</div>
                                <div class="comments-count"><i class="fa fa-comment-o" aria-hidden="true"></i>35</div>
                                <div class=""><i class="fa fa-bullhorn" aria-hidden="true"></i>vk,fb,ok,g+,etc.</div>
                            </div>
                        </div>
                        <div class="article">
                            <h2>Заголовок статьи заголовок статьи</h2>
                            <div class="date"><i class="fa fa-calendar" aria-hidden="true"></i>17.08.2017</div>
                            <p>Текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи текст статьи. <a href="">Читать полностью</a></p>
                            <div>
                                <div class="likes-count"><i class="fa fa-heart" aria-hidden="true"></i>135</div>
                                <div class="comments-count"><i class="fa fa-comment-o" aria-hidden="true"></i>35</div>
                                <div class=""><i class="fa fa-bullhorn" aria-hidden="true"></i>vk,fb,ok,g+,etc.</div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="news">Новости</div>
                </div>
                
                <div id="tasks">
                    <div class="tab-header">Задания</div>
                    <div>
                        Тут должна быть информация о книге
                    </div>
                    
                    Поясняющий текст что это за штука<br>
                    
                    <div>
                        <div style="border-radius:30px 30px;width:60px;height:60px;background-color:green;display:inline-block;"></div>
                        <div style="border-radius:30px 30px;width:60px;height:60px;background-color:red;display:inline-block;"></div>
                        <div style="border-radius:30px 30px;width:60px;height:60px;background-color:orange;display:inline-block;"></div>
                        <div style="border-radius:30px 30px;width:60px;height:60px;background-color:lightgray;display:inline-block;"></div>
                    </div>
                    
                    Сравнительная шкала<br>
                    <div style="width:75%;height:4px;background-color:lightgray;border-left:200px solid green;box-sizing: border-box;"></div>
                    <br>
                </div>
                
                <div id="my-books">Мои книги</div>
                
                <div id="post-editor">
                    Написать статью
                    
                    <form name="postEditor">
                        <input name="header" type="text" value="Заголовок статьи" /><br/>
                        <textarea name="text" cols="80" rows="10"></textarea><br/>
                        <button name="send" onclick="alert('Текст для отправки\n' + document.forms.postEditor.text.value);return false;">Отправить</button>
                    </form>
                </div>
                
                <div id="my-team">Моя команда</div>
                
                <div id="rating">
                    <div class="tab-header">Рейтинг</div>
                    <hr>
                    <ul>
                        <li>
                            <span>Я относитель команды</span>
                            <div class="stack-chart">
                                <div class="grid">
                                    <div></div>
                                    <div></div>
                                </div>
                                <div class="charts">
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <span>Я относительно других участников</span>
                            <div class="stack-chart">
                                <div class="grid">
                                    <div></div>
                                    <div></div>
                                </div>
                                <div class="charts">
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <span>Список по баллам</span>
                            <ul>
                                <li></li>
                                <li></li>
                            </ul>
                        </li>
                        <li>
                            <span>Моя команда относительно других участников</span>
                            <div class="stack-chart">
                                <div class="grid">
                                    <div></div>
                                    <div></div>
                                </div>
                                <div class="charts">
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                    <div class="stack-chart" style="border-bottom: 20px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 40px solid grey;"></div>
                                    <div class="stack-chart" style="border-bottom: 60px solid orange;"></div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <span>Лучшие команды</span>
                            <ul>
                                <li></li>
                                <li></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                
                <div id="about-project">О проекте</div>
                
                <div id="my-profile">Мой профиль</div>
            </div>
            
            <div class="footer">
                Подвал
            </div>
        </div>
        
        <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
        <%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
    </body>
</html>
