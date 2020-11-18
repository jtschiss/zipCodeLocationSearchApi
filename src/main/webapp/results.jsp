<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/14/20
  Time: 5:37 PM
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
        <TABLE border=1 cellpadding=5>
          <c:if test="${!empty zipCode}">
            <tr><th>PlaceName</th>
            <th>PlacePhone</th>
            <th>Score:</th>
            <th>Website</th>
            <th>Address:</th>
            <th>Weather:</th>

            </tr>

    <c:forEach var="place" items="${requestScope.places.results}">
        <tr>
            <td> ${place.poi.name} </td>
            <td> ${place.poi.phone} </td>
            <td> ${place.score} </td>
            <td> ${place.poi.url} </td>
            <td> ${place.address.freeformAddress} </td>
            <!--TODO: loop through the weatherList to get the weather for each zip code-->
            <td> ${requestScope.weatherList.contains(place.address.postalCode)} </td>
        </tr>
    </c:forEach>
</c:if>
<!--
<h4>ZipCode Info:</h4>
${requestScope.zipCode}
<h4>Places Info:</h4>
${requestScope.places}
<h4>Weather Info:</h4>
${requestScope.weather}
-->

</body>
</html>
