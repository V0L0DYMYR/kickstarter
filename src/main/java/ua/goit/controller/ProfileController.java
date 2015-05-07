package ua.goit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

  @RequestMapping("/profile/{id}")
  public ModelAndView process(@PathVariable("id") Integer id) {

    return new ModelAndView("profile");
  }
}
