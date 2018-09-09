<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="pagecontent"  >

<html>
<head>
    <title><fmt:message key="edit.food.title"/></title>
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
        <div class="logo"> <fmt:message key="edit.food.header"/></div>
        <div class="login-form-1">
            <form id="login-form" class="text-left" action="${pageContext.request.contextPath}/admin/editFood" method="post">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <input type="hidden" name="food_id" value="${param.food_id}">
                        <div class="form-group">
                            <label for="own_foodname_en" class="sr-only"><fmt:message key="food.name.en"/></label>
                            <input type="text" name="food_name_en" value="${param.food_name_en}" placeholder="<fmt:message key="food.name.en"/>" class="form-control" id="own_foodname_en" >
                        </div>
                        <div class="error-alert">${wrong_food_name_en}</div>
                        <div class="error-alert">${requestScope.foodAlreadyExists} </div>

                        <div class="form-group">
                            <label for="own_foodname_ua" class="sr-only"><fmt:message key="food.name.ua"/></label>
                            <input type="text" name="food_name_ua" value="${param.food_name_ua}" placeholder="<fmt:message key="food.name.ua"/>" class="form-control" id="own_foodname_ua" >
                        </div>
                        <div class="error-alert">${wrong_food_name_ua}</div>
                        <div class="error-alert">${requestScope.foodAlreadyExists} </div>

                        <div class="form-group">
                            <label for="own_calories" class="sr-only"><fmt:message key="food.calories"/></label>
                            <input  type="number" name="food_calories" value="${param.food_calories}"  placeholder="<fmt:message key="food.calories"/>"  class="form-control" id="own_calories" >
                        </div>
                        <div class="error-alert">${wrong_food_calories}</div>

                        <div class="form-group">
                            <label for="own_carbohydrates" class="sr-only"><fmt:message key="food.carbs"/></label>
                            <input  type="number" name="food_carbs" value="${param.food_carbs}"  placeholder="<fmt:message key="food.carbs"/>"  class="form-control" id="own_carbohydrates" >
                        </div>
                        <div class="error-alert">${wrong_food_carbs}</div>

                        <div class="form-group">
                            <label for="own_fats" class="sr-only"><fmt:message key="food.fats"/></label>
                            <input  type="number" name="food_fats" value="${param.food_fats}"  placeholder="<fmt:message key="food.fats"/>"  class="form-control" id="own_fats" >
                        </div>
                        <div class="error-alert">${wrong_food_fats}</div>

                        <div class="form-group">
                            <label for="own_proteins" class="sr-only"><fmt:message key="food.proteins"/></label>
                            <input  type="number" name="food_proteins" value="${param.food_proteins}"  placeholder="<fmt:message key="food.proteins"/>"  class="form-control" id="own_proteins" >
                        </div>
                        <div class="error-alert">${wrong_food_proteins}</div>
                        <input type="hidden" name="current_page" value="${param.current_page}">
                        <input type="hidden" name="no_of_pages" value="${param.no_of_page}">
                        <input type="hidden" name="records_per_page" value="${param.records_per_page}">
                        <input type="hidden" name="toEditPage" value="no">


                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>

            </form>
        </div>
    </div>



</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>



</fmt:bundle>
