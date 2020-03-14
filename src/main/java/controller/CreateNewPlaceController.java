package controller;

import constant.Constant;
import constant.siteInfo;
import models.Place;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.PlaceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateNewPlaceController", urlPatterns = "/create-new-place")
public class CreateNewPlaceController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String street1 = request.getParameter("street");
        String ward = request.getParameter("ward");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));
        boolean active = true;
        float latitude_second = Float.parseFloat(request.getParameter("latitude"));
        float longtitude_second = Float.parseFloat(request.getParameter("longtitude"));
        String phone = request.getParameter("phone");
        String img = request.getParameter("img");

        Place placeModel = new Place();
        placeModel.setName(name);
        placeModel.setDescription(description);
        placeModel.setStreet1(street1);
        placeModel.setWard(ward);
        placeModel.setDistrict(district);
        placeModel.setCity(city);
        placeModel.setState(state);
        placeModel.setCountry(country);
        placeModel.setZipCode(zipCode);
        placeModel.setActive(active);
        placeModel.setLatitude_second(latitude_second);
        placeModel.setLongtitude_second(longtitude_second);
        placeModel.setPhone(phone != null ? Long.parseLong(phone) : null);
        placeModel.setImg(img);

        PlaceService placeService = new PlaceService();
        int placedId = placeService.createNewPlace(placeModel);

        if (placedId == 0) {
            request.setAttribute("isPlaced", false);
        } else {
            request.setAttribute("isPlaced", true);
        }

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("siteName", siteInfo.PROJECT_NAME);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Constant.ADMIN_VIEWS_PATH + "NewPlaceMain.jsp");
        dispatcher.forward(request, response);
    }


    protected Place getPlaceModel(HttpServletRequest request) throws Exception {
        Place placeModel = (Place) request.getAttribute(Place.NAME);

        if (placeModel == null) {
            placeModel = new Place();
            request.setAttribute(placeModel.NAME, placeModel);
        }

        return placeModel;
    }
}
