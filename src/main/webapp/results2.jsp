<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/17/20
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Places & Weather search by-ZipCode-radius</title>
</head>
<body>
<div class="container-fluid">
    <div id="text">
        <table border=1 cellpadding=5>


            <tr><th>PlaceName</th>
                <th>PlacePhone</th>
                <th>Score</th>
                <th>Website</th>
                <th>Address</th>
                <th>Weather</th>
            </tr>

            <c:forEach var="place" items="${requestScope.placesList.places}">
                <tr>
                    <td>${place.name}</td>
                    <td>${place.phoneNumber}</td>
                    <td>${place.score}</td>
                    <td>${place.address}</td>
                    <td>${place.website}</td>
                    <td>${place.weather}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
