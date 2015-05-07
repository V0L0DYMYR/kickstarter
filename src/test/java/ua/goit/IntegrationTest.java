package ua.goit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.goit.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/serviceContext.xml",
"/test-context.xml"})

public class IntegrationTest {


  @Autowired
  CategoryService categoryService;

  @Test
  public void categoryIntegrationTest() {

    System.out.println(categoryService.findAll());
  }


}
