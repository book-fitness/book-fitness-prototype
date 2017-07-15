package ru.tiger.bookprototype.globalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    public boolean checkLogin(HttpServletRequest request, HttpServletResponse response);
}
