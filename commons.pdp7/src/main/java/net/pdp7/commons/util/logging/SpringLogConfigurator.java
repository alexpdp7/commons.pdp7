package net.pdp7.commons.util.logging;

import java.io.IOException;
import java.util.logging.LogManager;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

public class SpringLogConfigurator implements InitializingBean {

	protected final Resource logConfigurationResource;

	public SpringLogConfigurator(Resource logConfigurationResource) {
		this.logConfigurationResource = logConfigurationResource;
	}
	
	public void afterPropertiesSet() {
		try {
			LogManager.getLogManager().readConfiguration(logConfigurationResource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
