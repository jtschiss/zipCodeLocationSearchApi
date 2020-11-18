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


            <tr>
                <th>Place</th>
                <th>Weather</th>
            </tr>

            <c:forEach var="place" items="${requestScope.placesList.places}">
                <tr>
                    <td>Name: ${place.name}<br/>
                        Phone: ${place.phoneNumber}<br/>
                        Score: ${place.score}<br/>
                        Address: ${place.address}<br/>
                        Website: ${place.website}<br/>
                    </td>
                    <td>Weather: ${place.weather.weather}<br/>
                        Temp: ${place.weather.tempF}<br/>
                        Humidity: ${place.weather.relativeHumidity}<br/>
                        Wind Speed: ${place.weather.windMPH}MPH<br/>
                        Wind Direction: ${place.weather.windDir}
                    </td>
                </tr>
            </c:forEach>

        </table>

        <a href="index.jsp">Back to home</a>
    </div>
</div>
</body>
</html>
