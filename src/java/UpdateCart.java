/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import java.sql.*;
import java.sql.DriverManager;
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
public class UpdateCart extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        int userid=(int)session.getAttribute("Id");
        String update=request.getParameter("incre");
        int quantity=Integer.parseInt(request.getParameter("quant"));
        int productid=Integer.parseInt(request.getParameter("id"));
        int cartid=(userid*1000)+productid;
                // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            
            Connection conn=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement stmt=conn.createStatement();
            if(update.equals("true")){
                String Upgrade="update cart set quantity=quantity+1 where cartid="+cartid;
                stmt.executeUpdate(Upgrade);
                
            }
            else if(update.equals("false")){
                if(quantity>1){
                     String Upgrade="update cart set quantity=quantity-1 where cartid="+cartid;
                     stmt.executeUpdate(Upgrade);
                }
                else{
                     String Upgrade="delete from cart where cartid="+cartid;
                    stmt.executeUpdate(Upgrade);
                }
            }
            response.sendRedirect("cart.jsp");
            stmt.close();
            conn.close();
            
            
        }
        catch(Exception e){
            
        }
       
    }

   
}
