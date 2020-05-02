 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<jsp:include page="userHeader.jsp"></jsp:include>

<h2>Update Employee screen</h2>

${msg}
<form:form method="post" action="user_editEmp">
		<form:hidden path="id" />
		<form:hidden path="loginName" />
	<table>
	<tr>
		<td><form:label path="name">First Name</form:label></td>
		<td><form:input path="name" /></td> 
	 
	</tr>
	<tr>
		<td><form:label path="lName">Last Name</form:label></td>
		<td><form:input path="lName" /></td>
	</tr>
	<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="age">age</form:label></td>
		<td><form:input path="age" /></td>
 
	</tr>
	<tr>
		<td><form:label path="salary">salary</form:label></td>
		<td><form:input path="salary" /></td>
	</tr>
<%-- 	<tr>
 	<td>UserType</td>
	 <td><form:select path="userType">
	<form:option value="admin" label="admin" />
	<form:option value="user" label="user" />
	</form:select></td>
	</tr> --%>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="Update Emp"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>

 