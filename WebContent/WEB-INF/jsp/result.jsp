<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table>
      <tr>
          <th>
             Genre ID
          </th>
          <td>
           ${genreId }
          </td>
      </tr>
      <tr>
         <td>Artist Id</td>
         <td>${artistId }</td>
      </tr>
       <tr>
         <td>Title:</td>
         <td>${title }</td>
      </tr>
       <tr>
         <td>Price</td>
         <td>${price }</td>
      </tr>
       <tr>
         <td>Album Art Url</td>
         <td>${albumArtUrl }</td>
      </tr>
    </table>
</body>
</html>