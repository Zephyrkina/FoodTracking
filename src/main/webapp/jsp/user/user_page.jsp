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
    <a href="${pageContext.request.contextPath}/jsp/user/addOwnFood.jsp">Add own food</a>

    <br>
    <form action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
        <label>Input food name for search</label>
        <input type="text" name="search_food_name">
        <input class="button" type="submit" value="Search">
    </form>

    <br>

<a href="${pageContext.request.contextPath}/app/logout">Log out</a>

    <p>${errorMessage}</p>
    <p>
    <div class="row">
        <div class="col-lg-2">${food.id}</div>
        <div class="col-lg-2">${food.name}</div>
        <div class="col-lg-2"> ${food.calories}</div>
        <div class="col-lg-2">${food.fats}</div>
        <div class="col-lg-2">${food.proteins}</div>

    </div>
    </p>

    <p>${cantFindFoodMessage}</p>


</div>
</body>
</html>
