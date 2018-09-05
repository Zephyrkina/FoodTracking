<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<fmt:bundle basename="pagecontent"  >


<html>
<head>
    <title>All food</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">

    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

    <%--
        <link rel="stylesheet" href="../css/bootstrap.css">
    --%>



</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>

<div class="container main__login__part">



    <form action="${pageContext.request.contextPath}/app/showAllFood">

        <input type="hidden" name="currentPage" value="1">

        <div class="form-group col-md-4">

            <label for="records">Select records per page:</label>

            <select class="form-control" id="records" name="recordsPerPage">
                <option value="5">5</option>
                <option value="10" selected>10</option>
                <option value="15">15</option>
            </select>

        </div>
        <br>

        <button type="submit" class="btn btn-primary">Submit</button>

    </form>


    <br>
    <br>
   <%-- <div class="row col-md-6">--%>
        <div>
            <c:if test="${requestScope.foodList != null }">
                <div class="row">
                    <div class="col-lg-1"><fmt:message key="food.table.id"/></div>
                    <div class="col-lg-2"><fmt:message key="food.table.name"/></div>
                    <div class="col-lg-2"><fmt:message key="food.table.calories"/></div>
                    <div class="col-lg-2"><fmt:message key="food.table.carbs"/></div>
                    <div class="col-lg-2"><fmt:message key="food.table.fats"/></div>
                    <div class="col-lg-1"><fmt:message key="food.table.proteins"/></div>
                    <div class="col-lg-1"><fmt:message key="food.table.edit"/></div>
                    <div class="col-lg-1"><fmt:message key="food.table.delete"/></div>
                </div>
                <div style="margin:30px 0px; height: 1px; background:gray;"></div>

            </c:if>
            <c:forEach items="${foodList}" var="food">
                <div class="row">
                    <div class="col-lg-1">${food.id}</div>
                    <div class="col-lg-2">${food.name}</div>
                    <div class="col-lg-2">${food.calories}</div>
                    <div class="col-lg-2">${food.carbohydrates}</div>
                    <div class="col-lg-2">${food.fats}</div>
                    <div class="col-lg-1">${food.proteins}</div>
                    <div class="col-lg-1">
                    <form method="post" action="${pageContext.request.contextPath}/app/editFood">

                        <input type="hidden" name="food_id" value="${food.id}">
                        <input type="hidden" name="food_name" value="${food.name}">
                        <input type="hidden" name="food_calories" value="${food.calories}">
                        <input type="hidden" name="food_carbs" value="${food.carbohydrates}">
                        <input type="hidden" name="food_fats" value="${food.fats}">
                        <input type="hidden" name="food_proteins" value="${food.proteins}">

                        <input type="hidden" name="current_page" value="${currentPage}">
                        <input type="hidden" name="no_of_pages" value="${noOfPages}">
                        <input type="hidden" name="records_per_page" value="${recordsPerPage}">

                        <input class="button" type="submit" value="Edit">
                    </form>
                    </div>
                    <div class="col-lg-1">
                    <form method="post" action="${pageContext.request.contextPath}/app/deleteFood">
                        <input type="hidden" name="food_id" value="${food.id}">
                        <input type="hidden" name="current_page" value="${currentPage}">
                        <input type="hidden" name="no_of_pages" value="${noOfPages}">
                        <input type="hidden" name="records_per_page" value="${recordsPerPage}">
                        <input class="button" type="submit" value="Delete">
                    </form>
                    </div>
                </div>
            </c:forEach>
        </div>


       <%--
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Calories</th>
                <th>Carbohydrates</th>
                <th>Fats</th>
                <th>Proteins</th>
                <th>Edit</th>
                <th>Delete</th>

            </tr>

            <c:forEach items="${foodList}" var="food">
                <tr>
                    <td>${food.id}</td>
                    <td>${food.name}</td>
                    <td>${food.calories}</td>
                    <td>${food.carbohydrates}</td>
                    <td>${food.fats}</td>
                    <td>${food.proteins}</td>

                    <form method="post" action="${pageContext.request.contextPath}/WEB-INF/jsp/admin/editFood.jsp">

                        <input type="hidden" name="food_id" value="${food.id}">
                        <input type="hidden" name="food_name" value="${food.name}">
                        <input type="hidden" name="food_calories" value="${food.calories}">
                        <input type="hidden" name="food_carbs" value="${food.carbohydrates}">
                        <input type="hidden" name="food_fats" value="${food.fats}">
                        <input type="hidden" name="food_proteins" value="${food.proteins}">

                        <input type="hidden" name="current_page" value="${currentPage}">
                        <input type="hidden" name="no_of_pages" value="${noOfPages}">
                        <input type="hidden" name="records_per_page" value="${recordsPerPage}">

                        <td><input type="submit" value="Edit"></td>
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/app/deleteFood">
                        <input type="hidden" name="food_id" value="${food.id}">
                        <input type="hidden" name="current_page" value="${currentPage}">
                        <input type="hidden" name="no_of_pages" value="${noOfPages}">
                        <input type="hidden" name="records_per_page" value="${recordsPerPage}">
                        <td><input type="submit" value="Delete"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>--%>

        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}"><fmt:message key="previous.page"/></a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}"><fmt:message key="next.page"/></a>
                </li>
            </c:if>
        </ul>




</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>


</fmt:bundle>
