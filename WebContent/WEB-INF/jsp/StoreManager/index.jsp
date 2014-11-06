<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">    
    </jsp:attribute>
    <jsp:attribute name="footer">  
    </jsp:attribute>
    <jsp:body>
     
 
   
      <h2>Index</h2>
      <table class="table table-hover">
        
         <tr>
             <th>Genre</th>
             <th>Artist</th>
             <th>Title</th>
             <th>Price</th>
             <th></th>
         </tr>
         <tbody>
           <c:forEach var="album" items="${model.albumList}" varStatus="status">
              <tr>
                 <td> 
                     <a href="Store/Browse/${album.genreId}">${album.genre.name}</a>
<%--                      index:<c:out value="${status.index}"></c:out><br/> --%>
<%--                      count:<c:out value="${status['count']}"></c:out><br/> --%>
<%--                      first:<c:out value="${status['first']}"></c:out><br/> --%>
<%--                      last:<c:out value="${status['last']}"></c:out><br/> --%>
                 </td>
                 <td><a href=""></a>${album.artist.name}</td>
                 <td><a href="Store/Details/${album.albumId}">${album.title }</a></td>
                 <td>${album.price}</td>
                 <td>
                 <a href="StoreManager/Edit/${album.albumId }">Edit</a>
                 <a href="StoreManager/Details/${album.albumId }">Details</a>
                 <a href="StoreManager/Delete/${album.albumId }">Delete</a>
                  
                 </td>
              </tr>
             
           </c:forEach>
           </tbody>
      </table>
      ${msg }
       
 </jsp:body>
 </t:genericpage>