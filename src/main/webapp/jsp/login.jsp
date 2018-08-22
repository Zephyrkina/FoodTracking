<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="/jsp/menu.jsp"></jsp:include>
<br>
<br>
    <h1>Вход в систему</h1><br/>
    <form method="post" action="${pageContext.request.contextPath}/app/login">

        <input type="text" name="login"><br/>
        <input type="password" name="password">
        <br/>
            ${errorLoginPassMessage}
        <br/>
            ${wrongAction}
        <br/>
            ${nullPage}
        <br/>


        <input class="button" type="submit" value="Log in">

    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/app/logout">На головну</a>


</body>
</html>
