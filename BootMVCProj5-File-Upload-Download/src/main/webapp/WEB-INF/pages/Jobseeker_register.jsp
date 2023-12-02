<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>


  <h1 style="color:red;text-align:center">Register Person</h1>
  
  
  <form:form modelAttribute="js" enctype="multipart/form-data" >
  
  <table align="center" bgcolor="cyan">
     <tr>
       <td>Name ::</td>
       <td>
         <form:input path="jsName" />
       </td>
     </tr>
     <tr>
       <td>Address::</td>
       <td>
         <form:input path="jsAddrs" />
       </td>
     </tr>
     <tr>
       <td>select resume::</td>
       <td>
         <form:input type="file" path="resume" />
       </td>
     </tr>
     <tr>
       <td>select photo::</td>
       <td>
         <form:input type="file" path="photo" />
       </td>
     </tr>
   
    <tr>
       <td colspan="2"><input type="submit" value="register"></td>
     </tr>
  </table>
  
  </form:form>

</body>
</html>