package zipCodeLocator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipCode {
    @JsonProperty("zip")
    private int zip;

    @JsonProperty("distance")
    private double distance;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    public ZipCode() {
    }

    public ZipCode(int zip, double distance, String city, String state) {
        this.zip = zip;
        this.distance = distance;
        this.city = city;
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
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

    @Override
    public String toString() {
        return "ZipCode{" +
                "zip=" + zip +
                ", distance=" + distance +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}