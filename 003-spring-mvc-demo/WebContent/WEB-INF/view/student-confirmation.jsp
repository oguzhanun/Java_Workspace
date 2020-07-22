<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl core kütüphanesi... -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	The student is confirmed as : ${student.firstName} ${student.lastName}
	<br><br>
	
	The Country is confirmed as : ${student.country}
	<br><br>
	
	The Favorite Computer Language is confirmed as : ${student.favoriteLanguage}
	<br> <br>
	
	Operating Systems:
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
				<li>${temp}</li>
		</c:forEach>
	</ul>
	
	
</body>
</html>