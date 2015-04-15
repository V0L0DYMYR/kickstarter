package ua.goit.servlet;

import ua.goit.model.Category;
import ua.goit.service.CategoryService;
import ua.goit.service.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class FrontServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    CategoryService service = new CategoryServiceImpl();
    List<Category> categories = service.findAll();

    String jspUrl = req.getContextPath() + "/categories.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(jspUrl);
    req.setAttribute("categories", categories);
    dispatcher.forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    CategoryService service = new CategoryServiceImpl();
    service.create(new Category(req.getParameter("category_name")));

    String jspUrl = req.getContextPath() + "/categories.jsp";
    List<Category> categories = service.findAll();
    RequestDispatcher dispatcher = req.getRequestDispatcher(jspUrl);
    req.setAttribute("categories", categories);
    dispatcher.forward(req, resp);
  }
}
