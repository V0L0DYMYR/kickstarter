package ua.goit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ua.goit.controller.CategoryController;

public class IntegrationTest {

  @Test
  @Ignore
  public void categoryIntegrationTest() {
    String expectedHtml = "<a href=\"\"></a>";
    String url = "/";
    CategoryController categoryController = new CategoryController();
    String html = categoryController.handle(url);
    Assert.assertEquals(expectedHtml, html);
  }
}
