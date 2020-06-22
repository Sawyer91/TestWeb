package Servlet;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginUser");
        req.setAttribute("user", user.getName());
        req.setAttribute("password", user.getPassword());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("country", user.getCountry());
        req.setAttribute("role", user.getRole());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/UserInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
