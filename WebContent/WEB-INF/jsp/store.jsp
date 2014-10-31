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
      <c:forEach var="message" items="${message }">
       <li><a href="Store/Browse/${message.genreId }">${message.name}</a></li>
      </c:forEach>
      </ul>
      ${genreMsg.title }
      
      <ul>
      <c:forEach var="sort_by_genre" items="${sort_by_genre }">
       <li><a href="Store/Browse/${sort_by_genre.title }">${sort_by_genre.title}</a></li>
      </c:forEach>
      </ul>
    </jsp:body>
</t:genericpage>