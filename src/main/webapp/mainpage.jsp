<%--
  Created by IntelliJ IDEA.
  User: sazzad
  Date: 3/31/15
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form action="/addEmployee" method="post">
        <table>
            <tr>
                <td>First Name :</td>
                <td><input type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form>
</div>
<div class="list_employee">
    <table>
        <c:forEach items="${employeeList}" var="each">
            <tr>
                <td>First Name</td>
                <td>${each.firstName}</td>
                <td>Last Name</td>
                <td>${each.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
