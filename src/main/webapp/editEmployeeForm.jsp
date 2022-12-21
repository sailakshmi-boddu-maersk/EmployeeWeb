<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.slb.Employee"%>
<!DOCTYPE html>
<html>
<body>
<h2 align="center">Edit Employee Form</h2>
<form action="update">
<table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
 <tr>
 <td>Enter Id</td>
 <td><input type="text" name="id" value="${employee.id}"></td>
 </tr>
 <tr>
 <td>Enter First Name</td>
 <td><input type="text" name="firstName" value="${employee.firstName}"></td>
 </tr>
 <tr>
 <td>Enter Last Name</td>
 <td><input type="text" name="lastName" value="${employee.lastName}"></td>
 </tr>
 <tr>
 <td>Enter Salary</td>
 <td><input type="text" name="salary" value="${employee.salary}"></td>
 </tr>
 <tr>
 <td>Enter Address Id</td>
 <td><input type="text" name="addressId" value="${employee.addressId}"></td>
 </tr>
 <tr>
 <td><input type="submit"></td>
 </tr>
 </table>
 </form> 
</body>
</html>