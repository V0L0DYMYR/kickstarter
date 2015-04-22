package ua.goit.factory;

import ua.goit.dao.CategoryDao;
import ua.goit.dao.CategoryDaoImpl;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;

import java.sql.*;
import java.util.ArrayList;

public class Factory {

  public static Connection getConnection() {

    ThreadLocal<Connection> threadLocal = new ThreadLocal<>();




    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:kickstarter.db");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

  public static CategoryDao getCategoryDao() {
    return new CategoryDaoImpl(getConnection());
  }

  public static CategoryService getCategoryService() {
    return new CategoryServiceImpl(getCategoryDao());
  }
}
