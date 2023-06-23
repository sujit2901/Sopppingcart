<%-- 
    Document   : cart
    Created on : May 24, 2023, 4:00:19 PM
    Author     : sujit sahu
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.List, javax.servlet.http.HttpSession, Dao.CartDao, model.CartProduct"%>
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
            <div class="card mb-3 secondary">
                <h3 class="card-title text-center py-3"> Your Cart</h3>
                <%
                    // Create an instance of ProductDAO
                   
                    CartDao cartDAO = new CartDao(session);

                    // Retrieve all products
                    List<CartProduct> products = cartDAO.getAllProducts();
                    int total=0;
                %>
                 <% for (CartProduct product : products) {
                     total+=(product.getQuantity()*product.getPrice());
                 %>
                <div class="c-center">
                    <div class="card mb-3 p-2" style="width: 540px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="<%= product.getImage()%>" class="img-fluid rounded-start" style="width:10rem;" alt="...">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title"><%= product.getName()%></h5>
                                    <p class="card-text">Price:  <%= product.getPrice()%>
                                        <br />
                                        Quantity :
                                        <a href="UpdateCart?incre=false&quant=<%= product.getQuantity()%>&id=<%= product.getId()%>" class="t-decor">
                                           <i class="fa-solid fa-minus" style="color:#ff5a4c;"></i>
                                        </a>
                                        <input class="p-1 text-center" style="width:40px!important" type="number" aria-disabled="true" value="<%= product.getQuantity()%>"/> 
                                        <a href="UpdateCart?incre=true&quant=<%= product.getQuantity()%>&id=<%= product.getId()%>" class="t-decor"><i class="fa-solid fa-plus" style="color:#ff5a4c;"></i></a></p>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 <% }%>




                <div class="row"> 
                    <div class="col-sm-6">
                        <h3 class="card-title text-center py-3"> Total Cart Value:</h3>
                    </div>
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4">
                        <h3 Id="totalsum" runat="server" class="card-title primary text-center py-3"> &#x20b9;<%= total%></h3>
                    </div>
                </div>
                <div class="row"> 
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6 py-3">
                        <button class="btn primary px-3 py-3 w-100">
                            <b class="text-light"><a href="PlaceOrder" class="t-decor" style="color:#fff">CheckOut The Cart </a><i class="fa-solid fa-cart-shopping fa-xl" style="color:#fff;"></i> </b>
                        </button>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>