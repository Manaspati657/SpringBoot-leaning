<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person List</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">



<c:choose>
 <c:when test="${!empty jsList }">
 <table class="table table-striped table-dark table-dark table-hover" >
 
    <tr>
      <th>Employee no</th>
      <th>Employee name</th>
      <th>job</th>
      <th>salary</th>
      <th>operations</th>
    </tr>
    
    <c:forEach var="info" items="${ jsList }">
    <tr>
      <td>${info.jsId}</td>
      <td>${info.jsName}</td>
      <td>${info.jsAddrs}</td>
      <td>
        <a href="download?jsId=${info.jsId}&type=resume">download ${info.resumePath }</a>
      </td>
      <td>
        <a href="download?jsId=${info.jsId}&type=photo">download ${info.photoPath }</a>
      </td>
   
    </tr>
    </c:forEach>
 </table>
 </c:when>
 <c:otherwise>
     <h1 style="color:black;text-align:center;">Records not found</h1>
 </c:otherwise>
</c:choose>

<br><br>
  <h1 style="color:red;text-align:center;"><a href="./"> Home</a></h1>
 



</div>

</body>
</html>