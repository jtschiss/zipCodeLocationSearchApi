package zipCodeLocator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.weatherInfo.Weather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WeatherAPIDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String key = "789bd133c074d9396b610f1e7c2d4fa3";

    //private final String zipCode = "53713";

    public Weather getWeatherInfo(String zipCode) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.interzoid.com/getweatherzipcode?license="+key+"&zip="+zipCode);
        //https://api.interzoid.com/getweatherzipcode?license=b8db26839ee70833a065558c101427f9&zip=53713
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = null;
        try {
            weather = mapper.readValue(response, Weather.class);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error("weatherInfoServiceDao mapper.readValue() error: " + e);
        }
        return weather;
    }
}
