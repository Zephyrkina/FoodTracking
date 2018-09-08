package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import ua.training.controller.servlet.command.Login;
import ua.training.controller.utils.SecurityUtils;
import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.*;


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


        System.out.println("session  in do filter: " + request.getSession().getId());
        String role =  (String) request.getSession().getAttribute("role");

        if (role == null) {
            request.getSession().setAttribute("role", User.ROLE.GUEST.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        //TODO try to remove double if

        if (isSecurityPage(request.getRequestURI())) {
            boolean hasPermission = hasPermission(request.getRequestURI(), request.getSession().getAttribute("role").toString());
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

    private boolean isSecurityPage(String urlPattern) {

        Set<String> roles = SecurityUtils.getAllAppRoles();
        for (String role : roles) {
            List<String> urlPatterns = SecurityUtils.getUrlPatternsForRole(role);

            if (urlPatterns != null ) {
                for (String patterns : urlPatterns) {
                    if (urlPattern.contains(patterns)){
                       return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean hasPermission(String urlPattern, String userRole) {
        Set<String> allRoles = SecurityUtils.getAllAppRoles();
        for(String role : allRoles) {
            if(!role.equals(userRole)){
                continue;
            }
            List<String> urlPatterns = SecurityUtils.getUrlPatternsForRole(role);
            if (urlPatterns != null ) {
                for (String patterns : urlPatterns) {
                    if (urlPattern.contains(patterns)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
