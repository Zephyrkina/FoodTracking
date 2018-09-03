package ua.training.controller.config;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SecurityConfig {
    public static String ROLE_USER = "USER";
    public static String ROLE_ADMIN = "ADMIN";
    public static String ROLE_GUEST = "GUEST";

    //TODO make something with this class

    private static final Map<String, List<String>> roleAccessConfig = new ConcurrentHashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> userPatterns = new ArrayList<>();
        userPatterns.add("/user");
        //userPatterns.add("/app/showTodaysFoodList");

        roleAccessConfig.put(ROLE_USER, userPatterns);

        List<String> adminPatterns = new ArrayList<>();
        adminPatterns.add("/user");
        adminPatterns.add("/admin");

        roleAccessConfig.put(ROLE_ADMIN, adminPatterns);

       List<String> guestPatterns = new ArrayList<>();
        guestPatterns.add("/app/login");

        roleAccessConfig.put(ROLE_GUEST, guestPatterns);
    }

    public static Set<String> getAllAppRoles() { return roleAccessConfig.keySet(); }

    public static List<String> getUrlPatternsForRole(String role) { return roleAccessConfig.get(role); }


}
