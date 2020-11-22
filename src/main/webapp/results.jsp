<%--
  Created by IntelliJ IDEA.
  User: jeeva
<<<<<<< HEAD
  Date: 11/17/20
  Time: 7:42 PM
=======
  Date: 11/18/20
  Time: 3:28 PM
>>>>>>> origin/main
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Places & Weather search by-ZipCode-radius</title>

</head>
<head>
    <title>Places & Weather search by ZipCode</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-content w3-light-gray" style="width:100%;height:100%">

    <table class="w3-table-all">
        <thead>
        <tr class="w3-light-grey">
            <th colspan="2"><h3><strong>Places & Weather search results by ZipCode</strong></h3></th>
        </tr>
        </thead>

        <c:if test="${empty requestScope.placeWeatherMap}">
            <thead>
            <tr class="w3-light-grey">
                <th>No places found! Try another zipcode / Increase the search radius.</th>
            </tr>
            </thead>
        </c:if>

        <c:if test="${not empty requestScope.placeWeatherMap}">
            <thead>
            <tr class="w3-light-grey">
                <th><h4><strong>Place</strong></h4></th>
                <th><h4><strong>Weather</strong></h4></th>
            </tr>
            </thead>

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
