/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.UserDTO;
import utils.AuthUtils;

@WebFilter(filterName = "NewFilter", urlPatterns = {"/main", "/welcome.jsp", "/createExam.jsp", "/createQuestion.jsp", "/takeExam.jsp", "/viewResult.jsp", "/detail.jsp"})
public class UserFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public UserFilter() {
    }

    // Phương thức trước khi xử lý request
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("UserFilter:DoBeforeProcessing");
        }
    }

    // Phương thức sau khi xử lý request
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("UserFilter:DoAfterProcessing");
        }
    }

    // Phương thức thực hiện filter
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getRequestURI();
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        UserDTO user = (session != null) ? (UserDTO) session.getAttribute("user") : null;

        if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png")
                || url.endsWith(".jpg") || url.endsWith(".woff2")) {
            chain.doFilter(req, res);
            return;
        }

        // Cho phép không cần đăng nhập: login, register
        if (url.endsWith("login.jsp") || url.endsWith("register.jsp")
                || "login".equals(action) || "register".equals(action)) {
            chain.doFilter(req, res);
            return;
        }

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

//        if ("Instructor".equals(user.getRole())) {
//            if ("takeExam".equals(action) || "submitExam".equals(action)) {
//                response.sendRedirect(request.getContextPath() + "/main?action=viewCategory");
//                return;
//            }
//        }
        // Student không được làm instructor action
//        if ("Student".equals(user.getRole())) {
//            if ("createNewExam".equals(action) || "addQuestion".equals(action)) {
//                response.sendRedirect(request.getContextPath() + "/main?action=viewCategory");
//                return;
//            }
//        }
        chain.doFilter(req, res);
    }

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    // Phương thức hủy filter
    public void destroy() {
    }

    // Phương thức khởi tạo filter
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("UserRoleFilter:Initializing filter");
            }
        }
    }

    // Phương thức log
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
