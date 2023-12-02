<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1" %>
 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  
  <h1 style="color:red;text-align:center">Student registration page</h1>
  
  
  <form:form modelAttribute="stud" method="post">
  
  <table align="center" bgcolor="cyan">
     <tr>
       <td>Student number</td>
       <td>
         <form:input path="sno" />
       </td>
     </tr>
     <tr>
       <td>Student name</td>
       <td>
         <form:input path="sname" />
       </td>
     </tr>
     <tr>
       <td>Student address</td>
       <td>
         <form:input path="sadd" />
       </td>
     </tr>
     <tr>
       <td>Student avg</td>
       <td>
         <form:input path="avg" />
       </td>
     </tr>
    <tr>
       <td colspan="2"><input type="submit" value="register"></td>
     </tr>
  </table>
  
  </form:form>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  