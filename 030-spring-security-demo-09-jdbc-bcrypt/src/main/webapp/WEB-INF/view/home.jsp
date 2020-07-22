<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
		User : <security:authentication property="principal.username"/>
	</p>

	<p>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>
	<hr>


	<!-- Add a reference to Leaders Page -->
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for managing peeps)
	</p>
	</security:authorize>
	
	<!-- Add a reference to Systems Page -->
	<security:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">Systems Meeting</a> (Only for admin peeps)
	</p>
	</security:authorize>
	<p>
		Welcome to the luv2code company home page!
	</p>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>