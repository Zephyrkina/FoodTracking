<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<fmt:bundle basename="pagecontent" prefix="menu." >

<c:if test="${sessionScope.role != 'GUEST'}">
    <div class="container-fluid menu-bar">
        <div class="container">
            <div class="menu-href">

                <div class="">
                    <a href="${pageContext.request.contextPath}/user/showTodaysFoodList"><fmt:message key="show.diary"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/user/findFoodByName"><fmt:message key="find.food"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/user/addOwnFood"><fmt:message key="add.food"/></a>
                </div>
                <div class="">
                    <a href="${pageContext.request.contextPath}/user/savePreviousRecords"><fmt:message key="save.records"/></a>
                </div>

                 <c:if test="${sessionScope.role == 'ADMIN'}">
                     <div>
                         <a href="${pageContext.request.contextPath}/admin/showAllFood"><fmt:message key="show.all.food"/></a>
                     </div>
                 </c:if>


        </div>
        </div>
    </div>

</c:if>
</fmt:bundle>

