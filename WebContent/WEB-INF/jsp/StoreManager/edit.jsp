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
      <h2>Edit</h2>Album
      
  <form role="form">
  <div class="form-group">
    <label for="exampleInputEmail1">Genre</label>
    <input type="email" class="form-control" id="" value="${model.albumEdit.genre.name}">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Artist</label>
    <input type="text" class="form-control" id="" value="${model.albumEdit.artist.name }">
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Title</label>
    <input type="text" class="form-control" id="" value="${model.albumEdit.title }">
  </div>
   </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="text" class="form-control" id="" value="${model.albumEdit.price }">
  </div>
      <div class="form-group">
    <label for="exampleInputPassword1">Album Art Url</label>
    <input type="text" class="form-control" id="" value="${model.albumEdit.albumArtUrl }">
  </div>

  <button type="submit" class="btn btn-default">Save</button>
</form>
 <a href="/StoreManager">Back to List</a>
    </jsp:body>
</t:genericpage>