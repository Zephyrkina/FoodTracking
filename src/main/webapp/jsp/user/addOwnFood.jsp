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
</head>
<body>


<form action="${pageContext.request.contextPath}/app/addOwnFood" method="post">
    <label>Input your type of food</label>
    <input type="text" name="ownFoodName" required>
    <input type="number" name="ownFoodCalories" required>
    <input type="number"  name="ownFoodCarbs" required>
    <input type="number" name="ownFoodFats" required>
    <input type="number" name="ownFoodProteins" required>

    <input class="button" type="submit" value="Add">
</form>

</body>
</html>
