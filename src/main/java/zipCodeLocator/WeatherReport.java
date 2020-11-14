package zipCodeLocator;

import javax.ws.rs.core.UriBuilder;
import javax.json.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity<T>;
import org.apache.http.util.EntityUtils;
import java.nio.charset.Charset;
import javax.json.JsonArray;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WeatherReport {

//	UriBuilder builder = new UriBuilder("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast");
//
//
//
//	builder.queryParam("aggregateHours","24")
//			.setParameter("contentType","json")
//			.setParameter("locationMode","single")
//			.setParameter("unitGroup","metric")
//			.setParameter("key","1PYNQ6AWUDJE9AFERDCHJHSXK")
//			.setParameter("locations","London,UK");

	JsonObject jsonWeatherForecast = null;

	Client client = ClientBuilder.newClient();
	WebTarget target =
			client.target("https://api.weather.gov/points/");
	String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
	ObjectMapper mapper = new ObjectMapper();
	// 39.7456,-97.0892

//	HttpGet get = new HttpGet(builder.build());
//	CloseableHttpClient httpclient = HttpClients.createDefault();
//	CloseableHttpResponse response = httpclient.execute(get);

	try	{
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			System.out.printf("Bad response status code:%d%n", response.getStatusLine().getStatusCode());
			return;
		}

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String rawResult = EntityUtils.toString(entity, Charset.forName("utf-8"));
			jsonWeatherForecast = new JsonObject(rawResult);
		}

	} finally 	{
		response.close();
	}

	JsonObject location = jsonWeatherForecast.getJsonObject("location");

	System.out.println("Weather forecast for: %s%n",location.getString("address"));

	JsonArray values = location.getJsonArray("values");

	System.out.println("Date\tMaxTemp\tMinTemp\tChangeofPrecip%n");

	for (int i = 0; i < values.length(); i++) {
		JsonObject forecastValue = values.getJsonObject(i);
		String datetimeString = forecastValue.getString("datetimeStr");
		ZonedDateTime datetime = ZonedDateTime.parse(datetimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

		double maxtemp = forecastValue.getJsonNumber("maxt");
		double mintemp = forecastValue.getJsonNumber("mint");
		double pop = forecastValue.getJsonNumber("pop");

		System.out.printf("%s\t%.1f\t%.1f\t%.0f%n", datetime.format(DateTimeFormatter.ISO_LOCAL_DATE), maxtemp, mintemp, pop);
	}
}