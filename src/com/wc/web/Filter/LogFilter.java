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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter(urlPatterns="/*", dispatcherTypes = {DispatcherType.INCLUDE,DispatcherType.REQUEST,DispatcherType.ERROR,DispatcherType.FORWARD})
public class LogFilter implements Filter{
       
        private Log log = LogFactory.getLog (this .getClass());
       
        private String fileName;
       public void destroy() {
       }

        public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {
  
            HttpServletRequest req = (HttpServletRequest)request;
               HttpServletResponse res = (HttpServletResponse ) response;
              
               long startTime = System.currentTimeMillis();
              String requestURI = req.getRequestURI();
//System.out.println( "ra"+req.getQueryString());         
              requestURI = req.getQueryString() == null ? requestURI : (req.getQueryString() + "?" + req.getQueryString());
              
              chain.doFilter(request, response);
              
               long endTime = System.currentTimeMillis();
              
               log.info(request.getRemoteAddr() + "访问了 " + requestURI + ",总用时 " + (endTime - startTime) + "毫秒.");
              
       }

   
        public void init(FilterConfig filterConfig) throws ServletException {
             
               fileName = filterConfig.getFilterName();
               log.info( "启动 Filter: " + fileName );
       }
       
}
