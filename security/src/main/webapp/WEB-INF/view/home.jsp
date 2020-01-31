<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="seciruty" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>msyrovets Company page</title>
</head>

<body>
<h2>msyrovets Company page</h2>
<hr>
User: <seciruty:authentication property="principal.username"/>
<br><br>
Role(s): <seciruty:authentication property="principal.authorities"/>
<hr>
<seciruty:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (Only for Managers)
    </p>
</seciruty:authorize>
<hr>
<seciruty:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/system">IT department</a>
        (Only for IT)
    </p>
</seciruty:authorize>
<hr>
<p>
    Welcome to msyrovets Company page
</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>