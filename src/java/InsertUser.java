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

/**
 *
 * @author sujit sahu
 */
public class InsertUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("useremail");
        String password = request.getParameter("userpassword");
        String phone = request.getParameter("phone");
        String confirmpass = request.getParameter("confirmPassword");

        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        String message = "";

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InsertUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (password.equals(confirmpass)) {
                // Establish database connection
                Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            // Prepare SQL query
                String query = "INSERT INTO user (name, email, password,phone) VALUES (?, ?, ?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setString(4, phone);
                // Execute the query
                int rowsInserted = pstmt.executeUpdate();
                message += "<div class='toast align-items-center text-bg-danger border-0' role='alert' aria-live='assertive' aria-atomic='true' style='opacity:1;'>\n"
                        + "  <div class='d-flex bg-success m-2'>\n"
                        + "    <div class='toast-body text-light'>\n"
                        + " Register Succesfully"
                        + "    </div>\n"
                        + "    <button type='button' class='btn-close btn-close-white me-2 m-auto' data-bs-dismiss='toast' aria-label='Close'></button>\n"
                        + "  </div>\n"
                        + "</div>";

                if (rowsInserted > 0) {
                    System.out.println("Data saved successfully!");
                } else {
                    System.out.println("Failed to save data!");
                }
                pstmt.close();
                conn.close();

            } 
            else {
                 message += "<div class='toast align-items-center text-bg-danger border-0' role='alert' aria-live='assertive' aria-atomic='true' style='opacity:1;'>\n"
                        + "  <div class='d-flex bg-warning m-2'>\n"
                        + "    <div class='toast-body text-light'>\n"
                        + " Password & confirm Password are not Same"
                        + "    </div>\n"
                        + "    <button type='button' class='btn-close btn-close-white me-2 m-auto' data-bs-dismiss='toast' aria-label='Close'></button>\n"
                        + "  </div>\n"
                        + "</div>";

            }

            request.setAttribute("data", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.forward(request, response);

            // Close database connection
            

            // Redirect back to the form page
            response.sendRedirect("Register.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
