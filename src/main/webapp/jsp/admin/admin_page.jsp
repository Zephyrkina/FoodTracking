<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<jsp:include page="/jsp/menu.jsp"></jsp:include>

<br>
<br>
<h1>Hello, admin ${sessionScope.login}</h1>

<a href="${pageContext.request.contextPath}/app/logout">Log out</a>
    <br>
    <a href="${pageContext.request.contextPath}/jsp/admin/showAllFood.jsp">Show all food</a>
    <br>

    <%--<a href="${pageContext.request.contextPath}/app/showAllUsersCommand">Show users</a>--%>
    <%--<br>--%>

<%--
<c:forEach items="${requestScope.users}" var="user" >
    <div class="row">
        <div class="col-lg-2">${user.id}</div>
        <div class="col-lg-2">${user.login}</div>
        <div class="col-lg-2"> ${user.password}</div>
        <div class="col-lg-2">${user.role}</div>
        <div class="col-lg-2">${user.email}</div>
&lt;%&ndash;

        <div class="col-lg-1"><input type="number" placeholder="gramms" name="food_quantity"></div>
        <div class="col-lg-1" style="margin-left:70px;"><input type="submit" value="Add"></div>
&ndash;%&gt;


    </div>
</c:forEach>--%>





</div>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</body>
</html>

