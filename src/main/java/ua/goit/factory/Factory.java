package ua.goit.factory;

import ua.goit.dao.CategoryDao;
import ua.goit.dao.CategoryDaoImpl;
import ua.goit.dao.UserDao;
import ua.goit.dao.UserDaoImpl;
import ua.goit.service.CategoryService;
import ua.goit.service.UserService;
import ua.goit.service.UserServiceImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {


  public static DataSource dataSource;

  public static Connection getConnection() {

    Connection connection = null;
    if (dataSource == null) {
      connection = getConnectionFromSysProperties();
    } else {
      connection = getConnectionFromDS();
    }
    return connection;
  }

  private static Connection getConnectionFromDS() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static Connection getConnectionFromSysProperties() {
    Connection connection;
    try {

      String jdbcDriver = System.getProperty("kickstarter.jdbc.driver");
      String dbUrl = System.getProperty("kickstarter.jdbc.url");
      String dbUser = System.getProperty("kickstarter.jdbc.user");
      String dbPassword = System.getProperty("kickstarter.jdbc.password");


      Class.forName(jdbcDriver);
      if (dbUser != null && dbPassword != null) {
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
      } else {
        connection = DriverManager.getConnection(dbUrl);
      }

    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }


  protected static CategoryDao getCategoryDao(Connection connection) {
    return new CategoryDaoImpl(getConnection());
  }

  protected static CategoryService getCategoryService(CategoryDao dao) {
    return null;//new CategoryServiceImpl(dao);
  }


  private static UserService getUserService(UserDao userDao) {
    return new UserServiceImpl(userDao);
  }

  private static UserDao getUserDao(Connection connection) {
    return new UserDaoImpl(connection);
  }
}
