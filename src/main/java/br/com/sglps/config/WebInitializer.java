/*
package br.com.sglps.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebInitializer implements WebApplicationInitializer {
	
    public void onStartup(ServletContext container) throws ServletException{
    	
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("br.com.sglps.config");
 
        container.addListener(new ContextLoaderListener(context));
        
        DispatcherServlet dp =  new DispatcherServlet(context);
        dp.setThrowExceptionIfNoHandlerFound(true);
 
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dp);
         
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    
    
}*/


