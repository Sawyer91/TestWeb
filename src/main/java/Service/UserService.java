package Service;

import DAO.UserJdbcDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public void addUser(User user) {
        try {
            new UserJdbcDAO().addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser (int id) {
        User user = null;
        try {
            user = new UserJdbcDAO().getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList = null;
        try {
            userList = new UserJdbcDAO().getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean deleteUser(int id) {
        boolean res = false;
        try {
            res = new UserJdbcDAO().deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public boolean updateUser(User user) {
        boolean res = false;

        try {
            res = new UserJdbcDAO().updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
