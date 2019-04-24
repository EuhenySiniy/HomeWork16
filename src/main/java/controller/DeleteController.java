package controller;

import dao.UserDao;
import dao.implementation.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (Objects.equals(userId, null)) {
            request.getRequestDispatcher("/list")
                    .forward(request, response);
        } else {
            int id = Integer.parseInt(userId);
            UserDao dao = UserDaoImpl.getInstance();
            dao.deleteUser(id);
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }
}
