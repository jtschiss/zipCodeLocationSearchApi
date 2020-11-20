package zipCodeLocator.entity.weatherInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Weather.
 */
public class Weather {

	@JsonProperty("TempC")
	private String tempC;

	@JsonProperty("WindDir")
	private String windDir;

	@JsonProperty("AirQualityIndex")
	private String airQualityIndex;

	@JsonProperty("City")
	private String city;

	@JsonProperty("VisibilityMiles")
	private String visibilityMiles;

	@JsonProperty("Code")
	private String code;

	@JsonProperty("AirQualityCode")
	private String airQualityCode;

	@JsonProperty("Weather")
	private String weather;

	@JsonProperty("Sunset")
	private String sunset;

	@JsonProperty("Credits")
	private String credits;

	@JsonProperty("AirQuality")
	private String airQuality;

	@JsonProperty("RelativeHumidity")
	private String relativeHumidity;

	@JsonProperty("DaylightHours")
	private String daylightHours;

	@JsonProperty("State")
	private String state;

	@JsonProperty("DaylightMinutes")
	private String daylightMinutes;

	@JsonProperty("WindMPH")
	private String windMPH;

	@JsonProperty("Sunrise")
	private String sunrise;

	@JsonProperty("TempF")
	private String tempF;

	/**
	 * Gets wind dir.
	 *
	 * @return the wind dir
	 */
	public String getWindDir() {
		return windDir;
	}

	/**
	 * Sets wind dir.
	 *
	 * @param windDir the wind dir
	 */
	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	/**
	 * Gets wind mph.
	 *
	 * @return the wind mph
	 */
	public String getWindMPH() {
		return windMPH;
	}

	/**
	 * Sets wind mph.
	 *
	 * @param windMPH the wind mph
	 */
	public void setWindMPH(String windMPH) {
		this.windMPH = windMPH;
	}

	/**
	 * Gets city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets state.
	 *
	 * @param state the state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Sets city.
	 *
	 * @param city the city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets weather.
	 *
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * Sets weather.
	 *
	 * @param weather the weather
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * Gets sunset.
	 *
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}

	/**
	 * Sets sunset.
	 *
	 * @param sunset the sunset
	 */
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	/**
	 * Gets relative humidity.
	 *
	 * @return the relative humidity
	 */
	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	/**
	 * Sets relative humidity.
	 *
	 * @param relativeHumidity the relative humidity
	 */
	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	/**
	 * Gets sunrise.
	 *
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}

	/**
	 * Sets sunrise.
	 *
	 * @param sunrise the sunrise
	 */
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * Gets temp f.
	 *
	 * @return the temp f
	 */
	public String getTempF() {
		return tempF;
	}

	/**
	 * Sets temp f.
	 *
	 * @param tempF the temp f
	 */
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	@Override
	public String toString() {
		return "Weather{" +
				"windDir='" + windDir + '\'' +
				", city='" + city + '\'' +
				", weather='" + weather + '\'' +
				", relativeHumidity='" + relativeHumidity + '\'' +
				", windMPH='" + windMPH + '\'' +
				", tempF='" + tempF + '\'' +
				'}';
	}
}