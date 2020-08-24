<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	


	

</head>
<body>

<h2> Admin Page</h2>
<p><font color='green'>${successMsg}</font></p>
<p><font color='red'>${errorMsg}</font></p>

<h1>Registration Page</h1>

	<form:form action="AccReg" method="post" modelAttribute="userAcc">
		<table>
			<tr>
				<th>First Name:</th>
				<td><form:input path="firstName" /></td>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton path="Gender" value="M"
						id="gender" /> Female:<form:radiobutton path="Gender"
						value="F" id="gender" />
				</td>
			</tr>
			<tr>
				<th>Role</th>
				<td><form:select path="userRole">
						<form:option value="">-Select-</form:option>
						<form:option value="Admin">Admin</form:option>
						<form:option value="User">User</form:option>
					</form:select></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
<a href="viewContact">View All Contacts</a>
</body>
</html>