<%-- 
    Document   : header
    Created on : May 22, 2023, 3:00:16 PM
    Author     : sujit sahu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Loc-Off-Mall</title>   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    
    <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>
        <nav class="navbar secondary-alt p-4 navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="assets/images/logo.PNG" style="width:5rem;"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse px-5" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item mx-2">
              <a class="nav-link active px-4 py-2" aria-current="page" href="index.jsp">Home</a>
            </li>
            <li class="nav-item mx-2">
              <a class="nav-link px-4 py-2" href="#">Shop By Category</a>
            </li>
              <li class="nav-item mx-2">
              <a class="nav-link px-4 py-2" href="Orders.jsp">My Orders</a>
            </li>
            
            
          </ul>
          <div class="d-flex" role="search">
            
              <a href="cart.jsp" class="t-decor"><button class="btn btn-outline-success bg-light secondary-alt p-3" type="submit" style="background-color:#fff!important;border-radius:50%;border:1px solid #ec406c;"><i class="fa-solid fa-cart-shopping fa-bounce fa-xl" style="color:#ec406c;background-color:#fff;" ></i></button></a> &nbsp;&nbsp;
              &nbsp;&nbsp;
             <a href="Profile.jsp" class="t-decor"><button class="btn btn-outline-success bg-light secondary-alt p-3" style="background-color:#fff!important;border-radius:50%;border:1px solid #ec406c;"><i class="fa-solid fa-user fa-flip fa-xl" style="color:#ec406c;background-color:#fff;" ></i></button></a>
          </div>
        </div>
      </div>
    </nav>
    
