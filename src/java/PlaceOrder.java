/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Random;
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
public class PlaceOrder extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        int userid=(int) session.getAttribute("Id");
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        String order="insert into orders values ";
        String delcart="delete from cart where userid="+userid; 
        
        Random rm=new Random();
        int orderid=rm.nextInt(10000);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Connection conn=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            String query="SELECT name,quantity,price FROM cart INNER JOIN product ON cart.productid=product.id WHERE userid="+userid;
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                order+="("+orderid+","+userid+",'"+rs.getString(1)+"',"+rs.getInt(2)+","+rs.getInt(3)+"), ";
                
            }
            String orderquery=order.substring(0,(order.length()-2));
            
            out.print(orderquery);
            stmt.executeUpdate(orderquery);
            stmt.executeUpdate(delcart);
            stmt.close();
            conn.close();        
            response.sendRedirect("Orders.jsp");
            
        }
        catch(Exception e){
           
        }
       
    }

    
}
