package net.pdp7.commons.servlet.escapexml;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.jsp.JspFactory;

/** adapted from https://github.com/pukkaone/webappenhance */

public class EscapeXmlELResolverListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		JspFactory.getDefaultFactory()
				.getJspApplicationContext(event.getServletContext())
				.addELResolver(new EscapeXmlELResolver());
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
}