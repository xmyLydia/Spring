<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body> 
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br>
		Last name: <form:input path="lastName"/>
	
	<br>
	<form:select path="country">
	<form:options items="${student.countryOptions }" />
	</form:select>
	<br>
	Java<form:radiobutton path="favoriteLanguage" value="java"/>
	C#<form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
	<br>
	operating systems:
	Linux	<form:checkbox path="operatingSystem" value="Linux"/>
	Mac OS	<form:checkbox path="operatingSystem" value="Mac Os"/>
	MS Windows<form:checkbox path="operatingSystem" value="MS windows"/>
	
	<input type="submit" value="submit"/>
	</form:form>

</body>

</html>