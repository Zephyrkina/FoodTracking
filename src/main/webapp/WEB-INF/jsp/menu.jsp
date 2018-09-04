<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    &lt;%&ndash; <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
     <link href="<c:url value='/css/bootstrap-grid.css'/>" rel="stylesheet">
     <link href="<c:url value='/css/bootstrap-reboot.css'/>" rel="stylesheet">
 &ndash;%&gt;
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
          integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    &lt;%&ndash;<link rel="stylesheet" href="../css/bootstrap.css">&ndash;%&gt;

</head>--%>
<fmt:bundle basename="pagecontent" prefix="menu." >

<c:if test="${sessionScope.role != 'GUEST'}">
    <div class="container-fluid menu-bar">
        <div class="container">
            <div class="menu-href">
<%--<c:choose>
    <c:when test="${sessionScope.role == 'GUEST'}">--%>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/showTodaysFoodList"><fmt:message key="show.diary"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/findFoodByName"><fmt:message key="find.food"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/addOwnFood"><fmt:message key="add.food"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/savePreviousRecords"><fmt:message key="save.records"/></a>
                </div>

                 <c:if test="${sessionScope.role == 'ADMIN'}">
                     <div>
                         <a href="${pageContext.request.contextPath}/app/showAllFood"><fmt:message key="show.all.food"/></a>
                     </div>
                 </c:if>


        </div>
        </div>
    </div>

</c:if>
</fmt:bundle>

