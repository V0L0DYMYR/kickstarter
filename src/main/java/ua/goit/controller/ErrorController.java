package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

public class ErrorController implements Controller{
  @Override
  public ViewModel process(Request request) {
    return new ViewModel("/error.jsp")
        .withAttribute("error", request.getParameter("error"));
  }
}
