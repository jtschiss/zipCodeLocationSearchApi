package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Weather api dao test.
 */
public class WeatherAPIDaoTest {
    /**
     * Gets weather success.
     */
    @Test
    void getWeatherSuccess() {
        WeatherAPIDao dao = new WeatherAPIDao();
        assertEquals("Madison", dao.getWeatherInfo("53713").getCity());
    }
}
