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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.CartProduct;


/**
 *
 * @author sujit sahu
 */
public class CartDao {

    private List<CartProduct> cartProducts;
    private HttpSession session;

    public CartDao(HttpSession session) {
        
        cartProducts = new ArrayList<>();
        String dbURL = "jdbc:mysql://localhost:3306/mall";
        String dbUsername = "root";
        String dbPassword = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer id = (Integer) session.getAttribute("Id");
        try (Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
            String query = "SELECT id,name,quantity,price,image FROM cart INNER JOIN product ON cart.productid=product.id WHERE userid="+id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String prodname = resultSet.getString("name");
                int quant=resultSet.getInt("quantity");
                int price = resultSet.getInt("price");
                String image = resultSet.getString("image");

                CartProduct cartproduct = new CartProduct(Id,prodname,quant,price, image);
                cartProducts.add(cartproduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<CartProduct> getAllProducts() {
        return cartProducts;
    }

}
