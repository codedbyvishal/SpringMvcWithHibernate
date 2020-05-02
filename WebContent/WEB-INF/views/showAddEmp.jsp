 <%@taglib 
uri="http://www.springframework.org/tags/form" 
prefix="form"%>


<html>
<head>
	<title>Emp manager</title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
	
</style>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<h2>Add new Employee</h2>
<font color="red">${msg }</font>
 
 
<form:form method="post" action="addEmp">
	<table>
	<tr>
		<td><form:label path="loginName">Login Name</form:label></td>
		<td><form:input path="loginName" /></td>
	</tr>
	<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:password path="password" /></td>
	</tr>
	<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="name">First Name</form:label></td>
		<td><form:input path="name" /></td> 
	</tr>
	<tr>
		<td><form:label path="lName">Last Name</form:label></td>
		<td><form:input path="lName" /></td>
		
	</tr>
	<tr>
		<td><form:label path="age">Age</form:label></td>
		<td><form:input path="age" /></td>
	</tr>
	<tr>
		<td><form:label path="salary">Salary</form:label></td>
		<td><form:input path="salary" /></td>
	</tr>
		<tr>
		<td>UserType</td>
	 <td><form:select path="userType">
	<form:option value="admin" label="admin" />
	<form:option value="user" label="user" />
	</form:select></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Emp"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>
