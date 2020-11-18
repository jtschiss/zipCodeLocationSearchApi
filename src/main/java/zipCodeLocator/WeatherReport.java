package zipCodeLocator;

import javax.json.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class WeatherReport {

	private final Logger logger = LogManager.getLogger(this.getClass());

	public void getWeather() {

		JsonObject jsonWeatherForecast = null;

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://api.weather.gov/points/39.7456/-97.0892");
		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper mapper = new ObjectMapper();
		logger.info("This worked.");
	}
}
