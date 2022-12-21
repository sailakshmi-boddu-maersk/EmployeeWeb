<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="#d7afd7">
  
    <h1 align="center">Employee Management</h1>
    <h2 align="center">
      <a href="/EmployeeWeb/new">Add New Employee</a><br>
      <a href="/EmployeeWeb/list">List Employees</a><br>
      <!-- <a href="/EmployeeWeb/list">Edit Existing Employee</a><br>
      <a href="/EmployeeWeb/list">Delete Employee</a><br> -->
    </h2>
   <%--  <!--  All DOctor shows-->
    <h1 align="center">List of Doctors</h1>
    <table border="1" align="center" cellpadding="5"
      style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
				
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Salary</th>
						<th>AddressId</th>
						<th>Action</th>
					</tr>
					<c:forEach var="emp" items="${listEmployee}">

						<tr>
							<td><c:out value="${emp.id}" /></td>
							<td><c:out value="${emp.firstName}" /></td>
							<td><c:out value="${emp.lastName}" /></td>
							<td><c:out value="${emp.salary}" /></td>
							<td><c:out value="${emp.addressId}" /></td>
							<td><a href="edit?id=<c:out value='${emp.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${emp.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		

			</table> --%>
</body>
</html>