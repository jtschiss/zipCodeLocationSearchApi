package zipCodeLocator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.placesInfo.ResultsItem;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;
import zipCodeLocator.persistence.PlacesAPIDao;
import zipCodeLocator.persistence.WeatherAPIDao;
import zipCodeLocator.persistence.ZipCodeAPIDao;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Combined info dao.
 */
public class CombinedAPIsInfo {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Map<ResultsItem, Weather> placeWeatherMap = new HashMap<>();

    /**
     * Combined info map.
     *
     * @param poi     the poi
     * @param zipCode the zip code
     * @param miles   the miles
     * @return the map
     * @throws NullPointerException the null pointer exception
     */
    public Map<ResultsItem, Weather> combinedInfo(String poi, String zipCode, int miles) {

        ZipCodeAPIDao zipDao = new ZipCodeAPIDao();
        ZipCode zip = zipDao.getZipCodeInfo(zipCode);

        PlacesAPIDao placesAPIDao = new PlacesAPIDao();
        //PlacesAPI takes the input for radius in meters. Hence, the conversion.
        Places places = placesAPIDao.getPlacesInfo(poi,zip.getLat(),zip.getLng(), 1609 * miles);

        WeatherAPIDao weatherAPIDao = new WeatherAPIDao();
        try {
            //generating weather for each place based on its zip code
            int placesCount = places.getSummary().getNumResults();
            if(placesCount > 0) {
                for(int count = 0; count < placesCount; count++) {
                    String weatherZipCode = places.getResults().get(count).getAddress().getPostalCode();
                    //String city = places.getResults().get(count).getAddress().getMunicipality();
                    placeWeatherMap.put(places.getResults().get(count), weatherAPIDao.getWeatherInfo(weatherZipCode));
                }
            }
        } catch(NullPointerException nullPointerException) {
            logger.error("null pointer exception: " , nullPointerException);
        } catch (Exception e) {
            logger.error("exception: " + e);
        }
        finally {
            return placeWeatherMap;
        }
    }

}
