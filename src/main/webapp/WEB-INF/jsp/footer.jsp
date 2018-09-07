<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:bundle basename="pagecontent" prefix="footer." >
<footer >
    <div class="container-fluid">
        <div class="container">
            <div class="thinLineInFooter"></div>
            <div class="row">
                <div class="triangle-footer"></div>
            </div>
            <div class="rightsSignBlock">
                <span class="rightsSign"><fmt:message key="name"/><br></span>
                <span class="rightsSign"><fmt:message key="rights"/><br></span>
                <span class="rightsSign"><fmt:message key="designed"/><br></span>
            </div>
        </div>
    </div>
</footer>
</fmt:bundle>
