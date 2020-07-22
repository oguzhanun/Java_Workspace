<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Müşteri Listesi Sayfasına Hoşgeldiniz...</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
		<div id="wrapper">
				<div id="header">
						<h2>CRM - Customer Relation Manager</h2>
				</div>
		</div>
		
		<div id="container">
			<div id = "content">
				<!-- <input type="button" value="Add Customer"
						onClick="window.location.href='showFormForAdd'; return false;"
						class="add-button"/>
 				-->
 				<form:form action="search" method="POST">
 					Type the name or surname of the customer   <input type="text" name="searchWord"/>
 					<input type="submit" value="Search" class="add-button"/>
 				</form:form>
 				<br>
 				
 				<form:form action="showFormForAdd" >
 					<input type="submit" value="Add Customer" class="add-button"/>
 				</form:form>
 				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Address</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}" >
						<c:url var="updateCustomer" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateCustomer}">Update</a>
								|
								<a href="${deleteLink}" 
									onClick="if(!(confirm('Are you sure you want to delete the customer?'))) return false">
									Delete
								</a>
							</td>
						</tr>
					</c:forEach>
					
				</table>
				
			</div>
		
		</div>

</body>
</html>