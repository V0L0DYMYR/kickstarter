package ua.goit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

  @RequestMapping("/profile")
  public ModelAndView process() {

    return new ModelAndView("profile");
  }
}
