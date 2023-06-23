<%-- 
    Document   : Profile
    Created on : May 24, 2023, 12:31:01 AM
    Author     : sujit sahu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="container-fluid">
  <%
    // Retrieve the session object
        String name="";
        String email ="";
        Long mobile= Long.parseLong("0");
    Integer id = (Integer) session.getAttribute("Id");
    if (id == null) {
        response.sendRedirect("Login.jsp");
    } else {
        name = (String) session.getAttribute("name");
        email = (String) session.getAttribute("email");
        String phone = (String) session.getAttribute("phone");
        phone = phone.replaceAll("[^0-9]", "");
        mobile = Long.parseLong(phone);

        // Use the value as needed
    }
%>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card card mb-3 secondary p-4 my-4">

                <form action="" method="post">
                    <label for="name" class="form-label">Name:</label>
                    <br />

                    <input type="text" class="form-control w-100" Id="Name" value="<%= name%>">

                    <br />
                    <label for="email" class="form-label">Email</label>
                    <br />
                    <input type="email" class="form-control w-100" Id="email" value="<%= email%>">

                    <br />
                    <label for="phone" class="form-label">Phone Number:</label>
                    <br />
                    <input type="number" class="form-control w-100" Id="phone" value="<%= mobile%>">

                    <br />
                    <label for="password" class="form-label">Change Password:</label>
                    <br />
                    <input type="password" class="form-control w-100" Id="password">

                    <br />
                    <div style="text-align: center;">
                        <button Id="update" type="submit" style="border-radius: 10px;" class="primary px-4 py-2">Update</button>
                        &nbsp;&nbsp;&nbsp;
                        <button style="border-radius: 10px;" Id="logout" class="primary px-4 py-2"><a href="Logout" class="text-decor text-light">Logout</a><button/>

                    </div>
                </form>

            </div>

        </div>

    </div>

</div>
<%@include file="footer.jsp" %>
