<html>
<body>

        <h1>Zip Code Location Search API</h1>

        <h2>Overview</h2>
        The Zip Code Location Search API provides a web-based solution to the problem of finding recreational activities
        within a given area, and determining if the weather will be appropriate for them.  It does this by taking user
        inputs for a zip code, a radius in miles, and a type of places of interest, or POIs (for example,
        "outdoor restaurants.")  These inputs are then processed through a trio of already existing APIs: Tomtom,
        Interzoid, and zipcodeapi.com.

        First, the application feeds the zip code input into zipcodeapi.com, where it is geocoded.  The output of this
        first API includes, but is not limited to, the latitude and longitude of that zip code.  These coordinates,
        along with the user-specified radius in miles, are then fed into the Tomtom API, which uses its map function to
        find (POIs) within the calculated area.  The Tomtom output includes a zip code for each POI,
        which is then fed into the Interzoid API to determine the local weather in each location.

        <h2>Example JSON Output</h2>

        http://52.15.182.169/zipCodeLocationSearchApi_war/services/POIWeatherAPI?poi=pizza&zip=53713&miles=10

        0
        name	"Badger Pizza"
        phoneNumber	"+(1)-(608)-2551313"
        score	2.5742862225
        website	null
        address	"2209 South Park Street, Madison, WI 53713"
        weather	"Mostly Cloudy"
        1
        name	"Rocky Rococo Pan Style Pizza"
        phoneNumber	"+(1)-(608)-2510304"
        score	2.5734164715
        website	"www.rockysmadison.com/"
        address	"1618 West Beltline Highway, Madison, WI 53713"
        weather	"Mostly Cloudy"
        2
        name	"Pizza Extreme"
        phoneNumber	"+(1)-(608)-2781800"
        score	2.5728752613
        website	"www.pizzaextreme.biz/"
        address	"2936 Fish Hatchery Road, Fitchburg, WI 53713"
        weather	"Mostly Cloudy"
        3
        name	"Pizza Extreme/Pizza Pit/Athens Gyros"
        phoneNumber	null
        score	2.5728657246
        website	null
        address	"Fish Hatchery Road, Fitchburg, WI 53713"
        weather	"Mostly Cloudy"
        4
        name	"Little Caesars"
        phoneNumber	"+(1)-(608)-2749900"
        score	2.5724573135
        website	"www.littlecaesars.com"
        address	"3042 Fish Hatchery Road, Fitchburg, WI 53713"
        weather	"Mostly Cloudy"
        5
        name	"Pizza Hut"
        phoneNumber	"+(1)-(608)-4424242"
        score	2.5715522766
        website	"www.pizzahut.com"
        address	"520 South Park Street, Madison, WI 53715"
        weather	"Mostly Cloudy"
        6
        name	"Falbo Brothers Pizza"
        phoneNumber	"+(1)-(608)-2559090"
        score	2.571233511
        website	"www.falbobros.com/"
        address	"406 South Park Street, Madison, WI 53715"
        weather	"Mostly Cloudy"
        7
        name	"Godfather's Pizza"
        phoneNumber	"+(1)-(608)-2749662"
        score	2.5706913471
        website	"www.godfathers.com"
        address	"2770 South Syene Road, Fitchburg, WI 53711"
        weather	"Mostly Cloudy"
        8
        name	"Uno Chicago Grill"
        phoneNumber	"+(1)-(608)-2550605"
        score	2.5704524517
        website	"www.unos.com"
        address	"612 West Main Street, Madison, WI 53703"
        weather	"Mostly Cloudy"
        9
        name	"Papa Murphy's"
        phoneNumber	"+(1)-(608)-2684444"
        score	2.5704333782
        website	"https://www.papamurphys.com/store-finder/WI/53507/WI031"
        address	"2980 Cahill Main, Fitchburg, WI 53711"
        weather	"Mostly Cloudy"

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
