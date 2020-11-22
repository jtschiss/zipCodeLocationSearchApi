package zipCodeLocator.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import zipCodeLocator.controller.CombinedAPIsInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Poi weather api.
 */
@Path("/poi-weather-api")
public class POIWeatherApi {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets weather.
     * @return the weather
     */
    // The Java method will process HTTP GET requests
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getPlacesWeatherURI() {
        String output = "<HTML><h1>Places Weather API Web Service</h1>" +
                "<h2>append the following to the URI, substitute the values & fetch the json response.</h2>" +
                "<h3>{poi}/{zipCode}/{miles}</h3></HTML>";
        return Response.status(200).entity(output).build();
    }

    /**
     * Gets weather.
     * @param poi   the poi
     * @param zipCode   the zipCode
     * @param miles the miles
     * @return the weather
     */
    @Path("/{poi}/{zipCode}/{miles}")
    // The Java method will process HTTP GET requests
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeather(
            @PathParam("poi") String poi,
            @PathParam("zipCode") String zipCode,
            @PathParam("miles") int miles) throws NullPointerException {

        CombinedAPIsInfo combinedAPIsInfo = new CombinedAPIsInfo();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(combinedAPIsInfo.combinedInfo(poi,zipCode,miles));
        } catch (JsonProcessingException e) {
            logger.error("JSON processing exception: " + e);
        }

        return Response.status(200).entity(json).build();
    }

}
