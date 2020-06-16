package DAO;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
        Connection connection = null;
        try {
            connection = DBHelper.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (Exception s) {
            s.printStackTrace();
        }
    }

    public User getUser(int id) {
        String sql = "SELECT id,name,email,country FROM users where id = ?";
        User user = null;
        try(Connection connection = DBHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users ";
        try(Connection connection = DBHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    userList.add(new User(id, name, email, country));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void deleteUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        Connection connection = null;

        try {
            connection = DBHelper.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user) {
        String sql = "UPDATE users set name = ?, email = ?, country = ? WHERE id = ?";
        Connection connection = null;
        try {
            connection = DBHelper.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.setInt(4, user.getId());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
