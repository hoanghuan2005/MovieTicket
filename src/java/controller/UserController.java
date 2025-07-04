/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserDTO;
import utils.PassUtils;

/**
 *
 * @author SUPPER LOQ
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

    private static final String WELCOME_PAGE = "welcome.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String REGISTER_PAGE = "register.jsp";

    private static final UserDAO userDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;

        try {
            String action = request.getParameter("action");
            if ("login".equals(action)) {
                url = handleLogin(request, response);
            } else if ("logout".equals(action)) {
                url = handleLogout(request, response);
            } else if ("register".equals(action)) {
                url = handleRegister(request, response);
            } else {
                request.setAttribute("checkError", "Invalid action " + action);
                url = LOGIN_PAGE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("checkError", "System error occurred!");
            url = "error.jsp";
        } finally {
            if (url != null) {
                request.getRequestDispatcher(url).forward(request, response);
            }
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

    private String handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String encryptPassword = PassUtils.encryptSHA256(password);

        if (userDAO.login(username, encryptPassword)) {
            UserDTO user = userDAO.getUserByUsername(username);
            session.setAttribute("user", user);

            response.sendRedirect("main?action=viewCategory");
            return null;
        } else {
            request.setAttribute("checkError", "Username or password incorrect!");
            return LOGIN_PAGE;
        }
    }

    private String handleLogout(HttpServletRequest request, HttpServletResponse response) {
        String url = LOGIN_PAGE;

        try {
            HttpSession session = request.getSession();
            if (session != null) {
                Object objUser = session.getAttribute("user");
                UserDTO user = (objUser != null) ? (UserDTO) objUser : null;
                if (user != null) {
                    session.invalidate();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return url;
    }

    private String handleRegister(HttpServletRequest request, HttpServletResponse response) {
        String url = REGISTER_PAGE;

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // kiểm tra user đã nhập form chưa
        if (username == null || name == null || password == null) {
            return url;
        }

        UserDTO existUser = userDAO.getUserByUsername(username);
        if (existUser != null) {
            request.setAttribute("checkError", "Username already exists");
            return url;
        }

        UserDTO resUser = new UserDTO();
        resUser.setName(username);
        resUser.setName(name);
        resUser.setPassword(PassUtils.encryptSHA256(password));

        boolean success = userDAO.register(resUser);

        if (success) {
            request.setAttribute("message", "Register successful! Please login.");
            url = LOGIN_PAGE;
        } else {
            request.setAttribute("checkError", "Registration failed. Please try again.");
        }
        return url;
    }
}
