<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Home page</title>
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
<jsp:include page="/jsp/header.jsp"></jsp:include>
<jsp:include page="/jsp/menu.jsp"></jsp:include>

<div class="container main__login__part">
    <h1>Welcome to our food tracker</h1>
    <div class="row">
        <div class="col-lg-6 text-block">
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
        </div>
        <div class="col-lg-6 text-block">
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
        </div>
    </div>


</div>
</div>
<jsp:include page="/jsp/footer.jsp"></jsp:include>

</body>
</html>

<%--
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    &lt;%&ndash;<link rel="stylesheet" href="../css/bootstrap.css">&ndash;%&gt;
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>



<body>
<div class="container">
    <jsp:include page="/jsp/header.jsp"></jsp:include>
&lt;%&ndash;
<jsp:include page="/jsp/menu.jsp"></jsp:include>
&ndash;%&gt;

<br>

<a href="${pageContext.request.contextPath}/jsp/login.jsp">Login</a>
</div>
</body>
</html>
--%>
