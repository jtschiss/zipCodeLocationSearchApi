<!DOCTYPE html>
<html>

<head>
    <title>Places & Weather search by ZipCode</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<div class="w3-content w3-light-gray" style="width:100%;height:100%">
<!-- Header -->
    <header class="w3-container w3-blue-gray">
        <h1><strong>Zip Code Location Search API</strong></h1>
        <p><strong>This API provides a web-based solution to the problem of finding recreational activities
            within a given area, and determining if the weather will be appropriate for them.</strong></p>
    </header>

    <div class="w3-container w3-light-gray w3-left w3-border" style="width:100%;height:100%">
        <h4>Enter a <b>POI </b> (Place of Interest), <b>ZipCode</b> and <b>Miles</b> to search for places.</h4>
        <br>

        <form action="getPlacesWeatherInfo" method="GET">
            <h4>POI:</h4>
            <input class="w3-input w3-border" type="text" name="param1" value="" />
            <h4>ZipCode:</h4>
            <input class="w3-input w3-border" type="text" name="param2" value="" />
            <h4>Miles:</h4>
            <input class="w3-input w3-border" type="text" name="param3" value="" />

            <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
            <br><br>
        </form>

        <a href="documentation.jsp">Click here</a> for the documentation.
    </div>
</div>
</body>
</html>
