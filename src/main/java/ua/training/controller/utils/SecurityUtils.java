package ua.training.controller.utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SecurityUtils {
    private static String ROLE_USER = "USER";
    private static String ROLE_ADMIN = "ADMIN";
    private static String ROLE_GUEST = "GUEST";

    //TODO make something with this class

    private static final Map<String, List<String>> roleAccessConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        List<String> userPatterns = new ArrayList<>();
        userPatterns.add("/user/showTodaysMeals");
        userPatterns.add("/user/addOwnFood");
        userPatterns.add("/user/profile");
        userPatterns.add("/user/findFoodByName");
        userPatterns.add("/user/addOwnFoodToDailyRecord");
        userPatterns.add("/user/changeLanguage");
        userPatterns.add("/user/logout");
        userPatterns.add("/user/savePreviousRecords");


        roleAccessConfig.put(ROLE_USER, userPatterns);

        List<String> adminPatterns = new ArrayList<>();
        adminPatterns.add("/user/showTodaysMeals");
        adminPatterns.add("/user/addOwnFood");
        adminPatterns.add("/user/profile");
        adminPatterns.add("/user/findFoodByName");
        adminPatterns.add("/user/addOwnFoodToDailyRecord");
        adminPatterns.add("/user/changeLanguage");
        adminPatterns.add("/user/logout");
        adminPatterns.add("/user/savePreviousRecords");
        adminPatterns.add("/admin/deleteFood");
        adminPatterns.add("/admin/editFood");
        adminPatterns.add("/admin/showAllFood");


        roleAccessConfig.put(ROLE_ADMIN, adminPatterns);

        List<String> guestPatterns = new ArrayList<>();
        guestPatterns.add("/guest/login");
        guestPatterns.add("/guest/registration");

        roleAccessConfig.put(ROLE_GUEST, guestPatterns);
    }

    public static Set<String> getAllAppRoles() { return roleAccessConfig.keySet(); }

    public static List<String> getUrlPatternsForRole(String role) { return roleAccessConfig.get(role); }


}
