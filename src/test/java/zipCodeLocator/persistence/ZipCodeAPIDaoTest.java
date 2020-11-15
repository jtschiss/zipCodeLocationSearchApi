package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipCodeAPIDaoTest {
    @Test
    void getZipCodeSuccess() {
        ZipCodeAPIDao dao = new ZipCodeAPIDao();
        assertEquals("Madison", dao.getZipCodeInfo().getCity());
    }
}
