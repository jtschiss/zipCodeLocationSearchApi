package zipCodeLocator.entity.weatherInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getTempF() {
		return tempF;
	}

	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	@Override
	public String toString() {
		return "Weather{" +
				"city='" + city + '\'' +
				", weather='" + weather + '\'' +
				", sunset='" + sunset + '\'' +
				", relativeHumidity='" + relativeHumidity + '\'' +
				", state='" + state + '\'' +
				", sunrise='" + sunrise + '\'' +
				", tempF='" + tempF + '\'' +
				'}';
	}
}