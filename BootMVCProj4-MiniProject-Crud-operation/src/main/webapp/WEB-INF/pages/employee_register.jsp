<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee register</title>
</head>
<body>

 
  <h1 style="color:red;text-align:center">Register Employee</h1>
  
  
  <form:form modelAttribute="emp" >
  
  <table align="center" bgcolor="cyan">
     <tr>
       <td>Employee name ::</td>
       <td>
         <form:input path="ename" />
         <form:errors cssStyle="color:red" path="ename"/>
       </td>
     </tr>
     <tr>
       <td>Employee desg::</td>
       <td>
         <form:input path="job" />
         <form:errors cssStyle="color:red" path="job"/>
       </td>
     </tr>
     <tr>
       <td>Employee salary::</td>
       <td>
         <form:input path="sal" />
         <form:errors cssStyle="color:red" path="sal"/>
       </td>
     </tr>
   
    <tr>
       <td colspan="2"><input type="submit" value="register Employee"></td>
     </tr>
  </table>
  
  </form:form>
  


</body>
</html>