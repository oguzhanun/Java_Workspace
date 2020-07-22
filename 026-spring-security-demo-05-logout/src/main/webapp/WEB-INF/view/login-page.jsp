<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Custom Login Page</title>
	<style>
		.failed{
			color:red;
		}
	</style>
</head>
<body>

	<h3>Custom Login Page</h3>
	
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
			<c:if test="${param.error != null}">
				<i class="failed">
					Sorry! You entered a wrong password or username!
				</i>
			</c:if>
			<p>
				User Name : <input type="text" name="username"/>
			</p>
			
			<p>
				Password : <input type="password" name="password"/>
			</p>
			<input type="submit" value="Login"/>
		</form:form>

</body>
</html>