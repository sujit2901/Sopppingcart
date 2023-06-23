/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.CartProduct;
import model.Orders;

/**
 *
 * @author sujit sahu
 */
public class OrdersDao {

    private List<Orders> ProdOrders;
    private HttpSession session;

    public OrdersDao(HttpSession session) {
        ProdOrders = new ArrayList<>();
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer id = (Integer) session.getAttribute("Id");
        try (Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            String query = "SELECT DISTINCT orderid FROM orders where userid=" + id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                int orderid = resultSet.getInt("orderid");
                List<CartProduct> cartproductsvalue=new ArrayList<>();
                String selquery = "SELECT * FROM orders where userid=" + id + " and orderid=" + orderid;
                PreparedStatement stm = connection.prepareStatement(selquery);
                ResultSet rs = stm.executeQuery();
                System.out.println(orderid);
                while (rs.next()) {
                    String name = rs.getString("productname");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    System.out.println(name+" "+quantity+" "+price);
                    cartproductsvalue.add(new CartProduct(0, name, price,quantity, ""));
                }

                
                ProdOrders.add(new Orders(orderid,cartproductsvalue));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Orders> getAllOrders() {
        return ProdOrders;
    }
    
    

}
