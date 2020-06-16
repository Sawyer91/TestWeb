package Service;

import DAO.UserJdbcDAO;
import Factory.UserDaoFactory;
import model.User;

import java.util.List;

public class UserService {

    private static  UserService Instance;

    public static  UserService getInstance() {
        if (Instance == null) {
            Instance = new UserService();
        }
        return Instance;
    }

    public UserService() {
    }

    public void addUser(User user) {
        UserDaoFactory.getDAO().addUser(user);
    }

    public User getUser (int id) {
        return UserDaoFactory.getDAO().getUser(id);
    }

    public List<User> getAllUsers() {
       return UserDaoFactory.getDAO().getAllUsers();
    }

    public void deleteUser(User user) {
        UserDaoFactory.getDAO().deleteUser(user);
    }

    public void updateUser(User user) {
         UserDaoFactory.getDAO().updateUser(user);
    }
}
