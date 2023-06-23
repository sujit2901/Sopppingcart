<%-- 
    Document   : index.jsp
    Created on : May 22, 2023, 2:58:29 PM
    Author     : sujit sahu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@ page import="model.Product, Dao.ProductDao, java.util.List" %>
 
<div class="container">
    <h5 class="p-4">View All Products</h5>
    <div class="row">
        
    
    <%
        // Create an instance of ProductDAO
        ProductDao productDAO = new ProductDao();

        // Retrieve all products
        List<Product> products = productDAO.getAllProducts();
       
    %>
    <% for (Product product : products) {%>
    <div class="col-sm-3 p-3 c-center">
        <div class="card product-card c-center p-2" style="height:30rem;wisth:25rem;border: 6px solid #045C7F;">
            <img src="<%= product.getImage()%>" class="card-img-top img-fluid" alt="...">
            <div class="card-body productcard-body">
                <h5 class="card-title"><%= product.getName()%></h5>
                <h5 class="card-title">Price: <span style="color:#ec406c"> &#8377; <%= product.getPrice()%></span></h5>
                <p class="card-text"><%= product.getDescription()%></p>
                <a href="AddCart?product_id=<%= product.getId()%>" class="btn btn-primary primary">Add To Cart <i class="fa-solid fa-cart-shopping" style="color:#fff"></i></a>
            </div>
        </div>
    </div>   
   
    <% }%>
    </div>
</div>





<%@include file="footer.jsp" %>