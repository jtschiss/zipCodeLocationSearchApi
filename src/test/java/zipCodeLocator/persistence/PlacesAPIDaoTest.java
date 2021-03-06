package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Places api dao test.
 */
public class PlacesAPIDaoTest {
    /**
     * Gets places by radius success.
     */
    @Test
    void getPlacesByRadiusSuccess() {
        PlacesAPIDao dao = new PlacesAPIDao();
        String poi = "outdoor restaurant";
        double lat = 43.0324;
        double lng = -89.3843;
        int radius = 600;

        assertEquals("Milio's Sandwiches", dao.getPlacesInfo(poi,lat,lng,radius).getResults().get(0).getPoi().getName());
    }
}