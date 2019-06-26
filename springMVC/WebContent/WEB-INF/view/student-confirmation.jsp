<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student confirmation</title>
</head>

<body> 
	 The student is confirmed: ${student.firstName } ${student.lastName }
	<br>
	Country: ${student.country }
	<br>
	Favorite language: ${student.favoriteLanguage }
	<br>
	Operating system:
	<ul>
	<c:forEach var="temp" items="${student.operatingSystem }">
	<li>${temp } </li>
	</c:forEach>
	</ul>
</body>

</html>