package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="MyServlet", urlPatterns="/my")
public class MyServlet implements Servlet {
	
	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {		
		this.servletConfig = servletConfig;
		System.out.println("init servlet "+servletConfig.getServletName());
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy servlet "+servletConfig.getServletName());
	}

	@Override
	public ServletConfig getServletConfig() {		
		return servletConfig;
	}

	@Override
	public String getServletInfo() {		
		return servletConfig.getServletName();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		writer.println("<!DOCTYPE html><html><head></head><body>");
		writer.println("Hello world!!");
		writer.println("</body><html>");

	}
}
