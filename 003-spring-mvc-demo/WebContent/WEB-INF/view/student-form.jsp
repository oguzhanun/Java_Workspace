<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
				<form:input path="firstName"/>
				<br><br>
				
				<form:input path="lastName"/>
				<br><br>
				
				<form:select path="country">
					<!--<form:option value="Turkey" label="Turkey"></form:option>
					<form:option value="Germany" label="Germany"></form:option>
					<form:option value="United States" label="United States"></form:option>
					<form:option value="Canada" label="Canada"></form:option>-->
					<form:options items="${countryOptions}"/>
				</form:select>
				<br><br>
				
				Your Favorite Computer Language : 
				<!--  Java<form:radiobutton path="favoriteLanguage" value="Java"/> 
				C#<form:radiobutton path="favoriteLanguage" value="C#"/> 
				PHP<form:radiobutton path="favoriteLanguage" value="PHP"/> 
				Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
				-->
				<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
				<br><br>
				
				Operating Systems: 
				<br>
				Linux<form:checkbox path="operatingSystem" value="Linux"/>  
				Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>  
				Windows<form:checkbox path="operatingSystem" value="Windows"/>
				<br><br>
				
				<input type="submit" value="Submit">
	</form:form>
	
	
	
</body>

</html>