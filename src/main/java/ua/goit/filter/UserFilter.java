package ua.goit.filter;

import ua.goit.dao.UserDao;
import ua.goit.dao.UserDaoImpl;
import ua.goit.factory.ConnectionPool;
import ua.goit.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UserFilter implements Filter{

  private UserDao userDao;
  private final String TOKEN = "TOKEN";
  private final Set<String> protectedUrL = new HashSet<>();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    userDao = new UserDaoImpl(ConnectionPool.getConnection());
    protectedUrL.add("/servlet/profile");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Cookie[] cookies = req.getCookies();

    String uri = req.getRequestURI();
    if (protectedUrL.contains(uri)) {
      String token = null;

      for (Cookie cookie: cookies) {
        String name = cookie.getName().toUpperCase();

        if (TOKEN.equals(name)) {
          token = cookie.getValue();
          User user = userDao.findByToken(token);
          req.setAttribute("userId", String.valueOf(user.getId()));
        }
      }
      if (token == null) {
        req.getRequestDispatcher("/servlet/signup").forward(req, res);
      }
    }

    chain.doFilter(request, res);

  }

  @Override
  public void destroy() {

  }
}
