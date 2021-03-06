<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>

<link rel="stylesheet"
href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>

<section>
   <div class="jumbotron">
      <div class="container">
         <h1>Products</h1>
         <p>All the available products in our store</p>
             </div>
            <a href="<c:url value="/logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
         </div>
      </div>
   </div>
</section>
<section class="container">
   <div class="row">
      <c:forEach items="${productList}" var="product">
         <div class="col-sm-6 col-md-3" style="padding-bottom:15px">
            <div class="thumbnail">
               <div class="caption">
                  <img src="<c:url value="${product.image}"></c:url>" alt="image" style = "width:100%"/>
                  <h3>${product.name}</h3>
                  <p>${product.description}</p>
                  <p>$${product.unitPrice}</p>
                  <p>Available ${product.unitsInStock} units in stock</p>
               </div>
            </div>
         </div>
      </c:forEach>
   </div>
</section>


</body>
</html>