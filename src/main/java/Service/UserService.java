package Service;

import DAO.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public void addUser(User user) {
        try {
            new UserDAO().addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUser (int id) {
        return new UserDAO().getUser(id);
    }

    public List<User> getAllUsers() {
        return new UserDAO().getAllUsers();
    }

    public boolean deleteUser(int id) {
        boolean res = false;
        try {
            res = new UserDAO().deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean updateUser(User user) {
        boolean res = false;

        try {
            res = new UserDAO().updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
