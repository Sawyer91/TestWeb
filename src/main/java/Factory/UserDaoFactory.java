package Factory;

import DAO.UserDAO;
import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {


    public static String getString() {
        Properties properties = new Properties();
        String res = null;
        try (InputStream fis = UserDaoFactory.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("daotype");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    public static UserDAO getDAO() {

        UserDAO userDAO = null;

        if (getString().equalsIgnoreCase("jdbc")) {
             userDAO = new UserJdbcDAO();
        } else if (getString().equalsIgnoreCase("hibernate")) {
            userDAO = new UserHibernateDAO();
        }
        return userDAO;
    }
}
