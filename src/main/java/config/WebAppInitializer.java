package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
		
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
		
      context.setConfigLocation("config");

      servletContext.addListener(new ContextLoaderListener(context));

      ServletRegistration.Dynamic dispatcher = servletContext
        .addServlet("dispatcher", new DispatcherServlet(context));
      
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
	}
}
