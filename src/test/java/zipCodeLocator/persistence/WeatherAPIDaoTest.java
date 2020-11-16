package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAPIDaoTest {
    @Test
    void getWeatherSuccess() {
        WeatherAPIDao dao = new WeatherAPIDao();
        assertEquals("Madison", dao.getWeatherInfo().getCity());
    }
}
