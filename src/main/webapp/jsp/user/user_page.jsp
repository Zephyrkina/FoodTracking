<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<jsp:include page="/jsp/menu.jsp"></jsp:include>
<br>
<br>
<h1>Hello, ${sessionScope.login}</h1>
    <br>
    <form action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
        <label>Input food name for search</label>
        <input type="text" name="inputFoodName">
        <input class="button" type="submit" value="Search">
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/jsp/user/addOwnFood.jsp">Add own food</a>

    <br>

<a href="${pageContext.request.contextPath}/app/logout">Log out</a>




</div>
</body>
</html>
