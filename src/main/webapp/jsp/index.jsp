<%--
<!doctype html>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>


<body>
<div class="container">
<jsp:include page="/jsp/menu.jsp"></jsp:include>

<br>

<a href="${pageContext.request.contextPath}/jsp/login.jsp">Login</a>
</div>
</body>
</html>
