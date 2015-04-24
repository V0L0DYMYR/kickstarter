package ua.goit.controller;

import org.apache.log4j.Logger;
import ua.goit.model.User;
import ua.goit.service.UserService;
import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;


public class CreateUserController implements Controller {

  private final Logger logger = Logger.getLogger(CreateUserController.class);
  private final UserService service;

  public CreateUserController(UserService service) {
    this.service = service;
  }

  @Override
  public ViewModel process(Request request) {

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String token = userName + System.nanoTime();

    service.create(User.from(userName, password, token));
    return new ViewModel("/profile.jsp")
        .addCookie("token", token);
  }
}
