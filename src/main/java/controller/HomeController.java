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
import java.util.List;

@WebServlet("/list")
public class HomeController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = userDao.getAllUsers();
        request.setAttribute("userslist", users);
        request.getRequestDispatcher("index.jsp")
                .forward(request, response);
    }

    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
