package zipCodeLocator.entity.zipCodeInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Zip code.
 */
public class ZipCode{

	@JsonProperty("lng")
	private double lng;

	@JsonProperty("city")
	private String city;

	@JsonProperty("timezone")
	private Timezone timezone;

	@JsonProperty("acceptable_city_names")
	private List<AcceptableCityNamesItem> acceptableCityNames;

	@JsonProperty("area_codes")
	private List<Integer> areaCodes;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip_code")
	private String zipCode;

	@JsonProperty("lat")
	private double lat;

	/**
	 * Gets lng.
	 *
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * Sets lng.
	 *
	 * @param lng the lng
	 */
	public void setLng(double lng) {
		this.lng = lng;
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
	 * Sets city.
	 *
	 * @param city the city
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * Gets zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets zip code.
	 *
	 * @param zipCode the zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Sets lat.
	 *
	 * @param lat the lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "ZipCode{" +
				"lng=" + lng +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipCode='" + zipCode + '\'' +
				", lat=" + lat +
				'}';
	}
}