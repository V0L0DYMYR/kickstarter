package ua.goit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.model.User;
import ua.goit.service.UserService;

@Controller
public class SignUpController {

  private final Logger logger = Logger.getLogger(SignUpController.class);
  private final UserService service;

  @Autowired
  public SignUpController(UserService service) {
    this.service = service;
  }

  @RequestMapping("/signup-form")
  public ModelAndView signUpForm() {
    return new ModelAndView("signup");
  }

  @RequestMapping("/create-user")
  public ModelAndView process(
      @RequestParam("userName") String userName,
      @RequestParam("password") String password) {

    String token = userName + System.nanoTime();

    service.create(User.from(userName, password, token));
    return new ModelAndView("profile")
        .addObject("token", token);
  }
}
