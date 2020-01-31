<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/authenticate" method="post">
    User name: <input type="text" name="username">
    Password: <input type="password" name="password">
    <input type="submit" value="Login">
</form:form>

</body>
</html>