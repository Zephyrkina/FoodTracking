package ua.training.controller.utils;

import java.util.List;
import java.util.Set;

public class SecurityUtils {

    public boolean isSecurityPage(String urlPattern) {

        Set<String> roles = RoleAccessUtils.getAllAppRoles();
        for (String role : roles) {
            List<String> urlPatterns = RoleAccessUtils.getUrlPatternsForRole(role);

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

    public boolean hasPermission(String urlPattern, String userRole) {
        Set<String> allRoles = RoleAccessUtils.getAllAppRoles();
        for(String role : allRoles) {
            if(!role.equals(userRole)){
                continue;
            }
            List<String> urlPatterns = RoleAccessUtils.getUrlPatternsForRole(role);
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
