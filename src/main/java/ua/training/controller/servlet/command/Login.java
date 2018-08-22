package ua.training.controller.servlet.command;

import ua.training.model.dao.implement.UserDao;
import ua.training.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Login implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        AtomicReference<UserDao> dao = (AtomicReference<UserDao>) request.getServletContext().getAttribute("dao");

        String page;

        //аутентификация запускается один раз для текущей сессии

        if (dao.get().userIsExist(login, password)) {
            if (request.getServletContext().getAttribute(login) != null) {
                ((HttpSession) request.getServletContext().getAttribute(login)).invalidate();
            }
            User.ROLE role = dao.get().getRoleByLoginPassword(login, password);

            request.getSession().setAttribute("login", login);

            request.getServletContext().setAttribute(login, request.getSession());
            request.getSession().setAttribute("role", role);

            page = moveToPage(request, response, role);

        } else {
             page = moveToPage(request, response, User.ROLE.GUEST);
        }


       /* JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        JDBCCarDao jdbcCarDao = jdbcDaoFactory.createCarDao();
        jdbcCarDao.findAll();
*/

        return page;

    }

    private String moveToPage(HttpServletRequest request, HttpServletResponse response, User.ROLE role) throws IOException {
        if (role.equals(User.ROLE.ADMIN)){
            return  "redirect:/jsp/admin/admin_page.jsp";

        } else if (role.equals(User.ROLE.USER)){
            return "redirect:/jsp/user/user_page.jsp";

        } else {
            return "redirect:/jsp/index.jsp";
        }
    }
}
