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

            <c:if test="${not empty requestScope.places.results}">
            <tr><th>PlaceName</th>
                <th>PlacePhone</th>
                <th>Score</th>
                <th>Website</th>
                <th>Address</th>
                <th>Weather</th>
            </tr>

            <c:forEach var="count1" begin="0" end="${requestScope.places.results.size()-1}">
            <tr>
                <td> ${requestScope.places.results.get(count1).poi.name} </td>
                <td> ${requestScope.places.results.get(count1).poi.phone} </td>
                <td> ${requestScope.places.results.get(count1).score} </td>
                <td> ${requestScope.places.results.get(count1).poi.url} </td>
                <td> ${requestScope.places.results.get(count1).address.freeformAddress} </td>

                <c:forEach var="count2" begin="0" end="${requestScope.weatherList.size()-1}">
                    <c:if test="${requestScope.weatherList.get(count2).city.equals(requestScope.places.results.get(count1).address.municipality)}">
                        <td>tempF: ${requestScope.weatherList.get(count2).tempF} <br>
                            info: ${requestScope.weatherList.get(count2).weather} <br>
                            humidity: ${requestScope.weatherList.get(count2).relativeHumidity} <br>
                            windMPH: ${requestScope.weatherList.get(count2).windMPH} <br>
                            windDir: ${requestScope.weatherList.get(count2).windDir}
                        </td>
                    </c:if>
                </c:forEach>

            </tr>
            </c:forEach>
            </c:if>

                <c:if test="${empty requestScope.places.results}">
                   <tr><th> No places found! Try another zipcode / increase the search radius.</th></tr>
                </c:if>
        </table>
    </div>
</div>
</body>
</html>
