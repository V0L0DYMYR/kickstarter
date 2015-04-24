package ua.goit.controller;

import ua.goit.servlet.Request;
import ua.goit.view.ViewModel;

public interface Controller {

  ViewModel process(Request request);

}
