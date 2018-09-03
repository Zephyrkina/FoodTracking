<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


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
    <div class="row col-md-6">
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
        </table>

        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                         href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </div>



</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>



<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>


<div class="container">



    <jsp:include page="/jsp/menu.jsp"></jsp:include>

    <br>

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
<div class="row col-md-6">
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

                <form method="post" action="${pageContext.request.contextPath}/jsp/admin/editFood.jsp">

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
    </table>

    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                     href="showAllFood?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</div>




</div>


<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

</body>
</html>
--%>
