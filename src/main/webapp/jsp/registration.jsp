<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    <br>
    <br>
<%--
    <h1>Hello, ${sessionScope.login}</h1>
--%>


    <br>
    <form action="${pageContext.request.contextPath}/app/registration" method="post">
        <label>Registration</label>
        <br>
        <input type="text" name="user_name" value="${user_name}" placeholder="Name" required>
        <br>
        ${wrong_user_name}
        <br>
        <input type="text" name="user_login" value="${user_login}" placeholder="Login" required>
        <br>
        ${wrong_user_login}
        <br>
        <input type="password" name="user_password" value="${user_password}" placeholder="Password" required>
        <br>
        ${wrong_user_password}
        <br>
        <input type="password" name="user_password_repeat" value="${user_password_repeat}" placeholder="Repeat password" required>
        <br>
        ${wrong_user_password_repeat}
        <br>
        <input type="text" name="user_email" value="${user_email}" placeholder="E-mail" required>
        <br>
        ${wrong_user_email}
        <br>
        <input type="number" name="user_age" value="${user_age}" placeholder="Age" required>
        <br>
        ${wrong_user_age}
        <br>
        <input type="number" name="user_height" value="${user_height}" placeholder="Height" required>
        <br>
        ${wrong_user_height}
        <br>
        <input type="number" name="user_weight" value="${user_weight}" placeholder="Weight" required>
        <br>
        ${wrong_user_weight}
        <br>
        <input type="radio" name="user_activity" value="low" checked>Low activity
        <br>
        <input type="radio" name="user_activity" value="normal" >Normal activity
        <br>
        <input type="radio" name="user_activity" value="high">High activity
        <br>

        <br>


        <input class="button" type="submit" value="Register">
    </form>
    <p>${errorMessage}</p>


</div>
</body>
</html>
