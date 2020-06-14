package Service;

import DAO.UserJdbcDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public void addUser(User user) {
        new UserJdbcDAO().addUser(user);
    }

    public User getUser (int id) {
        return new UserJdbcDAO().getUser(id);
    }

    public List<User> getAllUsers() {
       return new UserJdbcDAO().getAllUsers();
    }

    public void deleteUser(User user) {
        new UserJdbcDAO().deleteUser(user);
    }

    public void updateUser(User user) {
         new UserJdbcDAO().updateUser(user);
    }
}
