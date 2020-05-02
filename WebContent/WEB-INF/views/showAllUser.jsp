 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
 <jsp:include page="header.jsp"></jsp:include> 
 <h2>Show All Employees</h2>
<table border="2" width="70%" cellpadding="2">  
<tr>
<th>Id</th>
<th>Name</th>
<th>LName</th>
<th>Age</th>
<th>Login Name</th>
<th>Salary</th>
<th>Email</th>
<th>UserType</th>
<th>Created Date </th>
<th>Created By</th>
<th>Status</th>
</tr>  
   
  
   <c:forEach var="emp" items="${list}">
      
	   <tr>  
	   <td>${emp.id}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.lName}</td>  
	   <td>${emp.age}</td>  
	     <td>${emp.loginName}</td> 
	       <td>${emp.salary}</td> 
	    <td>${emp.email}</td>
	    <td>${emp.userType}</td> 
	    <td>${emp.date}</td>
	    <td>${emp.createdBy}</td>
	    <c:if test="${emp.status == 1}" >
	    <td>Active</td>
 		</c:if>
 		<c:if test="${emp.status == 0}" >
	    <td>InActive</td>
 		</c:if>
	    <td><a href="./editEmp?empId=${emp.id}">Edit</a></td>
	   	<td> <a href="./deleteEmps?empId=${emp.id}">delete</a></td> </td>
	   </tr> 
	   
   </c:forEach>  
   
   </table>  