package DAO;

import model.User;

import java.util.List;

public interface UserDAO  {
    public void addUser(User user);
    public User getUser(int id);
    public List<User> getAllUsers();
    public void deleteUser(User user);
    public void updateUser(User user);
    public User findUser(String name);
}
