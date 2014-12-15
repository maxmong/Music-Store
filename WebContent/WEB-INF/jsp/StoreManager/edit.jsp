<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:attribute name="header">    
    </jsp:attribute>
    <jsp:attribute name="footer">  
    </jsp:attribute>
    <jsp:body>
      <h2>Edit</h2>Album
      
  <form:form role="form" action="../../StoreManager/editAlbum" method="POST">
  <form:hidden path="albumId" value="${model.albumEdit.albumId }"/>
  <div class="form-group">
    <form:label path="" for="exampleInputEmail1">Genre</form:label>
    <form:select path="genreId" >
   <form:option value="${model.albumEdit.genreId}" label="${model.albumEdit.genre.name }"/>
   <form:options items="${model.genreMap}" />
   </form:select>
      
  </div>
  <div class="form-group">
    <form:label path="" for="exampleInputPassword1">Artist</form:label>
    <form:select path="artistId" >
    <form:option value="${model.albumEdit.artistId}" label="${model.albumEdit.artist.name }"/>
    <form:options items="${model.artistMap}" />
    </form:select>
  </div>
    <div class="form-group">
    <form:label path="title" for="exampleInputPassword1">Title</form:label>
    <form:input path="title" type="text" class="form-control" value="${model.albumEdit.title }"/>
  </div>
 
      <div class="form-group">

      </div>                            



    <div class="form-group">
    <form:label path="price" for="exampleInputPassword1">Price</form:label>
    <form:input path="price" type="text" class="form-control" id="" value="${model.albumEdit.price }"/>
  </div>
      <div class="form-group">
    <form:label path="albumArtUrl" for="exampleInputPassword1">Album Art Url</form:label>>
    <form:input path="albumArtUrl" type="text" class="form-control" id="" value="${model.albumEdit.albumArtUrl }"/>
  </div>

  <button type="submit" class="btn btn-default">Save</button>
</form:form>
 <a href="/StoreManager">Back to List</a>
    </jsp:body>
</t:genericpage>