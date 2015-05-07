package ua.goit.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestFactory {

  public static Connection getConnection() {
    Connection connection;
    try {

      String jdbcDriver = "org.sqlite.JDBC";
      String dbUrl = "jdbc:sqlite:kickstarter.db";


      Class.forName(jdbcDriver);
      connection = DriverManager.getConnection(dbUrl);

    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }
}
