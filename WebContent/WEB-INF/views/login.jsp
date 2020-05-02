<%@taglib 
uri="http://www.springframework.org/tags/form" 
prefix="form"%>

<html>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="register">Register</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login">Login</a>
	<br/><br/><br/>
	
	<h1>Login Page</h1>
	<font color="Red">${msg}</font>    
		<form:form action="login" method = "POST" >
		<table>
		<tr>
			<td><label id="userNameLbl">User Name:</label></td>
			<td><input type="text" name="loginName"><td/> 
		</tr>
		<tr>
			<td><label id="passwordLbl">Password:</label></td>
			<td><input type="password" name="password"><td/>
		</tr>
	 		<tr>	    
			<td colspan="2" align="center">
			<input type="submit" value="Login"></td>	
		</tr>
		</table>
		</form:form>
</body>
</html>
