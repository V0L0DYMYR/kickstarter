package ua.goit.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.model.Category;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Component
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

  @Autowired
  public CategoryDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory, Category.class);
  }


  @Override
  public Category update(Category category) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Category delete(Category category) {
    throw new UnsupportedOperationException();
  }
}
