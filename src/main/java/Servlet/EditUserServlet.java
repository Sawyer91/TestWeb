package Servlet;

import Service.UserService;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/editUser")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = UserService.getInstance().getUser(id);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/editUserView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String role = req.getParameter("role");

        User user = new User(id, name, password, email, country, role);
        UserService.getInstance().updateUser(user);
        req.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/admin/userListView");
    }
}
