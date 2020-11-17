<html>
<body>

        <h1>Zip Code Location Search API</h1>

        <h2>Overview</h2>
        The Zip Code Location Search API provides a web-based solution to the problem of finding outdoor restaurants
        within a given area, and determining if the weather will be appropriate for them.  It does this by combining the
        functions of three extant APIs: Tomtom, which finds outdoor restaurants through its map service; Interzoid,
        which provides access to weather data within the United States; and zipcodeapi.com, which geocodes the area
        within a given radius of a given zip code.

        <h2>index.jsp</h2>
        The application's homepage.  Here, the user enters a zip code, a radius (in miles) around that zip code, and a
        point of interest (POI) to find within that radius.

        <h2>results.jsp</h2>
        The results page.  Here, all examples of the POI within the radius of the zip code are displayed, along with the
        local weather in each case.

        <h2>PlacesAPIDao.java</h2>
        This class represents all the outdoor restaurants within the user-defined area.
        <h3>getPlacesInfo()</h3>
        This method returns a list of Places objects corresponding to the found restaurants.

        <h2>WeatherAPIDao.java</h2>
        This class represents information about the weather within the user-defined area.
        <h3>getWeatherInfo()</h3>
        This method returns weather details.

        <h2>ZipCodeAPIDao.java</h2>
        This class represents zip codes within the user-defined area.
        <h3>getZipCodeInfo.java</h3>
        This method returns zip codes by radius.

</body>
</html>