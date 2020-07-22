<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
		.error{color:red}
	</style>
	
</head>

<body>
	
	Be careful not to leave the fields with (*) empty!
	
	<form:form action="processForm" modelAttribute="customer">
	<br>
	
			Firstname: <form:input path="firstName"/>
			<br><br>
			
			Lastname (*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			<br><br>
			
			FreePass (*):<form:input path="freePass"/>
			<form:errors path="freePass" cssClass="error"/>
			<br><br>
			
			Postal Code(*):<form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"/>
			<br><br>

			Course Code(*):<form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"/>
			<br><br>

			<input type="submit" value="Submit"/>
	
	</form:form>
	
</body>
</html>