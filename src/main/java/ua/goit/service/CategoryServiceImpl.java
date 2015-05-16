package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.CategoryDao;
import ua.goit.dao.UserDao;
import ua.goit.model.Category;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;
  private UserDao userDao;

  @Autowired
  public CategoryServiceImpl(CategoryDao categoryDao, UserDao userDao) {
    this.categoryDao = categoryDao;
    this.userDao = userDao;
  }

  @Override
  public Category update(Category category) {
    return null;
  }

  @Override
  @Transactional
  public List<Category> findAll() {
    return categoryDao.findAll();
  }

  @Override
  public Category create(Category category) {
    return categoryDao.create(category);
  }
}
