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
	

<script>
	
function validationPwds(){

	var newPwd = $('#newPwd').val();
	var confirmPwd =$('#confirmPwd').val();
	if(newPwd == confirmPwd){
        return true;
		}
	alert("Passwords do not match.");

	$('#errId').innerHTML = 'New Password & Confirmed Password Must be Matched';
	return false;
	
}



</script>

</head>
<body>

<p><font color='red'>${errMsg}</font></p>

<h1>Unlock Account Here</h1>

    <font color='red'><span id="errId"></span></font>

	<form:form action="unlockUserAcc" method="post" modelAttribute="unlockAcc">
	
		<table>
			<tr>
				<th>Your Email:</th>
				<td>${email}</td>
			<tr>
				<th>Enter Temporary Password: </th>
				<td><form:input path="tempPwd" /></td>
			</tr>
			<tr>
				<th>Enter New Password: </th>
				<td><form:input path="newPwd" /></td>
			</tr>
			<tr>
				<th>Confirm New Password: </th>
				<td><form:input path="confirmPwd" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="save" onclick="return validationPwds()"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
</body>
</html>