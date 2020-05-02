<%@taglib 
uri="http://www.springframework.org/tags/form" 
prefix="form"%>

<html>
<head>
	<title>Registration </title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
</style>
</head>

<body>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="register">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login">Login</a>
	<br/>
	<h1>Registration Page</h1>
	<font color="red">${msg }</font><br/><br/>
	<form:form method="post" action="register">
	<table>
	
	<tr>
		<td>Login Name</td>
		<td><form:input path="loginName" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><form:password path="password" /></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><form:input path="name" /></td> 
	</tr>
	<tr>
		<td>Last Name</td>
		<td><form:input path="lName" /></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><form:input path="age" /></td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><form:input path="salary" /></td>
	</tr>
	 <td>UserType</td>
	 <td><form:select path="userType">
	<form:option value="admin" label="admin" />
	<form:option value="user" label="user" />
	</form:select></td>
	</tr>

	<tr>
		<td colspan="2">
			<input type="submit" value="Register"/>
		</td>
	</tr>
</table>	
</form:form>

</body>
</html>
