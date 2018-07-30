package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="request03", urlPatterns= {"/goott","/request03"},//여러 url을 처리하는 서블릿일때, {}사용
		initParams= {
				@WebInitParam(name="admin",value="Lim"),
				@WebInitParam(name="email",value="ad@gmail.com"),
				})
public class Request03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");		
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		writer.println("초기 파라메터"+getServletConfig().getInitParameter("admin"));
		writer.println("초기 파라메터"+getServletConfig().getInitParameter("email"));
		writer.println("</body></html>");		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");		
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		writer.println("초기 파라메터"+getServletConfig().getInitParameter("admin"));
		writer.println("초기 파라메터"+getServletConfig().getInitParameter("email"));
		writer.println("</body></html>");
	}
}
