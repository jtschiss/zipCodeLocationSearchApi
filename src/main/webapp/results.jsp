<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/14/20
  Time: 5:37 PM<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <tr><th>PlaceName</th>
                <th>PlacePhone</th>
                <th>Score:</th>
                <th>Website</th>
                <th>Address:</th>
                <th>Weather:</th>

            </tr>

            <c:forEach var="place" items="${requestScope.places.results}">
            <tr>
                <td>name : ${place.poi.name} <br>
                    phone : ${place.poi.phone} <br>
                    score : ${place.score} <br>
                    website : ${place.poi.url} <br>
                    address : ${place.address.freeformAddress} <br>
                </td>
                <c:forEach var="weatherInfo" items="${requestScope.weatherList}">
                    <c:if test="${weatherInfo.city.equals(place.address.municipality)}">
                        <td>tempF : ${weatherInfo.tempF} <br>
                            info : ${weatherInfo.weather} <br>
                            humidity : ${weatherInfo.relativeHumidity} <br>
                            windMPH : ${weatherInfo.windMPH} <br>
                            windDir : ${weatherInfo.windDir} <br>
                        </td>

                    </c:if>
                    <!--TODO... Once the above if statement is executed, we need to break out of the forEach loop-->
                </c:forEach>
            </tr>
            </c:forEach>
            </c:if>

        </table>
    </div>
</body>
</html>