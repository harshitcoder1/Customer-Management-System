<%@page import="model.CustomerAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h1 class="navbar-brand"> Customer Management App </h1>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/customerForm.jsp" class="btn btn-success">Add New Customer</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>PhoneNo</th>
						<th>Address</th>
						<th>State</th>
						<th>City</th>
						<th>PinCode</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="customer" items="${listCustomer}">
						<tr>
							<td><c:out value="${customer.getCustomerId()}" /></td>
							<td><c:out value="${customer.getName()}" /></td>
							<td><c:out value="${customer.getEmail_id()}" /></td>
							<td><c:out value="${customer.getPhone_no()}" /></td>
							<td><c:out value="${listCustomerAddress.get(count).getAddress()}" /></td>
							<td><c:out value="${listCustomerAddress.get(count).getState()}" /></td>
							<td><c:out value="${listCustomerAddress.get(count).getCity()}" /></td>
							<td><c:out value="${listCustomerAddress.get(count).getPinCode()}" /></td>
							<c:set var="count" value="${count + 1}" scope="page"/>
							<td>
							<form action="CustomerServlet" method="post">
							<button type="submit" name="edit" value='${customer.getCustomerId()}'>Edit</button>
							<button type="submit" name="delete" value='${customer.getCustomerId()}'>Delete</button>
							</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>