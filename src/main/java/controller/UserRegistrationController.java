package controller;

import dao.UserDao;
import dao.implementation.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/register")
public class UserRegistrationController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/list")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String userId = request.getParameter("id");
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer salary = Integer.valueOf(request.getParameter("salary"));

        User user = new User()
                .setName(name)
                .setAge(age)
                .setSalary(salary);

        if (Objects.equals(userId, null)) {
            userDao.saveUser(user);
        } else {
            int id = Integer.parseInt(userId);
            user.setId(id);
            userDao.updateUser(user);
        }
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
