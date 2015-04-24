package ua.goit.factory;

import ua.goit.controller.Controller;
import ua.goit.controller.CreateUserController;
import ua.goit.controller.GetAllCategoriesController;
import ua.goit.dao.CategoryDao;
import ua.goit.dao.CategoryDaoImpl;
import ua.goit.dao.UserDao;
import ua.goit.dao.UserDaoImpl;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;
import ua.goit.service.UserService;
import ua.goit.service.UserServiceImpl;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

  public static Connection getConnection() {

    Connection connection = null;
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:kickstarter.db");
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

  protected static CategoryDao getCategoryDao(Connection connection) {
    return new CategoryDaoImpl(getConnection());
  }

  protected static CategoryService getCategoryService(CategoryDao dao) {
    return new CategoryServiceImpl(dao);
  }

  public static Controller createCategoryController(Class<? extends Controller> clazz, Connection connection) {
    Controller controller = null;
    try {
      Constructor<? extends Controller> constructor = clazz.getConstructor(CategoryService.class);
      CategoryService service = getCategoryService(getCategoryDao(connection));
      controller = constructor.newInstance(service);
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }

    return controller;
  }

  public static Controller createUserController(Class<CreateUserController> clazz, Connection connection) {
    Controller controller = null;
    try {
      Constructor<? extends Controller> constructor = clazz.getConstructor(UserService.class);
      UserService service = getUserService(getUserDao(connection));
      controller = constructor.newInstance(service);
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }

    return controller;
  }

  private static UserService getUserService(UserDao userDao) {
    return new UserServiceImpl(userDao);
  }

  private static UserDao getUserDao(Connection connection) {
    return new UserDaoImpl(connection);
  }
}
