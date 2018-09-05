<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="pagecontent" >

<html>
<head>
    <title><fmt:message key="find.food.title"/></title>
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


    <div class="text-center " style="padding:50px 0">
        <div class="logo"><fmt:message key="find.food.header"/></div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left" action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="search_foodname" class="sr-only">Foodname</label>
                            <input type="text" name="search_food_name"  placeholder="<fmt:message key="food.name"/>" class="form-control" id="search_foodname" >

                        </div>
                        <div class="error-alert">${wrong_search_food_name}</div>
                        <div class="error-alert">${errorMessag}</div>
                        <div class="error-alert">${cantFindFoodMessage}</div>



                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>

            </form>
        </div>
        <!-- end:Main Form -->
    </div>

   <%-- <form action="${pageContext.request.contextPath}/app/findFoodByName" method="post">
        <h3>Input food name for search</h3>
        <input type="text" name="search_food_name">
        <input class="button" type="submit" value="Search">
    </form>

    <p>${errorMessage}</p>
    <p>${wrong_search_food_name}</p>--%>


    <div>
        <c:if test="${requestScope.foods != null }">
        <div class="row">
            <div class="col-lg-2"><fmt:message key="food.table.name"/></div>
            <div class="col-lg-2"><fmt:message key="food.table.calories"/></div>
            <div class="col-lg-2"><fmt:message key="food.table.carbs"/></div>
            <div class="col-lg-2"><fmt:message key="food.table.fats"/></div>
            <div class="col-lg-2"><fmt:message key="food.table.proteins"/></div>
            <div class="col-lg-1"><fmt:message key="food.table.weight"/></div>
            <div class="col-lg-1"><fmt:message key="food.table.add"/></div>
        </div>
        </c:if>
        <c:forEach items="${requestScope.foods}" var="food" >
            <div style="margin:30px 0px; height: 1px; background:gray;"></div>
            <form method="post" action="${pageContext.request.contextPath}/app/addFoodToDailyRecord">
                <div class="row">
                    <div class="col-lg-2">${food.name}</div>
                    <div class="col-lg-2"> ${food.calories}</div>
                    <div class="col-lg-2"> ${food.carbohydrates}</div>
                    <div class="col-lg-2">${food.fats}</div>
                    <div class="col-lg-2">${food.proteins}</div>

                    <input type="hidden" name="food_id" value="${food.id}">
                    <input type="hidden" name="food_name" value="${food.name}">
                    <input type="hidden" name="food_calories" value="${food.calories}">
                    <input type="hidden" name="food_carbs" value="${food.carbohydrates}">
                    <input type="hidden" name="food_fats" value="${food.fats}">
                    <input type="hidden" name="food_proteins" value="${food.proteins}">

                    <div class="col-lg-1"><input style="width: 60px" type="text" placeholder="<fmt:message key="food.weight"/>" name="food_quantity" pattern="[0-9]{1,4}"></div>
                    <div class="col-lg-1"><input class="button" type="submit" value="<fmt:message key="food.table.add"/>"></div>
                </div>
            </form>
        </c:forEach>
    </div>
<%--
    <p>${cantFindFoodMessage}</p>
--%>






</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
