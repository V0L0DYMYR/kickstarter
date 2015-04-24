package ua.goit.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

  public static void main(String[] args) throws SQLException {
    Connection connection = Factory.getConnection();
    Statement stmt = connection.createStatement();
    stmt.execute("create table users(id integer PRIMARY KEY AUTOINCREMENT, " +
        "username varchar(256), password varchar(256), token char(256))");
    connection.close();
  }
}
