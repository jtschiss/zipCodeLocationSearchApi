<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="head.jsp" />
<body>

<div class="w3-content" style="width:100%;height:100%">

<div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:100%">
    <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
    <h1>Thank you for using the Zip Code Location Search API!</h1>
    <p>To use this API, just enter a zip code, a radius in miles around that zip code, and a place of interest (POI)
    to search for (such as restaurants).  You will get information about each POI with that radius of the zip code,
    including the weather for each of them.</p>
    </br>

    <form action="getZipCodeInfo" method="GET" class="pure-form">

        <h4>Place of interest:</h4>
        <input type="text" name="param1" value="" />
        <h4>Zip code:</h4>
        <input type="text" name="param2" value="" />
        <h4>Radius (in miles):</h4>
        <input type="text" name="param3" value="" />

        <button class="pure-button">Search</button>
        </br></br>

    </form>

    <a href="documentation.jsp">Click here</a> for the documentation.

</div>
</div>

</body>
</html>
