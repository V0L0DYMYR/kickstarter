package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

public class ProfileController implements Controller {


  @Override
  public ViewModel process(Request request) {
    String userId = request.getParameter("userId");

    return new ViewModel("/profile.jsp");
  }
}
