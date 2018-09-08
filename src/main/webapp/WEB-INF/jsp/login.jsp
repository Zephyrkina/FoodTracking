<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="pagecontent" prefix="login." >


<html>
<head>
    <title><fmt:message key="title"/></title>
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
<%--
<jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>
--%>

<div class="container main__login__part">




    <jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>

<div class="row">
    <div class="text-center login__container" style="padding:50px 0">
        <div class="logo"><fmt:message key="header"/></div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left" method="post" action="${pageContext.request.contextPath}/guest/login">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="lg_username" class="sr-only">Username</label>
                            <input type="text"  name="input_login" value="${requestScope.input_login}" class="form-control" id="lg_username"  placeholder="<fmt:message key="login"/>">
                        </div>

                        <div class="error-alert">${requestScope.userNotFound}</div>
                        <div class="error-alert">${wrong_input_login} </div>

                        <div class="form-group">
                            <label for="lg_password" class="sr-only">Password</label>
                            <input type="password" name="input_password" class="form-control" id="lg_password" placeholder="<fmt:message key="password"/>">
                        </div>

                        <div class="error-alert">${wrong_input_password}</div>
                      <%--  <div class="form-group login-group-checkbox">
                            <input type="checkbox" id="lg_remember" name="lg_remember">
                            <label for="lg_remember">remember</label>
                        </div>--%>
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p></p>
                    <p><fmt:message key="question"/> <a href="${pageContext.request.contextPath}/guest/registration"> <fmt:message key="new.user"/></a></p>
                </div>
            </form>
        </div>
        <!-- end:Main Form -->
    </div>

</div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
</fmt:bundle>