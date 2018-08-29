package ua.training.controller.filter;

import ua.training.controller.config.SecurityConfig;
import ua.training.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        //TODO check if "app/*" passess

        String servletPath = request.getServletPath();

        System.out.println("session  in do filter: " + request.getSession().getId());
        String login = (String) request.getSession().getAttribute("login");
        String role =  (String) request.getSession().getAttribute("role");

        if (role == null) {
            request.getSession().setAttribute("role", User.ROLE.GUEST.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        //TODO try to remove double if

        if (isSecurityPage(request)) {
            boolean hasPermission = hasPermission(request);
            if (!hasPermission) {
                request.getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(request, response);
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean isSecurityPage(HttpServletRequest request) {
        //String urlPattern = UrlPatternUtils.getUrlPattern(request);
        String urlPattern =  request.getRequestURI();
        System.out.println("urlPattern " + urlPattern);

        Set<String> roles = SecurityConfig.getAllAppRoles();
        System.out.println(roles);

        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null ) {
                for (String patterns : urlPatterns) {
                    if (urlPattern.contains(patterns)){
                        System.out.println("role + permission: " + role + " " + urlPattern);

                        return true;
                    }

                }
            }
        }
        return false;
    }

    // Проверить имеет ли данный 'request' подходящую роль?
    private boolean hasPermission(HttpServletRequest request) {
        String urlPattern = request.getRequestURI();
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        String userRole = request.getSession().getAttribute("role").toString();

        for(String role : allRoles) {
            if(!role.equals(userRole)){
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null ) {
                for (String patterns : urlPatterns) {
                    if (urlPattern.contains(patterns)){
                        System.out.println("role + permission: " + role + " " + urlPattern);

                        return true;
                    }

                }
            }
        }
        return false;
    }
}
