<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">New Address Form</h2>
<form action="insertAddress">
<table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
 <tr>
 <td>Enter Address Id</td>
 <td><input type="text" name="addressId" value="${employee.addressId}"></td>
 </tr>
 <tr>
 <td>Enter Address</td>
 <td><input type="text" name="address"></td>
 </tr>
<tr>
<td><input type="submit"></td>
</tr>
</table>
</body>
</html>