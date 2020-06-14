package DAO;

import model.User;
import org.hibernate.Session;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(User user) {
        session.save(user);
    }

    @Override
    public User getUser(int id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) session.createQuery("FROM User").list();
    }

    @Override
    public void deleteUser(User user) {
        session.delete(user);
    }

    @Override
    public void updateUser(User user) {
        session.update(user);
    }
}
