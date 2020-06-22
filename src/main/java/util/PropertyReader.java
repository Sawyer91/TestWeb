package util;

import DAO.UserDAO;
import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static UserDAO getDAO() {
        Properties properties = new Properties();
        String res = null;
        UserDAO userDAO = null;
        try (InputStream fis = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("daotype");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (res.equalsIgnoreCase("jdbc")) {
            userDAO = new UserJdbcDAO();
        } else if (res.equalsIgnoreCase("hibernate")) {
            userDAO = new UserHibernateDAO();
        }
        return userDAO;
    }

    public static String getDBHost() {
        Properties properties = new Properties();
        String res = null;
        try (InputStream fis = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("db.host");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getDBUSer() {
        Properties properties = new Properties();
        String res = null;
        try (InputStream fis = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("db.login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getDBUserPass() {
        Properties properties = new Properties();
        String res = null;
        try (InputStream fis = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getDriver() {
        Properties properties = new Properties();
        String res = null;
        try (InputStream fis = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(fis);
            res = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
