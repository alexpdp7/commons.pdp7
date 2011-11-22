package net.pdp7.commons.spring.web.servlet;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestHelper {
	
	public String getFullRequestUrl() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		
		// FIXME: add query parameters!
		return attributes.getRequest().getRequestURL().toString();
	}

}
