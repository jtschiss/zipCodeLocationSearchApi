package zipCodeLocator.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


/**
 * The type Zip code api dao.
 * @author JeevaG
 */
public class ZipCodeAPIDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String zipCodeAPIKey = "6bU0kf6E3P3qVULCcL7PQBrASoOpqy9WE0QbBPePRCkZSgefiNoOYmfX8aHNXYuM";
    //private final String zipCode = "53713";


    /**
     * Gets zip codes by radius.
     *
     * @return zipcodes
     */
    public ZipCode getZipCodeInfo(String zipCode) {
        //ZipCode zipCode = new ZipCode();
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://www.zipcodeapi.com/rest/"+zipCodeAPIKey+"/info.json/"+zipCode+"/degrees");
        //https://www.zipcodeapi.com/rest/<api_key>/info.<format>/<zip_code>/<units>
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ZipCode zipCodeResult = null;
        try {
            zipCodeResult = mapper.readValue(response, ZipCode.class);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error("ZipCodeAPIDao mapper.readValue() error: " + e);
        }
        return zipCodeResult;
    }
}
