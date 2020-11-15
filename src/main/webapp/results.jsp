<%--
  Created by IntelliJ IDEA.
  User: jeeva
  Date: 11/14/20
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ZipCodeInfo</title>
    ${requestScope.lat}
    <form action="getZipCodeInfo" method="GET">

        <input class="w3-input w3-hidden" type="text" name="param1" value="${requestScope.lat}" />
        <input class="w3-input w3-hidden" type="text" name="param2" value="${requestScope.lng}" />

        <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
        </br></br>
    </form>
</head>
<body>

</body>
</html>
