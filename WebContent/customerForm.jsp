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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="CustomerServlet" method="post">

				<caption>
					<h2>
            			Insert Customer Details
					</h2>
				</caption>
				
				<fieldset class="form-group">
					<label>Customer Name</label> 
					<input type="text" name="name" class="form-control" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Email</label> 
					<input type="text" name="email_id" class="form-control" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Customer PhoneNo</label> 
					<input type="text" name="phone_no" class="form-control" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Customer Address</label> 
					<input type="text" name="address" class="form-control" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer State</label> 
					<input type="text" name="state" class="form-control" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Customer City</label> 
					<input type="text" name="city" class="form-control" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Customer PinCode</label> 
					<input type="text" name="pinCode" class="form-control" required="required">
				</fieldset>

           			<button type="submit" name="insert" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>