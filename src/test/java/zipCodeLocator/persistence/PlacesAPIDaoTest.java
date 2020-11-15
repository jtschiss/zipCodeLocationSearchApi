package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlacesAPIDaoTest {
    @Test
    void getPlacesByRadiusSuccess() {
        PlacesAPIDao dao = new PlacesAPIDao();
        assertEquals("Pitcher's Pub", dao.getPlacesInfo().getResults().get(0).getPoi().getName());
    }
}