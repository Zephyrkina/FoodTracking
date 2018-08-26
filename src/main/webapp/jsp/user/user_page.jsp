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
        <input type="text" name="search_food_name">
        <input class="button" type="submit" value="Search">
    </form>

    <br>

    <p>${errorMessage}</p>
    <p>
    <c:forEach items="${requestScope.foods}" var="food" >
    <form method="post" action="${pageContext.request.contextPath}/app/addFoodToRecord">
        <div class="row">
            <div class="col-lg-2">${food.id}</div>
            <div class="col-lg-2">${food.name}</div>
            <div class="col-lg-1"> ${food.calories}</div>
            <div class="col-lg-1"> ${food.carbohydrates}</div>
            <div class="col-lg-1">${food.fats}</div>
            <div class="col-lg-1">${food.proteins}</div>

            <input type="hidden" name="food_id" value="${food.id}">
            <input type="hidden" name="food_name" value="${food.name}">
            <input type="hidden" name="food_calories" value="${food.calories}">
            <input type="hidden" name="food_carbs" value="${food.carbohydrates}">
            <input type="hidden" name="food_fats" value="${food.fats}">
            <input type="hidden" name="food_proteins" value="${food.proteins}">

            <div class="col-lg-1"><input type="number" placeholder="gramms" name="food_quantity"></div>
            <div class="col-lg-1"><input class="button" style="margin-left:70px;" type="submit" value="Add"></div>
        </div>
    </form>
    </c:forEach>
    </p>

    <p>${cantFindFoodMessage}</p>


    <br>
    <a href="${pageContext.request.contextPath}/jsp/user/addOwnFood.jsp">Add own food</a>

    <br>
    <br>
    <a href="${pageContext.request.contextPath}/app/logout">Log out</a>
</div>
</body>
</html>
