package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.dao.UserDao;
import ua.goit.model.User;

@Component
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User create(User user) {
    return userDao.create(user);
  }

  @Override
  public User findById(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User findByToken(String token) {
    return userDao.findByToken(token);
  }
}
