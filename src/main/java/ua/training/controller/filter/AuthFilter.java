package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import ua.training.controller.utils.SecurityUtils;
import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/*")
public class AuthFilter implements Filter {
    static final org.apache.logging.log4j.Logger log = LogManager.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String role =  (String) request.getSession().getAttribute("role");

        if (role == null) {
            request.getSession().setAttribute("role", User.ROLE.GUEST.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        SecurityUtils securityUtils = new SecurityUtils();

        if (securityUtils.isSecurityPage(request.getRequestURI())) {
            boolean hasPermission = securityUtils.hasPermission(request.getRequestURI(), request.getSession().getAttribute("role").toString());
            if (!hasPermission) {
                log.warn("Unauthorized access attempt");
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
