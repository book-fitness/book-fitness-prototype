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

@Deprecated
public class RegistrationPageController implements Controller {
    
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
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
        user.setUsername(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        
        
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return new ModelAndView(new RedirectView("ErrorPage"));
        } else {
            userDAO.save(user);
            return new ModelAndView(new RedirectView("LoginPage"));
        }
        
        //return null;
    }
}
