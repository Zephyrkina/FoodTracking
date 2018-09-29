package ua.training.model.service;

import org.junit.*;
import ua.training.model.builder.UserBuilder;
import ua.training.model.entity.User;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService;
    User user;

    @Before
    public void setUp() {
        userService = new UserService();
        user = new UserBuilder()
                .setName("name1")
                .setLogin("login1")
                .setPassword("11111")
                .setRole(User.ROLE.USER)
                .setActivity(User.LIFE_ACTIVITY.NORMAL)
                .build();
    }

    @After
    public void tearDown() {
        userService.deleteUser(user);
    }


    @Test
    public void getUserRoleByLoginPassword() {
        String expected = User.ROLE.USER.toString();
        String actual = userService.getRoleByLoginPassword("user", "123").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAdminRoleByLoginPassword() {
        String expected = User.ROLE.ADMIN.toString();
        String actual = userService.getRoleByLoginPassword("admin", "123").toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWrongRoleByLoginPassword() {
        String expected = User.ROLE.USER.toString();
        String actual = userService.getRoleByLoginPassword("admin", "123").toString();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void createUser() {
        userService.createUser(user);
        int userId = userService.getUserIdByLogin(user.getLogin());
        User actualUser = userService.findUserById(userId);
        user.setId(userId);
        Assert.assertEquals(user, actualUser);
    }

}