<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin page</title>
</head>
<body>

<jsp:include page="/jsp/menu.jsp"></jsp:include>

<br>
<br>
<h1>Hello, admin ${sessionScope.login}</h1>

<a href="${pageContext.request.contextPath}/app/logout">Log out</a>

</body>
</html>

