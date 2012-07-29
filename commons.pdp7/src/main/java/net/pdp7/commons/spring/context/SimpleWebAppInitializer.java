package net.pdp7.commons.spring.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public abstract class SimpleWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(getAppConfigurationClasses());

		container.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(getDispatcherConfigurationClasses());

		registerDispatcher(container, dispatcherContext);
	}

	protected void registerDispatcher(ServletContext container, AnnotationConfigWebApplicationContext dispatcherContext) {
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	protected abstract Class<?>[] getAppConfigurationClasses();
	protected abstract Class<?>[] getDispatcherConfigurationClasses();

}