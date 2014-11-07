<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">    
    </jsp:attribute>
    <jsp:attribute name="footer">  
    </jsp:attribute>
    <jsp:body>
      <h2>Create</h2>Album<br>
      <form:form method="POST" commandName="albumCmd">
      
         <table>
          <tr>
           <td>UserName : </td>
           <td><form:input path="userName" /></td>
          
          </tr>
          <tr>
            <td>Genre : </td>
                <form:select path="genre">
	            <form:option value="NONE" label="--- Select ---" />
	            <form:options items="" />
                </form:select>
            </tr>
                  </table>
      </form:form>
       
 <a href="../../StoreManager/Edit/">Edit</a> | <a href="/Test_spring/StoreManager">Back to List</a>
    </jsp:body>
</t:genericpage>