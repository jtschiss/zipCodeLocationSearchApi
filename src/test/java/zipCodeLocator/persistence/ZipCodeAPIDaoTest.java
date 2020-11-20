package zipCodeLocator.persistence;

import org.junit.jupiter.api.Test;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Zip code api dao test.
 */
public class ZipCodeAPIDaoTest {
    /**
     * Gets zip code success.
     */
    @Test
    void getZipCodeSuccess() {
        ZipCodeAPIDao zipCodeAPIDao = new ZipCodeAPIDao();
        assertEquals("Madison", zipCodeAPIDao.getZipCodeInfo("53713").getCity());
    }
}
