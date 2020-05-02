<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Password</title>
</head>
<body>
 <jsp:include page="header.jsp"/>
<h1>Change/Edit Password</h1>
<font color="Red">${msg}</font>  
<form action="editPassw" method="post">
<table>
<tr>
<td>Enter old password:</td>
<td><input type="password" name="oldPassword" > </td>
</tr>
<tr>
<tr>
<td>Enter new password:</td>
<td><input type="password" name="password" > </td>
</tr>
<tr>
<td>Re-Enter new password:</td> 
<td><input type="password" name="repassword" ></td>
</tr>
<tr>
<br>
<td><input type="submit" value="Change">
</td></tr>
</table>
</form>

</body>
</html>