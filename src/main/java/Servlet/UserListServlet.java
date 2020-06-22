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
import java.util.List;

@WebServlet("/admin/userListView")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = UserService.getInstance().getAllUsers();
        req.setAttribute("userList", list);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/UserListView.jsp");
        dispatcher.forward(req, resp);
    }
}
