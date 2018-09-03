<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Login</title>
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
<%--
        <a href="${pageContext.request.contextPath}/app/showTodaysFoodList">Show today's meals</a>
--%>
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

    </div>


</div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
