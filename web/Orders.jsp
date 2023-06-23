<%-- 
    Document   : Orders
    Created on : May 25, 2023, 6:14:17 PM
    Author     : sujit sahu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import= "java.util.List, javax.servlet.http.HttpSession, Dao.OrdersDao, model.Orders,model.CartProduct"%>
<%@include file="header.jsp" %>
<%
    // Retrieve the session object

    Integer id = (Integer) session.getAttribute("Id");
    if (id == null) {
        response.sendRedirect("Login.jsp");
    } else {

        // Use the value as needed
    }
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6 py-3">
            <div class="card mb-3 pb-5 secondary">
                <h3 class="card-title text-center py-3"> Your Orders</h3>
                <%
                    // Create an instance of ProductDAO
                    OrdersDao cartDAO = new OrdersDao(session);

                    // Retrieve all products
                    List<Orders> products = cartDAO.getAllOrders();
                    int total = 0;

                %>
                <% for (Orders order : products) {
                    int prodtotal=0;
                %>
                <div class="c-center">
                    <div class="card my-2" style="width:80%">
                        <div class="card-header">
                            order Id: <%=order.getOrderId()%>
                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Product Name</th>
                                        <th scope="col">Qty</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Sub Total</th>
                                    </tr>
                                </thead>
                                <tbody class="table-group-divider">
                            <%
                                List<CartProduct> items = order.getProducts();

                                for (CartProduct item : items) {

                                    prodtotal+=item.getQuantity()*item.getPrice();
                            %>
                            
                                    <tr>
                                        <th scope="row"><%= item.getName()%></th>
                                        <td><%= item.getQuantity() %></td>
                                        <td><%= item.getPrice()%></td>
                                        <td><%= item.getQuantity()*item.getPrice() %></td>
                                    </tr>
                                    
                                

                            
                            <% }%>
                            </tbody>
                            </table>
                            <a href="" class="btn primary">Total : <%= prodtotal %></a>
                        </div>
                    </div>
                </div>
                <% }%>





            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
