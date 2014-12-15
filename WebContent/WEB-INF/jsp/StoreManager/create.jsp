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
      <h2>Create</h2>Album
      
  <form:form role="form" action="../StoreManager/Create" method="POST">
  <div class="form-group">
    <form:label path="" for="exampleInputEmail1">Genre</form:label>
    <form:select path="genreId" >
   <form:options items="${model.genreMap}" />
   </form:select>
      
  </div>
  <div class="form-group">
    <form:label path="" for="exampleInputPassword1">Artist</form:label>
    <form:select path="artistId" >
    <form:options items="${model.artistMap}" />
    </form:select>
  </div>
    <div class="form-group">
    <form:label path="title">Title</form:label>
    <form:input path="title" type="text"/>
    <form:errors path="title" cssClass="error"/>
  </div>
 
    <div class="form-group">
    <form:label path="price" for="exampleInputPassword1">Price</form:label>
    <form:input path="price" type="text" class="form-control" id="" value=""/>
  </div>
      <div class="form-group">
    <form:label path="albumArtUrl" for="exampleInputPassword1">Album Art Url</form:label>>
    <form:input path="albumArtUrl" type="text" class="form-control" id="" value=""/>
  </div>

  <button type="submit" class="btn btn-default">Save</button>
</form:form>
 <a href="/StoreManager">Back to List</a>
    </jsp:body>
</t:genericpage>