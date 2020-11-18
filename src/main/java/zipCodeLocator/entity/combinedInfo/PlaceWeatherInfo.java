package zipCodeLocator.entity.combinedInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceWeatherInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("score")
    private double score;

    @JsonProperty("website")
    private String website;

    @JsonProperty("address")
    private String address;

    @JsonProperty("weather")
    private String weather;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "PlaceWeatherInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", score=" + score +
                ", website='" + website + '\'' +
                ", address='" + address + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
