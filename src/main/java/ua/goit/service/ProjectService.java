package ua.goit.service;

import ua.goit.model.Category;
import ua.goit.model.Project;

public interface ProjectService {
  Iterable<Project> getAllByCategory(Category category);
}
