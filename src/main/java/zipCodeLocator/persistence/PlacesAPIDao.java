package zipCodeLocator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.placesInfo.Summary;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PlacesAPIDao {
    //HttpServletRequest req;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String key = "qtXNgL1yfaZxG4ueo78gTD1wJaikhC88";

    //ZipCodeAPIDao zipCodeAPIDao = new ZipCodeAPIDao();
    //double lat = zipCodeAPIDao.getZipCodeInfo("53713").getLat();
    //double lng = zipCodeAPIDao.getZipCodeInfo("53713").getLng();

    //String poi = "outdoor+restaurant";
    //int radius = 600;

    public Places getPlacesInfo (String poi, double lat, double lng, int radius) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.tomtom.com/search/2/search/"+poi+".json?&countrySet=US&&lat="+lat+"&lon="+lng+"&radius="+radius+"&idxSet=POI,addr&key="+key);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Places places = null;
        try {
            places = mapper.readValue(response, Places.class);
        } catch (JsonProcessingException e) {
            logger.error("PlacesAPIDao mapper.readValue() error: " + e);
        }
        return places;
    }
}
