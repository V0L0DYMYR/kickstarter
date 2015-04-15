package ua.goit.dao;

import ua.goit.model.Category;

import java.util.List;

public interface CategoryDao {

  List<Category> findAll();

  Category findById(Integer id);

  Category update(Category category);
}
