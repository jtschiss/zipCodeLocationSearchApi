package zipCodeLocator.controller;

import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.placesInfo.Summary;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;
import zipCodeLocator.persistence.PlacesAPIDao;
import zipCodeLocator.persistence.WeatherAPIDao;
import zipCodeLocator.persistence.ZipCodeAPIDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/getPlacesWeatherByZipCodeRadius"}
)

public class GetPlacesWeatherByZipCodeRadius extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Weather> weatherList = new ArrayList<>();
        String poi = req.getParameter("param1");
        String zip = req.getParameter("param2");
        int miles = Integer.parseInt(req.getParameter("param3"));

        ZipCodeAPIDao zipDao = new ZipCodeAPIDao();
        ZipCode zipCode = zipDao.getZipCodeInfo(zip);
        req.setAttribute("zipCode", zipCode);

        PlacesAPIDao placesAPIDao = new PlacesAPIDao();
        //PlacesAPI takes the input for radius in meters. Hence, the conversion.
        Places places = placesAPIDao.getPlacesInfo(poi,zipCode.getLat(),zipCode.getLng(),1609 * miles);
        req.setAttribute("places", places);

        int placesCount = places.getSummary().getNumResults();
        WeatherAPIDao weatherAPIDao = new WeatherAPIDao();
        //generating weather for each place based on its zip code
        for(int count = 0; count < placesCount; count++) {
            String weatherZipCode = places.getResults().get(count).getAddress().getPostalCode();
            //checking if weatherList already contains the zipCode
            //if not then we populate the weather for that zipCode and add it to the list
            if(!weatherList.contains(weatherZipCode)) {
                weatherList.add(weatherAPIDao.getWeatherInfo(weatherZipCode));
            }
        }

        req.setAttribute("weatherList", weatherList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }

}
