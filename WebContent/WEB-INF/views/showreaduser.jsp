<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="userHeader.jsp"></jsp:include>  
<h2>Search Employee</h2>
<font color="red">${msg }</font>

 <form action="userreadUser" method="post">
	Enter user id to search : 
 	<input type="text" name="id" id="">
	<br />
	<input type="submit" name="Search" value="Search">
 </form>

 <br/><br/>
<c:if test="${emp != null}">
 		<jsp:include page="userShowEmp.jsp"/>
</c:if>
</body>
</html>