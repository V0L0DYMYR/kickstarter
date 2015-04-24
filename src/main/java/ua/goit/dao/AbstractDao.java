package ua.goit.dao;

import java.sql.Connection;

public abstract class AbstractDao<T> implements GenericDao<T> {

  protected final Connection connection;

  protected AbstractDao(Connection connection) {
    this.connection = connection;
  }
}
