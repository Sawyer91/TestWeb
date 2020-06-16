package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            userList = session.createQuery("FROM User").list();
        }
        return userList;
    }

    @Override
    public void deleteUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
