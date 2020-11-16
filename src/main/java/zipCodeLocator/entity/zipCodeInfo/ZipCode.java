package zipCodeLocator.entity.zipCodeInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getLat() {
		return lat;
	}

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