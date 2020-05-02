<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${name} &nbsp;&nbsp;&nbsp;
<br>&nbsp;&nbsp;&nbsp;
<br>
	<a href="user_profile?loginName=${loginName}" name="My Profile" value="My Profile">My Profile </a>&nbsp;&nbsp;&nbsp;
	
	 <a href="user_getAllEmps">Show all users</a>&nbsp;&nbsp;&nbsp;
    
    <a href="user_readUser">Search Emp</a>&nbsp;&nbsp;&nbsp;
    
     <a href="logout">Logout</a>&nbsp;&nbsp;&nbsp;
</body>
</html>