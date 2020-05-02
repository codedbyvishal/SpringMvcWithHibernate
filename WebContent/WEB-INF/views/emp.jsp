<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<a href="editPassword">Change Password</a>&nbsp;&nbsp;&nbsp;
<a href="./editProfile?empId=${emp.id}">Edit Profile</a>

<br>
<br>
 <table border="1" width="30%">
		<tr>
			<td width="15%"><label id="idLbl">ID</label></td> 
			<td width="15%"> ${emp.id}</td>
		</tr>
		
		<tr>
			<td><label id="fNameLbl">First Name</label></td> <td> ${emp.name}</td>
		</tr>
		
		<tr>
			<td><label id="lNameLbl">Last Name</label></td> <td> ${emp.lName}</td>
		</tr>
		
		<tr>
			<td><label id="lNameLbl">Age</label></td> <td> ${emp.age}</td>
		</tr>
		
		<tr>
			<td><label id="salLbl">Salary</label> </td> <td> ${emp.salary}</td>
		</tr>
		
		<tr>
			<td><label id="loginLbl">Login Name</label> </td> <td> ${emp.loginName}</td>
		</tr>
		
		<tr>
			<td><label id="loginLbl">Email</label> </td> <td> ${emp.email}</td>
		</tr>
		
		<tr>
			<td><label id="loginLbl">User Type</label> </td> <td> ${emp.userType}</td>
		</tr>
		<tr>
			<td><label id="loginLbl">Created Dated</label> </td> <td> ${emp.date}</td>
		</tr>
		<tr>
			<td><label id="loginLbl">Created By</label> </td> <td> ${emp.createdBy}</td>
		</tr>
		
  	</table>

</body>
</html>