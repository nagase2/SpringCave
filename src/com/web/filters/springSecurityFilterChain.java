package com.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Servlet Filter implementation class springSecurityFilterChain
 */
public class springSecurityFilterChain extends DelegatingFilterProxy implements Filter {
       
    /**
     * @see DelegatingFilterProxy#DelegatingFilterProxy()
     */
    public springSecurityFilterChain() {
        super();
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see DelegatingFilterProxy#DelegatingFilterProxy(Filter)
     */
    public springSecurityFilterChain(Filter delegate) {
        super(delegate);
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see DelegatingFilterProxy#DelegatingFilterProxy(String)
     */
    public springSecurityFilterChain(String targetBeanName) {
        super(targetBeanName);
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see DelegatingFilterProxy#DelegatingFilterProxy(String, WebApplicationContext)
     */
    public springSecurityFilterChain(String targetBeanName, WebApplicationContext wac) {
        super(targetBeanName, wac);
        // TODO Auto-generated constructor stub
    }

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
		// place your code here
		System.out.println("dofilter");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	@Autowired
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}

}
