package net.pdp7.commons.util.logging;

import java.io.IOException;
import java.util.logging.LogManager;

public class LogConfigurator {

	protected LogConfigurator() {}
	
	public static void configure(String classPath) {
		try {
			LogManager.getLogManager().readConfiguration(LogConfigurator.class.getResourceAsStream(classPath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
