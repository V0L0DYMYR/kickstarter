package ua.goit.service;

import ua.goit.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

  ArrayList<Category> categories = new ArrayList<Category>() {
    {
      add(new Category(1, "Music"));
      add(new Category(2, "IT"));
    }
  };

  @Override
  public Category update(Category category) {
    return null;
  }

  @Override
  public List<Category> findAll() {

    return categories;
  }

  @Override
  public Category create(Category category) {
    categories.add(category);
    return category;
  }
}
