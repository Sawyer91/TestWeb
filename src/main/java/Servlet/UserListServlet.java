package Servlet;

import Service.UserHibernateService;
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

@WebServlet("/userListView")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<User> list = new UserService().getAllUsers();
        List<User> list = UserHibernateService.getInstance().getAll();
        req.setAttribute("userList", list);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/UserListView.jsp");
        dispatcher.forward(req, resp);
    }
}
