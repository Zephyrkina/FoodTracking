<%--
  Created by IntelliJ IDEA.
  User: zephyrkina
  Date: 24.08.2018
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add own food</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">

<%--
add regexes
--%>


<form action="${pageContext.request.contextPath}/app/addOwnFood" method="post">
    <label>Input your type of food</label>
    <br>
    <input type="text" name="own_food_name" value="${own_food_name}" required>

    <br>
    ${wrong_own_food_name}
    <br>
    <input type="number" name="own_food_calories" value="${own_food_calories}" required>
    <br>
    ${wrong_own_food_calories}
    <br>
    <input type="number" name="own_food_carbs" value="${own_food_carbs}" required>
    <br>
    ${wrong_own_food_carbs}
    <br>
    <input type="number" name="own_food_fats"  value="${own_food_fats}" required>
    <br>
    ${wrong_own_food_fats}
    <br>
    <input type="number" name="own_food_proteins" value="${own_food_proteins}" required>
    <br> ${wrong_own_food_proteins}
    <br>

    <input type="hidden" name="current_page" value="${current_page}">
    <input type="hidden" name="no_of_pages" value="${no_of_pages}">
    <input type="hidden" name="records_per_page" value="${records_per_page}">

    <input class="button" type="submit" value="Add">
</form>
</div>
</body>
</html>
