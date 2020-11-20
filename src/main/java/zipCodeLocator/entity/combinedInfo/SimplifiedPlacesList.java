package zipCodeLocator.entity.combinedInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Simplified places list.
 */
public class SimplifiedPlacesList {
    @JsonProperty("places")
    private List<PlaceWeatherInfo> places = new ArrayList<>();

    /**
     * Instantiates a new Simplified places list.
     */
    public SimplifiedPlacesList() {
    }

    /**
     * Gets places.
     *
     * @return the places
     */
    public List<PlaceWeatherInfo> getPlaces() {
        return places;
    }

    /**
     * Sets places.
     *
     * @param places the places
     */
    public void setPlaces(List<PlaceWeatherInfo> places) {
        this.places = places;
    }

    /**
     * Add place.
     *
     * @param place the place
     */
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
