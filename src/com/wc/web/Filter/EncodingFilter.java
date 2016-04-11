package com.wc.web.Filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*", dispatcherTypes = {DispatcherType.INCLUDE,DispatcherType.REQUEST,DispatcherType.ERROR,DispatcherType.FORWARD})
public class EncodingFilter implements Filter {
	private String encoding;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		response.setCharacterEncoding(encoding);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fConfig.getServletContext().getInitParameter("encoding");
	}

}
