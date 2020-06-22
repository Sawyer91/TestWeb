package Servlet;

import Service.UserService;
import model.User;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = UserService.getInstance().findUser(name);
        HttpSession session = req.getSession();
        session.setAttribute("loginUser", user);

        if (user.getRole().equals("admin") && user.getPassword().equals(password)) {
            resp.sendRedirect(req.getContextPath() + "/admin/userListView");
        } else if (user.getRole().equals("user") && user.getPassword().equals(password)) {
            resp.sendRedirect(req.getContextPath() + "/userInfo");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/loginView.jsp");
        dispatcher.forward(req, resp);
    }
}
