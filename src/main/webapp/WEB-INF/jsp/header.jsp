<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: 'en_US'}" scope="session"/>
<fmt:setLocale value="${language}" scope="session" />--%>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
   <%-- <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/bootstrap-grid.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/bootstrap-reboot.css'/>" rel="stylesheet">
--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
          integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="../css/bootstrap.css">--%>


</head>
<header>
     <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: pageContext.request.locale}" scope="session"/>
               <fmt:setLocale value="${language}" scope="session" />
    <fmt:bundle basename="pagecontent" prefix="header." >

    <div class="container">
        <div class="header__container align-items-center menu-href ">
            <div class="  header__form ">
                <form method="post" action="${pageContext.request.contextPath}/user/changeLanguage">
                    <select id="language" name="language" onchange="submit()"  class="header__form" >
                        <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
                        <option value="uk_UA" ${language == 'uk_UA' ? 'selected' : ''}>Ukrainian</option>
                    </select>
                </form>
            </div>
            <div class="header__form2">
                <h1 style="color: white">FoodTracking</h1>

            </div>
            <div class="header__form3 ">
                <c:choose>
                    <c:when test="${sessionScope.role == 'GUEST'}">
                        <div>
                            <a class="white__link" style="padding-right: 10px;" href="${pageContext.request.contextPath}/guest/login">
                                <fmt:message key="login"/>
                            </a>
                            <a class="white__link" href="${pageContext.request.contextPath}/guest/registration">
                                <fmt:message key="registration"/>
                            </a>
                        </div>

                    </c:when>
                    <c:otherwise>
                        <div >
                            <a class="white__link " style="padding-right: 10px;" href="${pageContext.request.contextPath}/user/profile"><fmt:message key="hello"/>, ${sessionScope.login}</a>
                            <a class="white__link" href="${pageContext.request.contextPath}/user/logout">
                                <fmt:message key="logout"/>
                            </a>
                        </div>

                    </c:otherwise>
                </c:choose>
            </div>
        </div>


    </div>
    </fmt:bundle>
</header>