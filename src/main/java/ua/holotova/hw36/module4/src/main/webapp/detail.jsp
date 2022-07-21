<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<section>
    <h3>Detail info</h3>
    <jsp:useBean id="detail" scope="request" class="model.Detail"/>
    <tr>
        <td>ID: ${detail.id} | Date: ${detail.date} | Time for detail production: ${detail.timeForDetail} | Fuel: ${detail.fuel} | Broken: ${detail.brokenSchema}</td>
        <td><a href="bot?action=update">Update</td>
    </tr>
</section>
</body>
</html>