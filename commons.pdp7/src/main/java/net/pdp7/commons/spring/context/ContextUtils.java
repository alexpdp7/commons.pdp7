package net.pdp7.commons.spring.context;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.Resource;

public class ContextUtils {
	
	protected ContextUtils() {}
	
	public static Properties propertiesFromResource(Resource resource) {
		try {
			PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
			propertiesFactoryBean.setLocation(resource);
			propertiesFactoryBean.afterPropertiesSet();
			return propertiesFactoryBean.getObject();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
