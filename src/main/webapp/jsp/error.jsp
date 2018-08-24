<%--
  Created by IntelliJ IDEA.
  User: zephyrkina
  Date: 14.08.2018
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<h1> Error 404 </h1>
<p>Page not found</p>

<a href="${pageContext.request.contextPath}/jsp/index.jsp">На головну</a>
</div>
</body>
</html>
