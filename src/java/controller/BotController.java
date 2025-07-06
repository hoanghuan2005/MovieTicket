/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BookingDAO;
import dao.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import model.MovieDTO;

/**
 *
 * @author SUPPER LOQ
 */
@WebServlet(name = "BotController", urlPatterns = {"/bot"})
public class BotController extends HttpServlet {

    private static final MovieDAO movieDAO = new MovieDAO();
    private static final BookingDAO bookingDAO = new BookingDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BotController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BotController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message").toLowerCase();
        String reply;

        if (message.contains("phim mới")) {
            List<MovieDTO> movies = movieDAO.getLatestMovies();
            reply = "🎬 Phim mới: " + movies.stream()
                    .map(MovieDTO::getTitle)
                    .collect(Collectors.joining(", "));
        } else if (message.contains("hài") || message.contains("hành động")) {
            reply = "📢 Gợi ý thể loại: phim hài sắp chiếu: 'Mr. Bean trở lại', 'Đại náo học đường'...";
        } else if (message.contains("lịch") || message.contains("chiếu")) {
            reply = "🎥 Bạn có thể xem lịch chiếu trong trang phim hoặc hỏi 'phim chiếu hôm nay'";
        } else {
            reply = "🤖 Tôi có thể giúp bạn về: phim mới, phim theo thể loại, lịch chiếu, hướng dẫn đặt vé.";
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"reply\":\"" + reply.replace("\"", "\\\"") + "\"}");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
