<html>
<body>

        <h1>Zip Code Location Search API</h1>

        <h2>Overview</h2>
        The Zip Code Location Search API provides a web-based solution to the problem of finding recreational activities
        within a given area, and determining if the weather will be appropriate for them.  It does this by taking user
        inputs for a zip code, a radius in miles, and a type of places of interest, or POIs (for example,
        "outdoor restaurants").  These inputs are then processed through a trio of already existing APIs: Tomtom,
        Interzoid, and zipcodeapi.com.

        First, the application feeds the zip code input into zipcodeapi.com, where it is geocoded.  The output of this
        first API includes, but is not limited to, the latitude and longitude of that zip code.  These coordinates,
        along with the user-specified radius in miles, are then fed into the Tomtom API, which uses its map function to
        find places of interest (POIs) within the calculated area.  The Tomtom output includes a zip code for each POI,
        which is then fed into the Interzoid API to determine the local weather in each location.

        <h2>index.jsp</h2>
        The application's homepage.  Here, the user enters the aforementioned inputs.

        <h2>results.jsp</h2>
        The results page.  Here, all examples of the POI within the user-specified area are displayed, along with the
        local weather for each of them.

        <h2>PlacesAPIDao.java</h2>
        This class retrieves all the POIs within the user-defined area.
        <h3>getPlacesInfo()</h3>
        This method returns a list of Places objects corresponding to the found POIs.

        <h2>WeatherAPIDao.java</h2>
        This class retrieves information about the weather within the user-defined area.
        <h3>getWeatherInfo()</h3>
        This method returns weather details.

        <h2>ZipCodeAPIDao.java</h2>
        This class retrieves information about the user-specified zip code.
        <h3>getZipCodeInfo.java</h3>
        This method returns the zip code data.

        <h2>How to use Zip Code Location Search as a Service</h2>
        <h3>API Call Format</h3>
        <p>http://52.15.182.169:8080//zipCodeLocationSearchApi_war/services/POIWeatherAPI?poi=&lt;poi&gt;&zip=&lt;zip&gt;&miles=&lt;miles&gt;</p>

        <h3>Parameters</h3>
        <h4>poi</h4>
        <p>the point of interest you are searching for</p>
        <h4>zip</h4>
        <p>the zip code you would like to search</p>
        <h4>miles</h4>
        <p>the radius in miles that you would like to search</p>
</body>
</html>