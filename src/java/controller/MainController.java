/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author SUPPER LOQ
 */
@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";

    private boolean isUserAction(String action) {
        return "login".equals(action)
                || "logout".equals(action)
                || "register".equals(action)
                || "updateProfile".equals(action)
                || "viewProfile".equals(action)
                || "changePassword".equals(action);
    }

    private boolean isMovieAction(String action) {
        return "listMovies".equals(action)
                || "searchMovies".equals(action)
                || "movieDetail".equals(action);
    }

    private boolean isCinemaAction(String action) {
        return "listCinemas".equals(action)
                || "cinemaDetail".equals(action);
    }

    private boolean isShowtimeAction(String action) {
        return "viewShowtimes".equals(action)
                || "showtimeDetail".equals(action);
    }

    private boolean isBookingAction(String action) {
        return "selectSeat".equals(action)
                || "confirmBooking".equals(action)
                || "bookingHistory".equals(action)
                || "cancelBooking".equals(action);
    }

    private boolean isPaymentAction(String action) {
        return "makePayment".equals(action)
                || "paymentResult".equals(action);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (isUserAction(action)) {
                url = "/user";
            } else if (isMovieAction(action)) {
                url = "/movie";
            } else if (isCinemaAction(action)) {
                url = "/cinema";
            } else if (isShowtimeAction(action)) {
                url = "/showtime";
            } else if (isBookingAction(action)) {
                url = "/booking";
            } else if (isPaymentAction(action)) {
                url = "/payment";
            } else {
                url = "/main";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(url);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
