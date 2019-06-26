<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
 
<title>Customer confirmation</title>
</head>
<body>
The customer is confirmed: ${customer.firstName } ${customer.lastName}
<br>
Free passes: ${customer.freePasses }
<br>
Postal code: ${customer.postalCode }
<br>
Course code: ${customer.courseCode }
</body>
</html>