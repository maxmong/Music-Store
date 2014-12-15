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
      <h2>Details</h2>Album<br>
      
    <ul>
    <li><label for="exampleInputEmail1">Genre</label>
    ${model.albumEdit.genre.name}</li>
  
    
    <li><label for="exampleInputPassword1">Artist</label>
    ${model.albumEdit.artist.name }</li>
  
  
    <li><label for="exampleInputPassword1">Title</label>
    ${model.albumEdit.title }</li>
  
    <li><label for="exampleInputPassword1">Price</label>
    ${model.albumEdit.price}</li>
      
    <li><label for="exampleInputPassword1">Album Art Url</label>
    ${model.albumEdit.albumArtUrl }
    </li>
    </ul>
    Are you sure you want to delete the album titled ${model.albumEdit.title }<br>
 <a href="../../StoreManager/Deleted/${model.albumEdit.albumId }">Delete</a> | <a href="/Test_spring/StoreManager">Back to List</a>
    </jsp:body>
</t:genericpage>