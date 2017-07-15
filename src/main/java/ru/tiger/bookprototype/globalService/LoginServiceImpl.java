package ru.tiger.bookprototype.globalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) return false;
        
        Object user = httpSession.getAttribute("user");
        if (user == null) return false;
        
        return true;
    }
}
