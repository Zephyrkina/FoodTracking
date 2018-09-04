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
<c:if test="${sessionScope.role != 'GUEST'}">
    <div class="container-fluid menu-bar">
        <div class="container">
            <div class="menu-href">
<%--<c:choose>
    <c:when test="${sessionScope.role == 'GUEST'}">--%>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/showTodaysFoodList">Show today's meals</a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/findFoodByName">Find food</a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/addOwnFood">Add own food</a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/app/savePreviousRecords">Save records</a>
                </div>

                 <c:if test="${sessionScope.role == 'ADMIN'}">
                     <div>
                         <a href="${pageContext.request.contextPath}/app/showAllFood">Show all food</a>
                     </div>
                 </c:if>


        </div>
        </div>
    </div>

</c:if>


<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language: pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}" scope="session" />







<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
        <option value="uk_UA" ${language == 'uk_UA' ? 'selected' : ''}>Ukrainian</option>
    </select>
</form>
<br>
--%>

<%--
<fmt:bundle basename="pagecontent" />
--%>


<%--<div class="mb-4">
    <form>
        <input name="language" type="image" value="en_US"
        ${language=='en_US' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/United-States-Flag-icon.png" style="height: 30px; width: 30px;">
        <input name="language" type="image" value="uk_UA"
        ${language=='uk_UA' ? 'selected' : '' } src = "http://icons.iconarchive.com/icons/custom-icon-design/all-country-flag/128/Ukraine-Flag-icon.png" style="height: 30px; width: 30px;">
    </form>
</div>
<br>--%>


<%--

    <fmt:message key="label.welcome" bundle="${rb}"/> <hr/>
    <fmt:message key="footer.copyright" bundle="${rb}"/> <hr/>
    <fmt:message key="footer.date" bundle="${rb}"/>
--%>




<%--
<br>
<br>--%>

<%--
<a href="${pageContext.request.contextPath}/jsp/user/user_page.jsp">
    User page
</a>
||
<a href="${pageContext.request.contextPath}/jsp/admin/admin_page.jsp">
   Admin page
</a>

||
<a href="${pageContext.request.contextPath}/jsp/login.jsp">
    Login
</a>
||
<a href="${pageContext.request.contextPath}/app/logout">
    Logout
</a>


<span style="color:red">[ ${sessionScope.role} ]</span>

<br>--%>
