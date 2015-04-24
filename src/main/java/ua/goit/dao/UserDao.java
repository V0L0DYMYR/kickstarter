package ua.goit.dao;

import ua.goit.model.User;

public interface UserDao extends GenericDao<User> {

  User findByToken(String token);
}
