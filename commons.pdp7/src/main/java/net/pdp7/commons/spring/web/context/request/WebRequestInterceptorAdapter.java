package net.pdp7.commons.spring.web.context.request;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class WebRequestInterceptorAdapter implements WebRequestInterceptor {

	public void preHandle(WebRequest request) throws Exception {
	}

	public void postHandle(WebRequest request, ModelMap model) throws Exception {
	}

	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
	}

}
