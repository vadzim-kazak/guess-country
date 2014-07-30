package com.jrew.lab.guesscountry.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    /**
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        WebApplicationContext context = getContext();

        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    /**
     *
     * @return
     */
    private AnnotationConfigWebApplicationContext getContext() {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.jrew.lab.guesscountry.config");
        return context;
    }
}
