package zipCodeLocator.controller;

import zipCodeLocator.entity.combinedInfo.PlaceWeatherInfo;
import zipCodeLocator.entity.combinedInfo.SimplifiedPlacesList;
import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.placesInfo.Summary;
import zipCodeLocator.entity.weatherInfo.Weather;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;
import zipCodeLocator.persistence.POIWeatherApiDao;
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
        urlPatterns = {"/getPlacesFromForm"}
)

public class POIWeatherFromForm extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        POIWeatherApiDao dao = new POIWeatherApiDao();

        String poi = req.getParameter("param1");
        String zip = req.getParameter("param2");
        int miles = Integer.parseInt(req.getParameter("param3"));

        SimplifiedPlacesList places = dao.getPlacesInfo(poi, zip, miles);


        req.setAttribute("placesList", places);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results2.jsp");
        dispatcher.forward(req, resp);
    }
}
