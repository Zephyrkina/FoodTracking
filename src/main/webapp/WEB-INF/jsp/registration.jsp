<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Registration</title>
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
<div class="container main__login__part">
    <!-- REGISTRATION FORM -->
    <div class="text-center" style="padding:50px 0">
        <div class="logo">register</div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="register-form" class="text-left" action="${pageContext.request.contextPath}/app/registration" method="post">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">



                        <div class="form-group">
                            <label for="reg_username" class="sr-only">Username</label>
                            <input type="text" name="user_name" value="${user_name}" class="form-control" id="reg_username" placeholder="username">
                        </div>

                        <div class="error-alert">${wrong_user_name}</div>

                        <div class="form-group">
                            <label for="reg_login" class="sr-only">Login</label>
                            <input type="text" name="user_login" value="${user_login}"class="form-control" id="reg_login" placeholder="login">
                        </div>

                        <div class="error-alert"> ${wrong_user_login}</div>
                        <div class="error-alert"> ${notUniqueLogin}</div>

                        <div class="form-group">
                            <label for="reg_password" class="sr-only">Password</label>
                            <input type="password" name="user_password" value="${user_password}" class="form-control" id="reg_password"placeholder="password">
                        </div>
                        <div class="error-alert"> ${wrong_user_password}</div>
                        <div class="form-group">
                            <label for="reg_password_confirm" class="sr-only">Password Confirm</label>
                            <input type="password" name="user_password_repeat" value="${user_password_repeat}" class="form-control" id="reg_password_confirm" placeholder="confirm password">
                        </div>
                        <div class="error-alert"> ${wrong_user_password_repeat}</div>

                        <div class="form-group">
                            <label for="reg_email" class="sr-only">Email</label>
                            <input type="text" name="user_email" value="${user_email}" class="form-control" id="reg_email" name="reg_email" placeholder="email">
                        </div>
                        <div class="error-alert"> ${wrong_user_email}</div>
                        <div class="error-alert"> ${notUniqueEmail}</div>

                        <div class="form-group">
                            <label for="reg_age" class="sr-only">Age</label>
                            <input type="number" name="user_age" value="${user_age}" class="form-control" id="reg_age"  placeholder="age">
                        </div>
                        <div class="error-alert"> ${wrong_user_age}</div>

                        <div class="form-group">
                            <label for="reg_height" class="sr-only">Height</label>
                            <input type="number" name="user_height" value="${user_height}" placeholder="height"  class="form-control" id="reg_height">
                        </div>
                        <div class="error-alert"> ${wrong_user_height}</div>

                        <div class="form-group">
                            <label for="reg_weight" class="sr-only">Weight</label>
                            <input type="number" name="user_weight" value="${user_weight}" placeholder="weight"  class="form-control" id="reg_weight">
                        </div>
                        <div class="error-alert"> ${wrong_user_weight}</div>

                        <div class="form-group login-group-checkbox">
                            <input type="radio" class="" name="user_activity" value="low" checked id="low" placeholder="username">
                            <label for="low">low activity</label>

                            <input type="radio" class="" name="user_activity" value="normal"  id="normal" placeholder="username">
                            <label for="normal">normal activity</label>

                            <input type="radio" class="" name="user_activity" value="high"  id="high" placeholder="username">
                            <label for="high">high activity</label>

                        </div>


                    <%--<div class="form-group login-group-checkbox">
                            <input type="radio" class="" name="reg_gender" id="male" placeholder="username">
                            <label for="male">male</label>

                            <input type="radio" class="" name="reg_gender" id="female" placeholder="username">
                            <label for="female">female</label>
                        </div>--%>

                      <%--  <div class="form-group login-group-checkbox">
                            <input type="checkbox" class="" id="reg_agree" name="reg_agree">
                            <label for="reg_agree">i agree with <a href="#">terms</a></label>
                        </div>--%>
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p>already have an account? <a href="${pageContext.request.contextPath}/app/login">login here</a></p>
                </div>
            </form>
        </div>
        <!-- end:Main Form -->
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
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    <br>
    <br>
&lt;%&ndash;
    <h1>Hello, ${sessionScope.login}</h1>
&ndash;%&gt;


    <br>
    <form action="${pageContext.request.contextPath}/app/registration" method="post">
        <label>Registration</label>
        <br>
        <input type="text" name="user_name" value="${user_name}" placeholder="Name" required>
        <br>
        ${wrong_user_name}
        <br>
        <input type="text" name="user_login" value="${user_login}" placeholder="Login" required>
        <br>
        ${wrong_user_login}
        ${notUniqueLogin}
        <br>
        <input type="password" name="user_password" value="${user_password}" placeholder="Password" required>
        <br>
        ${wrong_user_password}
        <br>
        <input type="password" name="user_password_repeat" value="${user_password_repeat}" placeholder="Repeat password" required>
        <br>
        ${wrong_user_password_repeat}
        <br>
        <input type="text" name="user_email" value="${user_email}" placeholder="E-mail" required>
        <br>
        ${wrong_user_email}
        ${notUniqueEmail}
        <br>
        <input type="number" name="user_age" value="${user_age}" placeholder="Age" required>
        <br>
        ${wrong_user_age}
        <br>
        <input type="number" name="user_height" value="${user_height}" placeholder="Height" required>
        <br>
        ${wrong_user_height}
        <br>
        <input type="number" name="user_weight" value="${user_weight}" placeholder="Weight" required>
        <br>
        ${wrong_user_weight}
        <br>
        <input type="radio" name="user_activity" value="low" checked>Low activity
        <br>
        <input type="radio" name="user_activity" value="normal" >Normal activity
        <br>
        <input type="radio" name="user_activity" value="high">High activity
        <br>

        <br>


        <input class="button" type="submit" value="Register">
    </form>
    <p>${errorMessage}</p>


</div>
</body>
</html>
--%>
