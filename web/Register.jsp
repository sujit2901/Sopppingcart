<%-- 
    Document   : Register
    Created on : May 21, 2023, 4:17:54 PM
    Author     : sujit sahu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Register Page</title>
    </head>
    <body class="primary-alt" >
 ${data}

        <div>
            <div class="u-center">
                <div class="card mb-3 secondary" style="max-width: 900px;">
                    <div class="row g-0">
                        <div class="col-md-6">
                            <img src="assets/images/register_img.jpg"
                                 style="border-radius:20px;height:100%" class="img-fluid" alt="...">
                        </div>
                        <div class="col-md-6 p-3">
                            <div class="card-body">
                                <h5 class="card-title">USER SIGN UP</h5>
                                <form action="InsertUser" method="post">
                                    <label for="name" class="form-label">Name:</label>
                                    <br />
                                    <input class="form-control" type="text" id="name" name="name" required>
                                    <br />
                                    <label for="exampleFormControlInput1" class="form-label"
                                           for="name">Email:</label>
                                    <br>
                                    <input class="form-control" type="email" id="useremail" name="useremail" required>
                                    <br>
                                    <label for="phone" class="form-label">Phone:</label>
                                    <br />
                                    <input type="number" class="form-control" id="phone" name="phone" required>
                                    <br />
                                    <label for="exampleFormControlInput1" class="form-label"
                                           for="name">Password:</label>
                                    <br>
                                    <input class="form-control" type="password"
                                                 id="userpassword" name="userpassword" required>
                                    <br>
                                    <label for="exampleFormControlInput1" class="form-label"
                                           for="cpassword">Confirm Password:</label>
                                    <br>
                                    <input class="form-control" type="password"
                                           id="confirmPassword" name="confirmPassword" required>
                                    <br>
                                    <button id="userregister" type="submit"
                                            class="btn primary px-3 py-2 w-100">Sign Up </button>
                                    <br>
                                    <br>
                                    Already have an account? <a class="t-decor"
                                                                href="Login.jsp">Login</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
