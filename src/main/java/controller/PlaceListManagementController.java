package controller;

import constant.Constant;
import models.Place;
import services.PlaceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PlaceListManagementController", urlPatterns = {"/place-list"})
public class PlaceListManagementController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlaceService placeService = new PlaceService();
        List places = placeService.listAllPlace();
        request.setAttribute("listPlace", places);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Constant.ADMIN_VIEWS_PATH + "PlaceList.jsp");
        dispatcher.forward(request, response);
    }

}
