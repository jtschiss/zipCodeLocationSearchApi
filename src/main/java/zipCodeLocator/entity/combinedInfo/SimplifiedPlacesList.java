package zipCodeLocator.entity.combinedInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedPlacesList {
    @JsonProperty("places")
    private List<PlaceWeatherInfo> places = new ArrayList<>();

    public SimplifiedPlacesList() {
    }

    public List<PlaceWeatherInfo> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceWeatherInfo> places) {
        this.places = places;
    }

    public void addPlace(PlaceWeatherInfo place) {
        System.out.println("adding place: " + place);
        this.places.add(place);
    }

    @Override
    public String toString() {
        return "SimplifiedPlacesList{" +
                "places=" + places +
                '}';
    }
}
