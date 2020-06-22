<%--
  Created by IntelliJ IDEA.
  User: tdimo
  Date: 17.06.2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Login Page</h3>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value= "${user.userName}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value= "${user.password}" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
            </td>
        </tr>
    </table>
</form>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
