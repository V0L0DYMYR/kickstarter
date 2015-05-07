package ua.goit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.Category;
import ua.goit.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

  private final CategoryService service;

  @Autowired
  public CategoryController(CategoryService service) {
    this.service = service;
  }

  @RequestMapping("/categories")
  public ModelAndView getAllCategories() {
    List<Category> categories = service.findAll();
    return new ModelAndView("categories", "categories", categories);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/category")
  public ModelAndView createCategory(
      @RequestParam("categoryName") String categoryName,
      @RequestParam("userId") String userId) {
    ModelAndView vm = new ModelAndView("categories");

    if (categoryName == null) {
      throw new RuntimeException("Category Name is Null");
    }
    service.create(new Category(categoryName));

    if (userId != null) {
      vm.addObject("isLoggedIn", "true");
      vm.addObject("username", "Vova");
    }

    List<Category> categories = service.findAll();
    return vm.addObject("categories", categories);
  }
}
