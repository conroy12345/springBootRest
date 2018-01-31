package com.rest.application.hibernate.connection;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Webxmlconfig extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{SpringServlet.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[]{SpringServlet.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[]{"/"};
	}

}
