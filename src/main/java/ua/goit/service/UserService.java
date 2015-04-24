package ua.goit.service;

import ua.goit.model.User;

public interface UserService {

  User create(User user);
  User findById(Integer id);
  User findByToken(String token);
}
