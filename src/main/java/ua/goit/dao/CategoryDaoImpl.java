package ua.goit.dao;

import ua.goit.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {


  public CategoryDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<Category> findAll() {
    List<Category> res = new ArrayList<>();
    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from categories");
      while (rs.next()) {
        String name = rs.getString("name");
        int id = rs.getInt("id");
        Category category = new Category(id, name);
        res.add(category);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return res;
  }

  @Override
  public Category findById(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Category update(Category category) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Category create(Category category) {
    try {
      PreparedStatement statement =
          connection.prepareStatement("insert into categories(name) values( ? )");
      statement.setString(1, category.getName());
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return category;
  }

  @Override
  public Category delete(Category category) {
    throw new UnsupportedOperationException();
  }
}
