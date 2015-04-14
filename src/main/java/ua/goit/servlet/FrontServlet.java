package ua.goit.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = getServletContext();
    String jspUrl = req.getContextPath() + "/index.jsp";
    RequestDispatcher dispatcher = context.getRequestDispatcher(jspUrl);
    req.setAttribute("category", "Music");
    dispatcher.forward(req, resp);
  }
}
