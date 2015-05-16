package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.goit.service.ProjectService;

@Controller
public class ProjectController {

  private ProjectService projectService;

  @Autowired
  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }


}
