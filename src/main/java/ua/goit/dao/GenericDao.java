package ua.goit.dao;

import java.util.List;

public interface GenericDao<T> {
  List<T> findAll();
  T create(T t);
  T delete(T t);
  T update(T t);
  T findById(Integer id);
}
