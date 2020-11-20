package zipCodeLocator.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Poi weather api controller.
 */
//Defines the base URI for all resource URIs.
@ApplicationPath("/services")

public class POIWeatherApiController extends Application {
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(POIWeatherApi.class );
        return h;
    }
}
