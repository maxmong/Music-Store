<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     Browse the genres<br>
     
     
     message: ${message} <br>
     <ul>
      <c:forEach var="message" items="${message }">
       <li><a href="Store/Browse/${message }">${message}</a></li>
      </c:forEach>
      </ul>
</body>
</html>