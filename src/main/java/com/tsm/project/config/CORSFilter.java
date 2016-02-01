package com.tsm.project.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CORSFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(CORSFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.info("Filtering on ........................");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
