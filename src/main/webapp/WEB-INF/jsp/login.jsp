<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Login</title>
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




<%--
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
--%>

<div class="row">
    <div class="text-center login__container" style="padding:50px 0">
        <div class="logo">login</div>
        <!-- Main Form -->
        <div class="login-form-1">
            <form id="login-form" class="text-left" method="post" action="${pageContext.request.contextPath}/app/login">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">
                        <div class="form-group">
                            <label for="lg_username" class="sr-only">Username</label>
                            <input type="text"  name="input_login" value="${requestScope.input_login}" class="form-control" id="lg_username"  placeholder="username">
                        </div>

                        <div class="error-alert">${requestScope.userNotFound}</div>
                        <div class="error-alert">${wrong_input_login} </div>

                        <div class="form-group">
                            <label for="lg_password" class="sr-only">Password</label>
                            <input type="password" name="input_password" class="form-control" id="lg_password" placeholder="password">
                        </div>

                        <div class="error-alert">${wrong_input_password}</div>
                      <%--  <div class="form-group login-group-checkbox">
                            <input type="checkbox" id="lg_remember" name="lg_remember">
                            <label for="lg_remember">remember</label>
                        </div>--%>
                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                </div>
                <div class="etc-login-form">
                    <p></p>
                    <p>new user? <a href="${pageContext.request.contextPath}/app/registration"> create new account</a></p>
                </div>
            </form>
        </div>
        <!-- end:Main Form -->
    </div>


<%--<div class="col-lg-6">
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut nisi quis diam tempor porta quis in ante.
            Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Praesent auctor
            molestie laoreet. Nulla ornare tristique porttitor. Suspendisse tempus quis purus vitae semper. Vestibulum
            libero ante, venenatis id nunc sit amet, fringilla mattis leo. Donec facilisis eget ipsum sit amet interdum.
            In ut orci sapien. Proin sodales magna vel augue vulputate rhoncus. Curabitur consectetur turpis lacus, sit
            amet lacinia elit rutrum nec. Sed bibendum diam sed dui placerat, a maximus justo interdum. Nunc ultrices
            velit at magna tristique, eget fringilla nisl facilisis. Praesent consequat pretium vehicula.

            In et leo vulputate, lacinia enim a, consequat lorem. Mauris viverra lorem at porttitor consequat.
            Pellentesque et ante in mauris vulputate lobortis vitae in ipsum. Vestibulum maximus in mauris non sodales.
            Donec vestibulum, est sed fringilla rhoncus, ligula odio facilisis lacus, sit amet fermentum dui turpis quis
            nulla. Ut ullamcorper ex ac libero gravida, a porttitor diam vehicula. Phasellus sodales, nulla molestie
            cursus vulputate, enim enim tristique metus, quis tristique eros ligula vel dolor.

            Maecenas tincidunt ut purus in finibus. Phasellus dictum et quam at accumsan. Sed quis viverra metus.
            Vivamus condimentum rutrum mi ac dictum. Curabitur sit amet efficitur lorem. Proin tempor eleifend urna id
            eleifend. Nulla gravida convallis bibendum. Aliquam vestibulum erat vitae tincidunt feugiat.

            Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque neque orci,
            elementum nec erat nec, vestibulum ultrices risus. Class aptent taciti sociosqu ad litora torquent per
            conubia nostra, per inceptos himenaeos. Nam a sem scelerisque, pellentesque tellus quis, vulputate ante.
            Aenean in semper nulla. Suspendisse a nulla auctor urna fermentum porta. Integer efficitur massa ex, quis
            luctus nibh sodales id.

            Proin a est placerat, lobortis nisl sed, dignissim lorem. Morbi suscipit lectus sit amet libero convallis
            tristique. Vivamus quis facilisis orci. Duis eu nisl massa. Quisque non interdum orci, et bibendum orci.
            Nunc ut lacus ac diam accumsan accumsan. Curabitur hendrerit efficitur magna et molestie. Cras aliquam velit
            et nibh consectetur interdum.
        </p>
    </div>--%>
  <%--  <div class="login__container">
        <fmt:bundle basename="pagecontent">


            <h1> <fmt:message key="login.welcome"/></h1><br/>
            <form method="post" action="${pageContext.request.contextPath}/app/login">

                <fmt:message key="page.login"/><br>
                <input type="text" name="input_login" value="${requestScope.input_login}"><br/>
                    ${requestScope.userNotFound}
                    ${wrong_input_login}
                <br>
                <fmt:message key="page.password"/><br>
                <input type="password" name="input_password">
                <br/>
                    ${wrong_input_password}
                <br/>
                    ${nullPage}
                <br/>


                <input class="button" type="submit" value="<fmt:message key="login.button"/>">

            </form>
            <br/>
            &lt;%&ndash;  <a href="${pageContext.request.contextPath}/jsp/registration.jsp"><fmt:message key="registration.page"/></a>
              <br>
          <a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="logout"/></a>&ndash;%&gt;
        </fmt:bundle>
    </div>--%>

</div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

</body>
</html>
