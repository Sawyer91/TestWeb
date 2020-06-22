<%--
  Created by IntelliJ IDEA.
  User: tdimo
  Date: 13.06.2020
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edit Product</h3>


<c:if test="${not empty user}">
    <form method="POST" action="${pageContext.request.contextPath}/admin/editUser">
        <input type="hidden" name="id" value="${user.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${user.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${user.name}" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="${user.password}" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="${user.email}" /></td>
            </tr>
            <tr>
                <td>country</td>
                <td><input type="text" name="country" value="${user.country}" /></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><input type="text" name="role" value="${user.role}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/UserListView.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>