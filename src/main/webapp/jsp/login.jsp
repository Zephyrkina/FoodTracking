<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">

<br>
<br>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    <fmt:bundle basename="pagecontent">

       <%-- <fmt:message key="label.welcome"/> <hr/>
        <fmt:message key="footer.copyright"/> <hr/>
        <fmt:message key="footer.date"/>--%>


    <h1> <fmt:message key="login.welcome"/></h1><br/>
    <form method="post" action="${pageContext.request.contextPath}/app/login">

        <fmt:message key="page.login"/><br>
        <input type="text" name="login"><br/>
        <fmt:message key="page.password"/><br>
        <input type="password" name="password">
        <br/>
            ${errorLoginPassMessage}
        <br/>
            ${wrongAction}
        <br/>
            ${nullPage}
        <br/>


        <input class="button" type="submit" value="<fmt:message key="login.button"/>">

    </form>
    <br/>
        <a href="${pageContext.request.contextPath}/jsp/registration.jsp"><fmt:message key="registration.page"/></a>
        <br>
    <a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="logout"/></a>
    </fmt:bundle>
</div>
</body>
</html>
