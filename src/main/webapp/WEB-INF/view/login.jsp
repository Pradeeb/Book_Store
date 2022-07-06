<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
   <head>
     <meta charset="utf-8">
      <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
      <title>Products</title>
   </head>
   <body>
      <div class="jumbotron">
         <div class="container">
            <h1>Book Store</h1>
            <p>Buy your braine</p>
         </div>
      </div>
      </section>
      <div class="container">
         <div class="row">
            <div class="col-md-4 col-md-offset-4">
               <div class="panel panel-default">
                  <div class="panel-heading">
                     <h3 class="panel-title">Please sign in</h3>
                     <h4>
                     <c:if test="${param.error!=null}">
                       <p style="color: red">You entered wrong credentials!</p>
                     </c:if>
                     </h4>
                  </div>
                  <div class="panel-body">
                   
                      <form action='<c:url value="/BookStore/login"/>'  method="post" class="form-horizontal">
                        <fieldset>
                           <div class="form-group">
                              <input class="form-control" name="name"  placeholder="name" type="text"/>
                           </div>
                           <div class="form-group">
                              <input class="form-control" name="password" placeholder="password"  type="password" value=""/>
                           </div>
                           <input class="btn btn-lg btn-success btn-block"
                              type="submit" value="Login">
                        </fieldset>
                     </form>
                  </div>

               </div>
                <div>
                    <p>Add New User.. <a href="<c:url value="/BookStore/adduser"/>">click this link</a></p>
                  </div>
            </div>
         </div>
      </div>
   </body>
</html>

