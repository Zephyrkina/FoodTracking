<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="pagecontent"  >

<html>
<head>
    <title><fmt:message key="add.own.food.title"/></title>
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
        <div class="logo"><fmt:message key="add.own.food.header"/></div>
        <div class="logo" style="color: black;"><fmt:message key="add.own.food.notice"/></div>

        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left" action="${pageContext.request.contextPath}/app/addOwnFood" method="post">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="own_foodname_en" class="sr-only">Foodname</label>
                            <input type="text" name="own_food_name_en" value="${own_food_name_en}" placeholder="<fmt:message key="food.name.en"/>" class="form-control" id="own_foodname_en" >
                        </div>
                        <div class="error-alert">${wrong_own_food_name_en}</div>
                        <div class="error-alert">${requestScope.foodAlreadyExists} </div>

                        <div class="form-group">
                            <label for="own_foodname" class="sr-only">Foodname</label>
                            <input type="text" name="own_food_name_ua" value="${own_food_name_ua}" placeholder="<fmt:message key="food.name.ua"/>" class="form-control" id="own_foodname" >
                        </div>
                        <div class="error-alert">${wrong_own_food_name_ua}</div>
                        <div class="error-alert">${requestScope.foodAlreadyExists} </div>

                        <div class="form-group">
                            <label for="own_calories" class="sr-only">Calories</label>
                            <input  type="number" name="own_food_calories" value="${own_food_calories}"  placeholder="<fmt:message key="food.calories"/>"  class="form-control" id="own_calories" >
                        </div>
                        <div class="error-alert">${wrong_own_food_calories}</div>

                        <div class="form-group">
                            <label for="own_carbohydrates" class="sr-only">Carbohydrates</label>
                            <input  type="number" name="own_food_carbs" value="${own_food_carbs}"  placeholder="<fmt:message key="food.carbs"/>"  class="form-control" id="own_carbohydrates" >
                        </div>
                        <div class="error-alert">${wrong_own_food_carbs}</div>

                        <div class="form-group">
                            <label for="own_fats" class="sr-only">Fats</label>
                            <input  type="number" name="own_food_fats" value="${own_food_fats}"  placeholder="<fmt:message key="food.fats"/>"  class="form-control" id="own_fats" >
                        </div>
                        <div class="error-alert">${wrong_own_food_fats}</div>

                        <div class="form-group">
                            <label for="own_proteins" class="sr-only">Proteins</label>
                            <input  type="number" name="own_food_proteins" value="${own_food_proteins}"  placeholder="<fmt:message key="food.proteins"/>"  class="form-control" id="own_proteins" >
                        </div>
                        <div class="error-alert">${wrong_own_food_proteins}</div>

                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>

            </form>
        </div>
        <!-- end:Main Form -->
    </div>


</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>

</fmt:bundle>

