<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/18/20
  Time: 3:28 PM
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
    <table border=1 cellpadding=5>

        <c:if test="${empty requestScope.places.results}">
            <tr><th> No places found! Try another zipcode / increase the search radius.</th></tr>
        </c:if>

        <c:if test="${not empty requestScope.places.results}">
            <tr><th colspan="2">Places of Interest with Weather Info</th></tr>>
            <tr>
                <th>Places</th>
                <th>Weather</th>
            </tr>

            <c:forEach var="placeWeather" items="${requestScope.placeWeatherMap}">
                <tr>
                    <td>
                        <b>Name: </b>${placeWeather.key.poi.name} <br>
                        <b>Phone: </b>${placeWeather.key.poi.phone}<br>
                        <b> Score: </b>${placeWeather.key.score}  <br>
                        <b>Website: </b>${placeWeather.key.poi.url} <br>
                        <b>Address:</b> ${placeWeather.key.address.freeformAddress} <br>
                    </td>
                    <td>
                        <b>Temperature (F): </b>${placeWeather.value.tempF} <br>
                        <b>Cloud cover: </b>${placeWeather.value.weather}<br>
                        <b> Humidity: </b>${placeWeather.value.relativeHumidity}  <br>
                        <b>Wind speed (MPH): </b>${placeWeather.value.windMPH} <br>
                        <b>Wind direction:</b> ${placeWeather.value.windDir} <br>
                    </td>

                </tr>

            </c:forEach>
        </c:if>

    </table>
</div>
</body>
</html>
