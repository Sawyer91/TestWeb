package Service;

import model.User;
import util.PropertyReader;

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
        PropertyReader.getDAO().addUser(user);
    }

    public User getUser (int id) {
        return PropertyReader.getDAO().getUser(id);
    }

    public List<User> getAllUsers() {
       return PropertyReader.getDAO().getAllUsers();
    }

    public void deleteUser(User user) {
        PropertyReader.getDAO().deleteUser(user);
    }

    public void updateUser(User user) {
        PropertyReader.getDAO().updateUser(user);
    }

    public User findUser (String name) {
        return PropertyReader.getDAO().findUser(name);
    }
}
