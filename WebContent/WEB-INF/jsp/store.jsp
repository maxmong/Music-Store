<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">    
    </jsp:attribute>
    <jsp:attribute name="footer">  
    </jsp:attribute>
    <jsp:body>
      <ul>
      <c:forEach var="genreMsg" items="${genreMsg }">
       <li><a href="Store/Browse/${genreMsg.genreId }">${genreMsg.name}</a></li>
      </c:forEach>
      </ul>

      
     
      
        <ul>
      <c:forEach var="browse_album" items="${browse_album }">
       <li><a href="#">${browse_album.title}</a></li>
      </c:forEach>
      </ul>
      
      <ul>
      <c:forEach var="sort_by_genre" items="${sort_by_genre }">
       <li><a href="../Details/${sort_by_genre.albumId}">${sort_by_genre.title}</a></li>
      </c:forEach>
      </ul>
    </jsp:body>
</t:genericpage>