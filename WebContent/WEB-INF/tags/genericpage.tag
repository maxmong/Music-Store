<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
  <body>
    <div id="pageheader" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
      <jsp:invoke fragment="header"/>
      <h1>Welcome</h1>
    </div>
     <hr>
    <div id="body">
   
      <jsp:doBody/>
      
    </div>
    <hr>
    <div id="pagefooter">
   
      <jsp:invoke fragment="footer"/>
       <p id="copyright">Copyright 2014, Future Bits When There Be Bits Inc.</p>
    </div>
    <hr>
  </body>
</html>