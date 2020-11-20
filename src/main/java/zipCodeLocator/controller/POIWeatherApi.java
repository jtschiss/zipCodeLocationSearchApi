package zipCodeLocator.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import zipCodeLocator.entity.combinedInfo.PlaceWeatherInfo;
import zipCodeLocator.entity.combinedInfo.SimplifiedPlacesList;
import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;
import zipCodeLocator.persistence.PlacesAPIDao;
import zipCodeLocator.persistence.WeatherAPIDao;
import zipCodeLocator.persistence.ZipCodeAPIDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Poi weather api.
 */
public class POIWeatherApi {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets weather.
     *
     * @param poi   the poi
     * @param zip   the zip
     * @param miles the miles
     * @return the weather
     */
    @Path("/POIWeatherAPI")



        // The Java method will process HTTP GET requests
        @GET
        @Produces("application/json")
        public Response getWeather(
                @QueryParam("poi") String poi,
                @QueryParam("zip") String zip,
                @QueryParam("miles") int miles) {



            List<Weather> weatherList = new ArrayList<>();

            //used to get latitude and longitude for places
            ZipCodeAPIDao zipDao = new ZipCodeAPIDao();
            ZipCode zipCode = zipDao.getZipCodeInfo(zip);


            PlacesAPIDao placesAPIDao = new PlacesAPIDao();
            //PlacesAPI takes the input for radius in meters. Hence, the conversion.
            Places places = placesAPIDao.getPlacesInfo(poi,zipCode.getLat(),zipCode.getLng(),1609 * miles);

            WeatherAPIDao weatherAPIDao = new WeatherAPIDao();
            //Gets the weather for a zip code
            Weather weather = weatherAPIDao.getWeatherInfo(zipCode.getZipCode());

            int placesCount = places.getSummary().getNumResults();
//            WeatherAPIDao weatherAPIDao = new WeatherAPIDao();
//            //generating weather for each place based on its zip code
//            for(int count = 0; count < placesCount; count++) {
//                String weatherZipCode = places.getResults().get(count).getAddress().getPostalCode();
//                //checking if weatherList already contains the zipCode
//                //if not then we populate the weather for that zipCode and add it to the list
//                if(!weatherList.contains(weatherZipCode)) {
//                    weatherList.add(weatherAPIDao.getWeatherInfo(weatherZipCode));
//                }
//            }

            //Gets name, phone number, score, website, address, and weather info into an list
            ObjectMapper mapper = new ObjectMapper();
            SimplifiedPlacesList placeList = new SimplifiedPlacesList();
            PlaceWeatherInfo place = null;

            // looping through the list of places
            for(int count = 0; count < placesCount; count++) {
                // getting info from places list and using that do build a simplified object
                place = new PlaceWeatherInfo();
                place.setName(places.getResults().get(count).getPoi().getName());
                place.setPhoneNumber(places.getResults().get(count).getPoi().getPhone());
                place.setScore(places.getResults().get(count).getScore());
                place.setWebsite(places.getResults().get(count).getPoi().getUrl());
                place.setAddress(places.getResults().get(count).getAddress().getFreeformAddress());
                place.setWeather(weather);
                //adding object to the SimplifiedPlaceInfoList
                placeList.addPlace(place);
            }

            String json = null;

            try {
                json = mapper.writeValueAsString(placeList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // Return a json data
            return Response.status(200).entity(json).build();
        }
}
