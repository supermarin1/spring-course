<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student registration form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last Name: <form:input path="lastName"/>
    <br><br>
    Country: <form:select path="country">
<%--    <form:option value="Brazil" label="Brazil"/>--%>
<%--    <form:option value="France" label="France"/>--%>
<%--    <form:option value="Germany" label="Germany"/>--%>
<%--    <form:option value="India" label="India"/>--%>
    <form:options items="${student.countryOptions}"/>
</form:select>
    <br><br>
    Favorite language:
    Java: <form:radiobutton path="favoriteLanguage" value="Java" />
    C#: <form:radiobutton path="favoriteLanguage" value="C#" />
    PHP: <form:radiobutton path="favoriteLanguage" value="PHP" />
    Ruby: <form:radiobutton path="favoriteLanguage" value="Ruby" />
    <br><br>
    Operating systems:
    Linux: <form:checkbox path="operatingSystems" value="Linux"/>
    Win: <form:checkbox path="operatingSystems" value="Win"/>
    Mac: <form:checkbox path="operatingSystems" value="Mac"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>