package ru.tiger.bookprototype.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tiger.bookprototype.dao.UserDAO;
import ru.tiger.bookprototype.dao.UserDAOMap;
import ru.tiger.bookprototype.db.MD5Util;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.globalService.LoginService;
import ru.tiger.bookprototype.globalService.LoginServiceImpl;

/**
 *
 * @author Игорь
 */
@WebServlet(name = "LoginPage", urlPatterns = {"/LoginPage"})
public class LoginPage extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getServletContext().getRequestDispatcher("/view/LoginPageView.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");
        password = MD5Util.getHash(password);
        
        UserDAO userDao = new UserDAOMap();
        User user = userDao.findByLogin(login);
        
        if (user == null) {
            response.sendRedirect("RegistrationPage");
        } else {
            LoginService loginService = new LoginServiceImpl(request.getSession());
            if (loginService.checkPassword(password, user)) {
                loginService.login(user);
                response.sendRedirect("MainPage.htm");
            } else {
                response.sendRedirect("LoginPage");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
