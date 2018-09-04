<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Admin page</title>
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

  <%--  <div>
        <a href="${pageContext.request.contextPath}/app/showAllFood">Show all food</a>
    </div>--%>


          <div class="user-container">
              <div class="user-container-header white__link">
                  Your Daily Summary
              </div>
              <div class="user-container-main row">
                  <div class="user-image-container col-lg-2">
                      <img class="user-image" src="<c:url value='/img/default-user-image.png'/>" alt="userPhoto">
                  </div>
                  <div class=" col-lg-8">
                      <div style="margin-bottom: 30px;"> ${sessionScope.login}</div>

                      <p>Calories remaining: </p>
                      <p style="color: lightgreen;"> ${sessionScope.calorieNorm} - ${sessionScope.consumedCalories} = ${sessionScope.difference}</p>
                      <div>
                          <p style="color: red;">${sessionScope.calorieNormExceeded}</p>
                      </div>
                  </div>
              </div>

          </div>


</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>




<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">

<jsp:include page="/jsp/menu.jsp"></jsp:include>

<br>
<br>
<h1>Hello, admin ${sessionScope.login}</h1>

<a href="${pageContext.request.contextPath}/app/logout">Log out</a>
    <br>
    <a href="${pageContext.request.contextPath}/jsp/admin/showAllFood.jsp">Show all food</a>
    <br>

    &lt;%&ndash;<a href="${pageContext.request.contextPath}/app/showAllUsersCommand">Show users</a>&ndash;%&gt;
    &lt;%&ndash;<br>&ndash;%&gt;

&lt;%&ndash;
<c:forEach items="${requestScope.users}" var="user" >
    <div class="row">
        <div class="col-lg-2">${user.id}</div>
        <div class="col-lg-2">${user.login}</div>
        <div class="col-lg-2"> ${user.password}</div>
        <div class="col-lg-2">${user.role}</div>
        <div class="col-lg-2">${user.email}</div>
&lt;%&ndash;

        <div class="col-lg-1"><input type="number" placeholder="gramms" name="food_quantity"></div>
        <div class="col-lg-1" style="margin-left:70px;"><input type="submit" value="Add"></div>
&ndash;%&gt;


    </div>
</c:forEach>&ndash;%&gt;





</div>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</body>
</html>

--%>
