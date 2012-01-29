package net.pdp7.commons.spring.context;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
public class WebAppPropertiesConfiguration {
	
	@Autowired
	protected AnnotationConfigWebApplicationContext webApplicationContext;
	
	@Bean
	public Properties applicationProperties() {
		return ContextUtils.propertiesFromResource(applicationPropertiesResource());
	}
	
	@Bean
	public Resource applicationPropertiesResource() {
		return new ClassPathResource(webApplicationContext.getServletContext().getContextPath() + ".properties");
	}

}
