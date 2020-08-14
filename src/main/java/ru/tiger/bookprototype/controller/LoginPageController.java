package ru.tiger.bookprototype.controller;
/*
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
import ru.tiger.bookprototype.db.MD5Util;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;
import ru.tiger.bookprototype.service.impl.LoginServiceImpl;
import ru.tiger.bookprototype.repository.UserRepository;

@Deprecated
public class LoginPageController implements Controller {
    
    private UserRepository userRepo;

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
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

        User user = userRepo.findByUsername(login);

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
*/