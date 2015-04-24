package ua.goit.dao;

import ua.goit.model.User;

import java.sql.*;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public UserDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public User create(User user) {
    try {
      PreparedStatement statement =
          connection.prepareStatement("insert into users(username, password, token) values(?,?,?)");
      statement.setString(1, user.getUserName());
      statement.setString(2, user.getPassword());
      statement.setString(3, user.getToken());
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return user;
  }

  @Override
  public User delete(User user) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User update(User user) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User findById(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User findByToken(String token) {
    User user = null;
    try {
      PreparedStatement stmt = connection.prepareStatement("select * from users where token = ?");
      stmt.setString(1, token);
      ResultSet rs = stmt.executeQuery();
      rs.next();

      String username = rs.getString("username");
      int id = rs.getInt("id");
      user = User.from(id, username);


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return user;
  }
}
