package ua.goit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.model.Project;

@Component
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {

  @Autowired
  protected ProjectDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory, Project.class);
  }

  @Override
  public Project delete(Project project) {
    return null;
  }

  @Override
  public Project update(Project project) {
    return null;
  }
}
