package ua.goit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller<T> {

  T process(HttpServletRequest req, HttpServletResponse resp);

}
