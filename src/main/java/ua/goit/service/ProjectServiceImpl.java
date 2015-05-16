package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.dao.ProjectDao;
import ua.goit.model.Category;
import ua.goit.model.Project;

@Component
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao projectDao;

  @Autowired
  public ProjectServiceImpl(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public Iterable<Project> getAllByCategory(Category category) {
    return null;
  }
}
