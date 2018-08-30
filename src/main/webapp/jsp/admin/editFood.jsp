<%--
  Created by IntelliJ IDEA.
  User: zephyrkina
  Date: 30.08.2018
  Time: 19:21
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


    <form action="${pageContext.request.contextPath}/app/editFood" method="post">
        <label>Input your type of food</label>
        <input type="hidden" name="food_id" value="${param.food_id}">
        <br>
        <input type="text" name="food_name" value="${param.food_name}" required>
        <br>
        ${wrong_food_name}
        <br>
        <input type="number" name="food_calories" value="${param.food_calories}" required>
        <br>
        ${wrong_food_calories}
        <br>
        <input type="number" name="food_carbs" value="${param.food_carbs}" required>
        <br>
        ${wrong_food_carbs}
        <br>
        <input type="number" name="food_fats"  value="${param.food_fats}" required>
        <br>
        ${wrong_food_fats}
        <br>
        <input type="number" name="food_proteins" value="${param.food_proteins}" required>
        <br> ${wrong_food_proteins}
        <br>

        <input type="hidden" name="current_page" value="${param.current_page}">
        <input type="hidden" name="no_of_pages" value="${param.no_of_page}">
        <input type="hidden" name="records_per_page" value="${param.records_per_page}">


        <input class="button" type="submit" value="Edit">
    </form>
</div>
</body>
</html>