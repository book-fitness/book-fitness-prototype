package ru.tiger.bookprototype.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.tiger.bookprototype.globalService.LoginService;
import ru.tiger.bookprototype.globalService.LoginServiceImpl;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    
    private static List<String> ignoreFolders = Collections.unmodifiableList(
        new ArrayList<String>() {{
            add("/js");
            add("/css");
        }}
    );
    
    private static List<String> ignorePages = Collections.unmodifiableList(
        new ArrayList<String>() {{
            add("/LoginPage.htm");
            add("/RegistrationPage.htm");
        }}
    );
    
    public LoginFilter() {
    }    
    
     /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        LoginService loginService = new LoginServiceImpl(((HttpServletRequest) request).getSession(false));
        String path = ((HttpServletRequest) request).getServletPath();
        
        if (!isIgnoredPath(path) && !loginService.isLogged()) {
            request.getServletContext().getRequestDispatcher("/LoginPage.htm").forward(request, response);
            //((HttpServletResponse) response).sendRedirect("LoginPage");
            return;
        }
        
        
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

    }
    
    private boolean isIgnoredPath(String path) {
        if (ignorePages.contains(path)) {
            return true;
        }
        
        for (String folder : ignoreFolders) {
            if (path.startsWith(folder)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
