package ru.tiger.bookprototype.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Tiger
 */

//@WebFilter(urlPatterns = "/*")
public class LocalhostStaticFilesFilter implements Filter {

    // Set here root path for your static files folder in your IDE.
    // Usually it is the resources folder.
    private final static String STATIC_FILES_PATH = "";
    private final static String[] STATIC_FILES_EXT = {".js", ".css", ".html"};

    //private final static boolean DEBUG = true;
    private final static boolean DEBUG = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (DEBUG) {
            System.out.println("<<<< LocalhostStaticFilesFilter init()");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (DEBUG) {
            System.out.println("<<<< LocalhostStaticFilesFilter doFilter");

        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String name = httpRequest.getServletPath();
        int index = name.indexOf('?');
        if (index != -1) {
            name = name.substring(0, index);
        }
        Path path = Paths.get(STATIC_FILES_PATH + name);

        if (!isLocalhost(request) || !isStaticFile(name) || !Files.exists(path)) {
            chain.doFilter(request, response);
            return;
        }

        if (DEBUG) {
            System.out.println("<<<< Name: " + name);
            System.out.println("<<<< Path: " + path);
        }

        response.setContentType(getContextType(name));
        PrintWriter pw = response.getWriter();
        Files.readAllLines(path).stream().forEach(pw::println);
    }

    boolean isLocalhost(ServletRequest request) {
        //return Config.getConfig().isLocalhostServer();
        return request.getServerName().equals("localhost");
    }

    boolean isStaticFile(String name) {
        for (String ext : STATIC_FILES_EXT) {
            if (name.endsWith(ext)) return true;
        }

        return false;
    }

    String getContextType(String name) {
        if (name.endsWith(".js")) {
            return "application/javascript";
        } else if (name.endsWith(".css")) {
            return "text/css";
        } else if (name.endsWith(".html")) {
            return "text/html";
        }

        return "text/plain";
    }

    @Override
    public void destroy() {
        if (DEBUG) {
            System.out.println("<<<< LocalhostStaticFilesFilter destroy()");
        }
    }
}
