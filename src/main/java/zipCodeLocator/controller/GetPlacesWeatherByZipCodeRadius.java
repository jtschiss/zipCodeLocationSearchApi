package zipCodeLocator.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Get places weather by zip code radius.
 */
@WebServlet(
        urlPatterns = {"/getPlacesWeatherInfo"}
)

public class GetPlacesWeatherByZipCodeRadius extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String poi = req.getParameter("param1");
        String zipCode = req.getParameter("param2");
        int miles = Integer.parseInt(req.getParameter("param3"));

        CombinedAPIsInfo combinedAPIsInfo = new CombinedAPIsInfo();

        req.setAttribute("placeWeatherMap", combinedAPIsInfo.combinedInfo(poi,zipCode,miles));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

    }

}
