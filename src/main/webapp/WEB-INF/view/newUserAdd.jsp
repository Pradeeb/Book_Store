 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>Products</title>
   </head>
<body>
 <section>
         <div class="jumbotron">
            <div class="container">
               <h1>Book Store</h1>
               <p>Add User</p>
            </div>
            <a href="<c:url value="/logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
         </div>
      </section>
      <section class="container">
         <form:form action="/BookStore/adduser" modelAttribute="newUser" class="form-horizontal">
            <fieldset>
               <legend>Add new User</legend>
               
               <div class="form-group">
                  <label class="control-label col-lg-2 col-lg-2" for="productId">Name</label>
                  <div class="col-lg-10">
                     <form:input id="name" path="name" type="text" class="form:input-large"/>
                  </div>
               </div>
               
               <div class="form-group">
                  <label class="control-label col-lg-2" for="description">User name</label>
                  <div class="col-lg-10">
                    <form:input id="username" path="username" type="text"/>
                  </div>
               </div>
                   
                <div class="form-group">
                  <label class="control-label col-lg-2 col-lg-2" for="productId">Password</label>
                  <div class="col-lg-10">
                     <form:input id="password" path="password" type="password" class="form:input-large"/>
                  </div>
               </div>
               
                <div class="form-group">
                  <label class="control-label col-lg-2 col-lg-2" for="productId">Category</label>
                  <div class="col-lg-10">
                     <form:input id="category" path="Category" type="text" class="form:input-large"/>
                  </div>
               </div>
               
                <div class="form-group">
                  <label class="control-label col-lg-2 col-lg-2" for="productId">Address</label>
                  <div class="col-lg-10">
                     <form:textarea id="address" path="address"  class="form:input-large"/>
                  </div>
               </div>
               
                <div class="form-group">
                  <label class="control-label col-lg-2 col-lg-2" for="productId">Total Orders</label>
                  <div class="col-lg-10">
                     <form:input id="noOfOrdersMade" path="noOfOrdersMade" type="text" class="form:input-large"/>
                  </div>
               </div>
               <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-10">
                     <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                  </div>
               </div>
            </fieldset>
         </form:form>
      </section>

</body>
</html>