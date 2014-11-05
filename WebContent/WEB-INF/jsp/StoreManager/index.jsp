<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
      <h2>Index</h2>
      <table>
        
         <tr>
             <th>Genre</th>
             <th>Artist</th>
             <th>Title</th>
             <th>Price</th>
             <th></th>
         </tr>
       
           <c:forEach var="album" items="${model.albumList}">
              <tr>
                 <td> 
                     ${album.genreId}
                 </td>
                 <td>${album.artistId}</td>
                 <td>${album.title }</td>
                 <td>${album.price }</td>
                 <td>
                 <a href="StoreManager/Create">Create</a>
                 <a href="StoreManager/Details">Details</a>
                 <a href="StoreManager/Delete">Delete</a>
                  
                 </td>
              </tr>
             
           </c:forEach>
      </table>
       
     
 
</body>
</html>