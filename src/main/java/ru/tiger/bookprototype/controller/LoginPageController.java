/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tiger.bookprototype.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import ru.tiger.bookprototype.dao.UserDAO;
import ru.tiger.bookprototype.db.MD5Util;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;
import ru.tiger.bookprototype.service.LoginServiceImpl;

/**
 *
 * @author Игорь
 */
public class LoginPageController implements Controller {
    
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("POST")) {
            return doPost(request, response);
        } else if (request.getMethod().equals("GET")) {
            return doGet(request, response);
        }

        return null;
    }

    private ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) {

        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        password = MD5Util.getHash(password);

        User user = userDAO.findByLogin(login);

        if (user == null) {
            return new ModelAndView(new RedirectView("RegistrationPage.htm"));
        } else {
            LoginService loginService = new LoginServiceImpl(request.getSession());
            if (loginService.checkPassword(password, user)) {
                loginService.login(user);
                return new ModelAndView(new RedirectView("MainPage.htm"));
            } else {
                return new ModelAndView(new RedirectView("LoginPage.htm"));
            }
        }

        //return null;
    }
    
    private ModelAndView doGet(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("/view/LoginPageView.jsp");
    }
}
