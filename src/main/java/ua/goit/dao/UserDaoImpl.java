package ua.goit.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.model.User;

import java.util.List;

@Component("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  @Autowired
  public UserDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory, User.class);
  }

  @Override
  public User create(User user) {
    sessionFactory.getCurrentSession()
        .persist(user);

    return user;
  }

  @Override
  public User delete(User user) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User update(User user) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User findById(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public User findByToken(String token) {
    List<User> users = sessionFactory.getCurrentSession()
        .createCriteria(User.class)
        .add(Restrictions.eq("token", token))
        .list();

    return users.isEmpty() ? null : users.get(0);
  }
}
