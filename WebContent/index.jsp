<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">    
    </jsp:attribute>
    <jsp:attribute name="footer">  
    </jsp:attribute>
    <jsp:body>
          <pre>
    <a href="hello">Say Hello</a>
  
    <a href="hello.html">Say Hello.html</a>
  
    <a href="Store.html">Store Table html</a>
    <a href="Store">Store Table</a>
    
    <a href="Store/Browse">Browse Page</a>
    <a href="Store/Browse/Jazz">Browse JAZZ Page</a>
    
    <a href="Store/Details">Store Details</a>
    <a href="Store/Details/5">Store 5 Details</a>
    
    <a href="login">Register a new account</a>
    
    <a href="w_basket">testing the w_basket</a>
    
    <a href="testTag">Test jsp tags</a>
    
    <a href="addSeeds">Add seeds</a>
    <a href="resetSeeds">Reset seeds</a>
    </pre>
    </jsp:body>
</t:genericpage>