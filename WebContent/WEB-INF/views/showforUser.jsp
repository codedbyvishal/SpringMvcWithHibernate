<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Response Page</title>
</head>
<body>

<jsp:include page="userHeader.jsp"/>
	
<h2>Profile Details</h2>
<br/><br/>
<font color="red"> ${msg}</font>

<jsp:include page="userEmp.jsp"/>

</body>
</html>