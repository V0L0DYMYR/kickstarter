package ua.goit.servlet;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.util.Enumeration;

import static java.lang.String.format;

public class SystemPropertiesListener implements ServletContextListener {

  Logger logger = Logger.getLogger(SystemPropertiesListener.class);

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    logger.debug("Reading Context parameters.");
    ServletContext context = servletContextEvent.getServletContext();
    Enumeration<String> params = context.getInitParameterNames();

    while (params.hasMoreElements()) {
      String param = params.nextElement();
      String value = context.getInitParameter(param);

      if (param.startsWith("kickstarter.")) {
        System.setProperty(param, value);
        String message = format("Found init parameter [%s:%s]", param, value);
        logger.debug(message);
      }
    }

    InitialContext cxt = null;
    try {
      cxt = new InitialContext();
      if (cxt != null) {
        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/PostgreSQLDS");
        // TODO
        //Factory.dataSource = ds;
      }
    } catch (NamingException e) {
      logger.error(e);
    }


  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
