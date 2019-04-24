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
import java.util.Optional;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (Objects.equals(userId, null)) {
            request.getRequestDispatcher("/list")
                    .forward(request, response);
        } else {
            int id = Integer.parseInt(userId);
            Optional<User> user = userDao.findUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/list")
                    .forward(request, response);
        }
    }
}
