<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
    <table border="1"> <caption><b>Details INFORMATION</b></caption>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Time for one detail</th>
                    <th>Fuel</th>
                    <th>Broken Schemas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="detail" items="${detailList}">
                <tr>
                    <td>${detail.date}</td>
                    <td>${detail.timeForDetail}</td>
                    <td>${detail.fuel}</td>
                    <td>${detail.brokenSchema}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
