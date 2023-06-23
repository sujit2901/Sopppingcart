/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sujit sahu
 */
public class AddCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("Id");
        
        if (id == null) {
            response.sendRedirect("Login.jsp");
        } 
        else {
            int ProductId = Integer.parseInt(request.getParameter("product_id"));
            int cartid=(id*1000)+ProductId;
            String dbURL = "jdbc:mysql://localhost:3306/mall";
            String dbUsername = "root";
            String dbPassword = "";

            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCart.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                String query = "INSERT INTO cart (Cartid,userid,productid,quantity) VALUES ("+cartid+","+id+","+ProductId+",1)";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                response.sendRedirect("cart.jsp");

            } catch (Exception e) {
                 response.sendRedirect("cart.jsp");

            }
        }
    }
}
