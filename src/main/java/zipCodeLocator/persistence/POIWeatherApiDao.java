package zipCodeLocator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.combinedInfo.PlaceWeatherInfo;
import zipCodeLocator.entity.combinedInfo.SimplifiedPlacesList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class POIWeatherApiDao {
    //HttpServletRequest req;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public SimplifiedPlacesList getPlacesInfo (String poi, String zip, int miles) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://52.15.182.169:8080//zipCodeLocationSearchApi_war/services/POIWeatherAPI?poi="+poi+"&zip="+zip+"&miles="+miles);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info("response: " + response);
        ObjectMapper mapper = new ObjectMapper();
        SimplifiedPlacesList places = null;
        try {
            places = mapper.readValue(response, SimplifiedPlacesList.class);
            logger.info("places: " + places);
        } catch (JsonProcessingException e) {
            logger.error("POIWeatherApiDao mapper.readValue() error: " + e);
        }
        return places;
    }
}
