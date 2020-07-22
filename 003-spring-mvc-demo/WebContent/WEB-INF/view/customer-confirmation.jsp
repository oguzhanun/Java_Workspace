<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
		The customer is confirmed as : ${customer.firstName} ${customer.lastName}
		
		<br>
		
		His or Her freepass number is : ${customer.freePass}
		<br>
			
		Postal Code is: ${customer.postalCode}
		<br>
		
		Course Code is: ${customer.courseCode}
		
		
</body>
</html>