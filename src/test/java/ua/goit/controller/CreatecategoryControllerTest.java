package ua.goit.controller;

import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.Category;
import ua.goit.service.CategoryService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateCategoryControllerTest {

  @Mock
  CategoryService mockService;
  @Captor
  ArgumentCaptor<Category> categoryCaptor;
  CategoryController controller;
  Connection con;
  Savepoint savepoint;

  @BeforeClass
  public static void createDB() {
    System.setProperty("jdbcDriver", "org.sqlite.JDBC");
    System.setProperty("dbUrl", "jdbc:sqlite:kickstarter.db");
  }

  @Before
  public void before() throws SQLException {
//    savepoint = con.setSavepoint();
    MockitoAnnotations.initMocks(this);
    controller = new CategoryController(mockService);
  }

  @After
  public void rollback() throws SQLException {
  //  con.rollback(savepoint);
  }

  @Test
  public void verifyThatServiceCreateMethodInvoked() {

    controller.createCategory("Music", null);

    verify(mockService).create(categoryCaptor.capture());

    Category category = categoryCaptor.getValue();
    assertEquals(category.getName(), "Music");
  }

  @Test
  @Ignore
  public void rename() {

    Map<String, String> params = new HashMap<>();
    params.put("categoryName", "Music");
    ModelAndView vm = controller.getAllCategories();

    List<Category> categories = new ArrayList<>();

    when(mockService.findAll()).thenReturn(categories);

    Map<String, Object> model = vm.getModel();
    assertEquals(model.get("categories"), categories);
    assertEquals(vm.getView(), "categories");
  }
}
