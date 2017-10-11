package ru.tiger.bookprototype.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import ru.tiger.bookprototype.db.MD5Util;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.repository.UserRepository;

@Deprecated
public class RegistrationPageController implements Controller {
    
    private UserRepository userRepo;

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
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
        
        
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return new ModelAndView(new RedirectView("ErrorPage"));
        } else {
            userRepo.save(user);
            return new ModelAndView(new RedirectView("LoginPage"));
        }
        
        //return null;
    }
}
