package ua.goit.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.model.Category;
import ua.goit.service.CategoryService;
import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

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
  CreateCategoryController controller;
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
    controller = new CreateCategoryController(mockService);
  }

  @After
  public void rollback() throws SQLException {
  //  con.rollback(savepoint);
  }

  @Test
  public void verifyThatServiceCreateMethodInvoked() {

    Map<String, String> params = new HashMap<>();
    params.put("categoryName", "Music");

    controller.process(new Request(params, "POST", "servlet/category"));

    verify(mockService).create(categoryCaptor.capture());

    Category category = categoryCaptor.getValue();
    assertEquals(category.getName(), "Music");
  }

  @Test
  public void rename() {

    Map<String, String> params = new HashMap<>();
    params.put("categoryName", "Music");
    ViewModel vm = controller.process(new Request(params, "POST", "servlet/category"));

    List<Category> categories = new ArrayList<>();

    when(mockService.findAll()).thenReturn(categories);

    assertEquals(vm.getAttribute("categories"), categories);
    assertEquals(vm.getView(), "/categories.jsp");
  }
}
