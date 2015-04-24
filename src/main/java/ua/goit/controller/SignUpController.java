package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

public class SignUpController implements Controller {
  @Override
  public ViewModel process(Request request) {
    return new ViewModel("/signup.jsp");
  }
}
