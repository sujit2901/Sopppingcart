/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sujit sahu
 */
public class UserLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("useremail");
        String password = request.getParameter("userpassword");
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        String message = "";
        String query = "select * from user where email='" + email + "' and password='" + password + "'";
        

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InsertUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            PrintWriter out = response.getWriter();
            out.println(query);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                
                    HttpSession session = request.getSession();
                    session.setAttribute("Id", rs.getInt(1));
                    session.setAttribute("name", rs.getString(2));
                    session.setAttribute("email", rs.getString(3));
                    session.setAttribute("phone", rs.getString(5));
                    response.sendRedirect("Profile.jsp");
             

            } else {
                message += "<div class='toast align-items-center text-bg-danger border-0' role='alert' aria-live='assertive' aria-atomic='true' style='opacity:1;'>\n"
                        + "  <div class='d-flex bg-warning m-2'>\n"
                        + "    <div class='toast-body text-light'>\n"
                        + " Invalid credentials"
                        + "    </div>\n"
                        + "    <button type='button' class='btn-close btn-close-white me-2 m-auto' data-bs-dismiss='toast' aria-label='Close'></button>\n"
                        + "  </div>\n"
                        + "</div>";
                request.setAttribute("data", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            message += "<div class='toast align-items-center text-bg-danger border-0' role='alert' aria-live='assertive' aria-atomic='true' style='opacity:1;'>\n"
                    + "  <div class='d-flex bg-warning m-2'>\n"
                    + "    <div class='toast-body text-light'>\n"
                    + query
                    + "    </div>\n"
                    + "    <button type='button' class='btn-close btn-close-white me-2 m-auto' data-bs-dismiss='toast' aria-label='Close'></button>\n"
                    + "  </div>\n"
                    + "</div>";
            request.setAttribute("data", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
