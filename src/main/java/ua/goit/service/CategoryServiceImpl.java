package ua.goit.service;

import ua.goit.dao.CategoryDao;
import ua.goit.dao.UserDao;
import ua.goit.factory.Factory;
import ua.goit.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

  private final CategoryDao categoryDao;
  private UserDao userDao;

  public CategoryServiceImpl(CategoryDao categoryDao, UserDao userDao) {
    this.categoryDao = categoryDao;
    this.userDao = userDao;
  }

  @Override
  public Category update(Category category) {
    return null;
  }

  @Override
  public List<Category> findAll() {
    return categoryDao.findAll();
  }

  @Override
  public Category create(Category category) {
    return categoryDao.create(category);
  }
}
