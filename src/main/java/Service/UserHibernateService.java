package Service;

import DAO.UserHibernateDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class UserHibernateService {
    private static UserHibernateService userHibernateService;

    private SessionFactory sessionFactory;

    public UserHibernateService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserHibernateService getInstance() {
        if (userHibernateService == null) {
            userHibernateService = new UserHibernateService(DBHelper.getSessionFactory());
        }
        return userHibernateService;
    }

    public void addUser(User user) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            UserHibernateDAO userHibernateDAO = new UserHibernateDAO(session);
            transaction = session.beginTransaction();
            userHibernateDAO.addUser(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public User getUser(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = new UserHibernateDAO(session).getUser(id);
        }
        return user;
    }

    public List<User> getAll() {
        List<User> userList = null;
        try (Session session = sessionFactory.openSession()) {
            userList = new UserHibernateDAO(session).getAllUsers();
        }
        return userList;
    }

    public void deleteUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            UserHibernateDAO userHibernateDAO = new UserHibernateDAO(session);
            transaction = session.beginTransaction();
            userHibernateDAO.deleteUser(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            new UserHibernateDAO(session).updateUser(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
