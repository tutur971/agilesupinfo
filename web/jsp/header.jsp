<%-- 
    Document   : header
    Created on : 5 déc. 2014, 11:34:36
    Author     : Gaetan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
     
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <%  if(session.getAttribute("sessionUtilistaeur") != null ) { %> 
          <form action="logout" method="post">
            <div class="form-group">
              <input type="text" placeholder="Search" class="form-control2">
            </div>
            <button type="submit" class="btn btn-success">Log Out</button>
         </form>
        <a href="" > Logout </a>
            
        <% }else { %>
          <form class="navbar-form navbar-right" role="form" action="authentification" method="post">
             <div class="form-group">
              <input type="text" placeholder="Search" class="form-control2">
            </div>
            <button type="submit" class="btn btn-success">Search</button>
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
         <% } %>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
        
    </body>
</html>
