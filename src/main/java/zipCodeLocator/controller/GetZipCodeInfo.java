package zipCodeLocator.controller;

import zipCodeLocator.entity.placesInfo.Places;
import zipCodeLocator.entity.placesInfo.Summary;
import zipCodeLocator.entity.zipCodeInfo.ZipCode;
import zipCodeLocator.persistence.PlacesAPIDao;
import zipCodeLocator.persistence.ZipCodeAPIDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/getZipCodeInfo"}
)

public class GetZipCodeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //int id = Integer.parseInt(req.getParameter("param1"));
        String poi = req.getParameter("param1");
        String zip = req.getParameter("param2");
        int miles = Integer.parseInt(req.getParameter("param3"));
        //ZipCode(zip);

        //ZipCode zipCode = new ZipCode(zip);
        //zipCode.setZipCode(zip);
        ZipCodeAPIDao zipDao = new ZipCodeAPIDao();
        //zipDao
        req.setAttribute("lat", zipDao.getZipCodeInfo().getLat());
        req.setAttribute("lng", zipDao.getZipCodeInfo().getLng());
        double lat = zipDao.getZipCodeInfo().getLat();
        double lng = zipDao.getZipCodeInfo().getLng();

        /*Places places = new Places();
        Summary summary = new Summary();
        summary.setQuery(poi);
        places.setSummary(summary);*/
        PlacesAPIDao placesAPIDao = new PlacesAPIDao();
        placesAPIDao.getPlacesInfo().getResults().get(0).getPoi().getName();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }

}
