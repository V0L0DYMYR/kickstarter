package ua.goit.dao;

import ua.goit.model.Category;

import java.util.List;

public interface CategoryDao extends GenericDao<Category> {

  List<Category> findAll();
}
