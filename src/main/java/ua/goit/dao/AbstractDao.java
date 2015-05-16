package ua.goit.dao;

import org.hibernate.SessionFactory;
import ua.goit.model.Category;

import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {

  protected final SessionFactory sessionFactory;
  protected Class<T> type;

  protected AbstractDao(SessionFactory sessionFactory, Class<T> type) {
    this.sessionFactory = sessionFactory;
    this.type = type;
  }

  @Override
  public List<T> findAll() {
    return sessionFactory.getCurrentSession()
        .createCriteria(type)
        .list();
  }

  @Override
  public T findById(Integer id) {
    return (T) sessionFactory.getCurrentSession()
        .get(type, id);
  }

  @Override
  public T create(T obj) {
    sessionFactory.getCurrentSession()
        .persist(obj);

    return obj;
  }
}
