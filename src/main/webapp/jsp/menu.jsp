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

<br>