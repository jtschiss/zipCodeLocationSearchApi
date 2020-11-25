package zipCodeLocator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.utilities.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

/**
 * The type Weather api dao.
 */
public class WeatherAPIDao {

    PropertiesLoader loader = new PropertiesLoader();
    Properties properties = loader.loadProperties();
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String key = properties.getProperty("weatherAPIKey");

    /**
     * Gets weather info.
     *
     * @param zipCode the zip code
     * @return the weather info
     */
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
            logger.error("weatherInfoServiceDao mapper.readValue() error: " + e);
        }
        return weather;
    }
}
