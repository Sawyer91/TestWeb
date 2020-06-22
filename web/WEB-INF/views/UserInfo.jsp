<%--
  Created by IntelliJ IDEA.
  User: tdimo
  Date: 17.06.2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
    <hr />
    <p><%if (request.getAttribute("user") != null) {
        out.println("<p>" + request.getAttribute("user") + "</p>");
    }%></p>
    <p><%if (request.getAttribute("password") != null) {
        out.println("<p>" + request.getAttribute("password") + "</p>");
    }%></p>
    <p><%if (request.getAttribute("email") != null) {
        out.println("<p>" + request.getAttribute("email") + "</p>");
    }%></p>
    <p><%if (request.getAttribute("country") != null) {
        out.println("<p>" + request.getAttribute("country") + "</p>");
    }%></p>
    <p><%if (request.getAttribute("role") != null) {
        out.println("<p>" + request.getAttribute("role") + "</p>");
    }%></p>
    <hr />


    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
