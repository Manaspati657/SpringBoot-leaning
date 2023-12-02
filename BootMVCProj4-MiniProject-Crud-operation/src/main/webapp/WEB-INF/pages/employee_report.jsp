<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">


<c:if test="${!empty resultMsg }">

   <h3 style="color:green;text-align:center">${resultMsg}</h3>
</c:if>


<c:choose>
 <c:when test="${!empty empsData }">
 <table class="table table-striped table-dark table-dark table-hover" >
 
    <tr>
      <th>Employee no</th>
      <th>Employee name</th>
      <th>job</th>
      <th>salary</th>
      <th>operations</th>
    </tr>
    
    <c:forEach var="emp" items="${ empsData }">
    <tr>
      <td>${emp.empno}</td>
      <td>${emp.ename}</td>
      <td>${emp.job}</td>
      <td>${emp.sal}</td>
      <td>
         <a href="edit?no=${emp.empno }">
           <img style="
           height: 26px;
           width: 26px;
    		cursor: pointer;
    		margin: 5px;
   			 background: #e4caca;
  			  border-radius: 50%;
         " alt="edit image" src="images/edit.png">
         </a>
         <a onclick="return confirm(' Do you want to delete !!!')" href="delete?no=${emp.empno }">
           <img style="
            height: 26px;
           width: 26px;
    		cursor: pointer;
    		margin: 5px;
  			  border-radius: 50%;
            " alt="edit image" src="images/delete.png">
         </a>
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
  <h1 style="color:red;text-align:center;"><a href="add"> <img style="
            height: 26px;
           width: 26px;
    		cursor: pointer;
    		margin: 5px;
  			  border-radius: 50%;]
           " alt="add image" src="images/add.png"> Add Employeee</a></h1>
 



</div>

</body>
</html>