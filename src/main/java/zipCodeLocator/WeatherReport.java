package zipCodeLocator;

import javax.ws.rs.core.UriBuilder;
import javax.json.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpEntity<T>;
import org.apache.http.util.EntityUtils;
import java.nio.charset.Charset;
import javax.json.JsonArray;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WeatherReport {

	private final Logger logger = LogManager.getLogger(this.getClass());

	public void getWeather() {

		JsonObject jsonWeatherForecast = null;

		Client client = ClientBuilder.newClient();
		WebTarget target =
				client.target("https://api.weather.gov/points/39.7456/-97.0892");
		String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper mapper = new ObjectMapper();
		logger.info("This worked.");
		// 39.7456,-97.0892
	}
}