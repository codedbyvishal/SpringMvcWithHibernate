<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>  
<h2>Delete Employee</h2>
<font color="red">${messageInfo}</font>

 <form action="deleteEmp" method="post">
	Enter user id to delete : 
 	<input type="text" name="id" id="">
	<br />
	<input type="submit" name="Delete" value="Delete">
 </form>

 <br/><br/>
 <%-- <c:if test="$(row == 1)">
 <font color="red">${msg1}</font>
 </c:if> --%>
</body>
</html>