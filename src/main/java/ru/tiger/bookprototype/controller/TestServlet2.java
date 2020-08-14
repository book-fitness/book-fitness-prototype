package ru.tiger.bookprototype.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "TestServlet2", urlPatterns = {"/TestServlet2"})
public class TestServlet2 extends HttpServlet {

    @Resource(name = "ExampleDS")
    private DataSource dataSource;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //InitialContext context = new InitialContext();
            //DataSource dataSource = (DataSource) context.lookup("java:jboss/datasources/ExampleDS");
            System.out.println("==== DATA SOURCE: " + dataSource);
            printObjectList(dataSource.getConnection("", ""), out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void printObjectList(Connection con, PrintWriter out) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT id FROM book");
            ResultSet resultSet = statement.executeQuery();
            out.println("<ul>");
            while (resultSet.next()) {
                out.print("<li>");
                out.print(resultSet.getLong("id"));
                out.println("<li>");
            }
            out.println("</ul>");
            
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TestServlet2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
