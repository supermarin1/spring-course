<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation form</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Favorite Language: ${student.favoriteLanguage}
<br><br>
Operating systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}" >
    <li> ${temp} </li>
    </c:forEach>
</ul>
</body>
</html>