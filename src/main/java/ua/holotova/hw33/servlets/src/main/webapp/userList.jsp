<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
    <table border="1"> <caption><b>USERS INFORMATION</b></caption>
            <thead>
                <tr>
                    <th>IP</th>
                    <th>User-Agent</th>
                    <th>Request time</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${usersList}">
                <tr>
                    <td><b>${user.ip}</b></td>
                    <td><b>${user.userAgent}</b></td>
                    <td>${user.currentTime}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
