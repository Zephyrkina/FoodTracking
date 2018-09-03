<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>User page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">

    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <%--
        <link rel="stylesheet" href="../css/bootstrap.css">
    --%>



</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>

<div class="container main__login__part">

    <div>
        <p style="color: red;">${sessionScope.calorieNormExceeded}</p>
    </div>



 <%--   <form action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
        <p>Input food name for search</p>
        <input type="text" name="search_food_name">
        <input class="button" type="submit" value="Search">
    </form>

    <p>${errorMessage}</p>
    <p>${wrong_search_food_name}</p>


    <p>
        <c:forEach items="${requestScope.foods}" var="food" >
    <form method="post" action="${pageContext.request.contextPath}/app/addFoodToDailyRecord">
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
--%>
  <%--  <div>
        <a href="${pageContext.request.contextPath}/jsp/user/addOwnFood.jsp">Add own food</a>
    </div>--%>

   <%-- <div>
        <a href="${pageContext.request.contextPath}/app/showTodaysFoodList">Show today's meals</a>
        <p>${requestScope.foodListIsEmpty}</p>

        <c:forEach items="${requestScope.foodList}" var="food" >
            <div class="row">
                <div class="col-lg-2">${food.id}</div>
                <div class="col-lg-2">${food.name}</div>
                <div class="col-lg-2"> ${food.calories}</div>
                <div class="col-lg-2">${food.fats}</div>
                <div class="col-lg-2">${food.proteins}</div>
                <div class="col-lg-2">${food.carbohydrates}</div>

            </div>
        </c:forEach>

    </div>--%>

<%--
    <div>
        <a href="${pageContext.request.contextPath}/app/savePreviousRecords">Finish all previous records</a>
    </div>--%>




</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>







<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <p style="color: red;">${sessionScope.calorieNormExceeded}</p>



    <br>
    <form action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
        <p>Input food name for search</p>
        <input type="text" name="search_food_name">
        <input class="button" type="submit" value="Search">
    </form>

    <p>${errorMessage}</p>
    <p>${wrong_search_food_name}</p>
    <p>
    <c:forEach items="${requestScope.foods}" var="food" >
    <form method="post" action="${pageContext.request.contextPath}/app/addFoodToDailyRecord">
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

    <a href="${pageContext.request.contextPath}/jsp/user/addOwnFood.jsp">Add own food</a>
    <br>
    <br>

    <a href="${pageContext.request.contextPath}/app/showTodaysFoodList">Show today's meals</a>
    <br>
    <br>
    <p>${requestScope.foodListIsEmpty}</p>

    <c:forEach items="${requestScope.foodList}" var="food" >
        <div class="row">
            <div class="col-lg-2">${food.id}</div>
            <div class="col-lg-2">${food.name}</div>
            <div class="col-lg-2"> ${food.calories}</div>
            <div class="col-lg-2">${food.fats}</div>
            <div class="col-lg-2">${food.proteins}</div>
            <div class="col-lg-2">${food.carbohydrates}</div>

        </div>
    </c:forEach>

    <br>

    <a href="${pageContext.request.contextPath}/app/savePreviousRecords">Finish all previous records</a>
    <br>
    <br>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/app/logout">Log out</a>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

</body>
</html>--%>
