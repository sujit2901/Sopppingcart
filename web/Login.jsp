<%-- 
    Document   : Login
    Created on : May 21, 2023, 3:10:03 PM
    Author     : sujit sahu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">

        <title>Login Page</title>
    </head>
    <body class="primary-alt">
        <%
// Retrieve the session object
        Integer id = (Integer) session.getAttribute("Id");
        if (id != null) {
            response.sendRedirect("index.jsp");
        } 
            
        
// Use the value as needed
    %>
        ${data}

        <div>
            <div class="u-center">
                <div class="card mb-3 secondary" style="max-width: 800px;">
                    <div class="row g-0">
                        <div class="col-md-6">
                            <img src="assets/images/login_img.jpg"
                                 style="border-radius:20px;height:100%" class="img-fluid" alt="...">
                        </div>
                        <div class="col-md-6 p-3">
                            <div class="card-body">
                                <h5 class="card-title">USER LOGIN </h5>
                                <form action="UserLogin" method="post">
                                    <label for="exampleFormControlInput1" class="form-label"
                                           for="name">Email:</label>
                                    <br>
                                    <input class="form-control" type="email" id="useremail" name="useremail" required></asp:TextBox>
                                    <br>
                                    <label for="exampleFormControlInput1" class="form-label"
                                           for="name">Password:</label>
                                    <br>
                                    <input class="form-control" type="password" id="userpassword" name="userpassword"  required/>
                                    <br>
                                    <button id="userlogin" type="submit" class="btn primary px-3 py-2 w-100" >Login</button>
                                    <br>
                                    <br>
                                    Don't have an account? <a class="t-decor" href="Register.jsp">Sign
                                        Up</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    ></script>

</html>
