<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<fmt:bundle basename="pagecontent" prefix="user.page." >
<html>
<head>
    <title> <fmt:message key="title"/></title>
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

<div class="container">
    <div class="main__login__part">
        <div class="user-container">
            <div class="user-container-header white__link">
                <fmt:message key="summary"/>
            </div>
            <div class="user-container-main row">
                <div class="user-image-container col-lg-2">
                    <img class="user-image" src="<c:url value='/img/default-user-image.png'/>" alt="userPhoto">
                </div>
                <div class=" col-lg-8">
                    <div style="margin-bottom: 30px;"> ${sessionScope.login}</div>

                    <p> <fmt:message key="calories.remaining"/> </p>
                    <p style="color: #25b650;"> ${sessionScope.calorieNorm} - ${sessionScope.consumedCalories} = ${sessionScope.difference}</p>
                    <div>
                        <p style="color: red;"> ${sessionScope.calorieNormExceeded}</p>
                    </div>
                    <div style="color: #25b650;">
                            ${requestScope.savedRecords}

                    </div>
                </div>
            </div>

    </div>
    </div>


</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>

</fmt:bundle>