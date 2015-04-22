package ua.goit.servlet;

import ua.goit.factory.ConnectionPool;
import ua.goit.factory.Factory;
import ua.goit.model.Category;
import ua.goit.service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class FrontServlet extends HttpServlet {




  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    processController(req, resp);
  }

  private void processController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = ConnectionPool.getConnection();
    ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    threadLocal.set(connection);

    process(req, resp);

    ConnectionPool.release(connection);
  }


  private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    CategoryService service = Factory.getCategoryService();
    List<Category> categories = service.findAll();

    String jspUrl = req.getContextPath() + "/categories.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(jspUrl);
    req.setAttribute("categories", categories);
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    CategoryService service = Factory.getCategoryService();
    service.create(new Category(req.getParameter("category_name")));

    String jspUrl = req.getContextPath() + "/categories.jsp";
    List<Category> categories = service.findAll();
    RequestDispatcher dispatcher = req.getRequestDispatcher(jspUrl);
    req.setAttribute("categories", categories);
    dispatcher.forward(req, resp);
  }
}
