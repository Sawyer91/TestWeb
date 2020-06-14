<%--
  Created by IntelliJ IDEA.
  User: tdimo
  Date: 11.06.2020
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Add User</h3>


<form method="POST" action="${pageContext.request.contextPath}/addUser">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="name" value= "${user.name}" /> </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value= "${user.email}" /> </td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value= "${user.country}" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>


<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
