/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import ru.tiger.bookprototype.dao.UserDAO;
import ru.tiger.bookprototype.dao.UserDAOMap;
import ru.tiger.bookprototype.db.MD5Util;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Игорь
 */
public class RegistrationPageController implements Controller {
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        System.out.println("Registration Page Controller...");
        if (request.getMethod().equals("GET")) {
            return doGet(request, response);
        } else if (request.getMethod().equals("POST")) {
            return doPost(request, response);
            
        }
        return new ModelAndView("view/ErrorView.jsp"); 
    }
    
    private ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/view/RegistrationView.jsp");
    }
    
    private ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        password = MD5Util.getHash(password);
        String email = request.getParameter("Email");
        String phone = request.getParameter("Phone");
        
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        
        
        UserDAO userDao = new UserDAOMap();
        
        if (userDao.exist(user)) {
            return new ModelAndView(new RedirectView("ErrorPage"));
        } else {
            userDao.create(user);
            return new ModelAndView(new RedirectView("LoginPage"));
        }
        
        //return null;
    }
}
