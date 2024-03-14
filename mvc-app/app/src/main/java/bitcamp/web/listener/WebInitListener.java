package bitcamp.web.listener;

import bitcamp.config.AppConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@WebListener
public class WebInitListener implements ServletContextListener {

  private static Log log = LogFactory.getLog(WebInitListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.debug("contextInitialized 호출되었습니다.");
    ServletContext sc = sce.getServletContext();

    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    DispatcherServlet appServlet = new DispatcherServlet();
    sc.addServlet("app", appServlet);
    Dynamic 서블릿설정 = sc.addServlet("app", appServlet);
    서블릿설정.addMapping("/app/*");
    서블릿설정.setLoadOnStartup(1);

  }
}
