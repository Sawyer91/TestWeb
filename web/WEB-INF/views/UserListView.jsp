<%--
  Created by IntelliJ IDEA.
  User: tdimo
  Date: 11.06.2020
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>User List</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Password</th>
        <th>email</th>
        <th>country</th>
        <th>role</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td>${user.role}</td>
            <td>
                <a href="editUser?id=${user.id}">Edit</a>
            </td>
            <td>
                <a href="deleteUser?id=${user.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
