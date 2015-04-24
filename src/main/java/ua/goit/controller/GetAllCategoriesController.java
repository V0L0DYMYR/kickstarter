package ua.goit.controller;

import ua.goit.model.Category;
import ua.goit.service.CategoryService;
import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

import java.util.List;

public class GetAllCategoriesController implements Controller {

  private final CategoryService service;

  public GetAllCategoriesController(CategoryService service) {
    this.service = service;
  }

  @Override
  public ViewModel process(Request request) {
    List<Category> categories = service.findAll();
    return new ViewModel("/categories.jsp")
        .withAttribute("categories", categories);
  }
}
