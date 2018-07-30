package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="request02", urlPatterns="/request02")
public class Request02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		Map<String,String[]> parameters = req.getParameterMap();
		Enumeration<String> names = req.getParameterNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			for(int i=0;i<parameters.get(name).length;i++) {
				writer.println("요청 파라메터<br>");
				writer.println(name+"["+i+"]: "+parameters.get(name)[i]+"<br>");
				System.out.println("요청 파라메터 "+name+"["+i+"]: "+parameters.get(name)[i]);
				
			}
		}
		writer.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("이전:"+resp.getCharacterEncoding());
		resp.setCharacterEncoding("utf-8");
		System.out.println("이후:"+resp.getCharacterEncoding());
		
		System.out.println("세션:"+req.getSession());
		System.out.println("쿼리:"+req.getQueryString());
		System.out.println("인증:"+req.getAuthType());
		System.out.println("req인코딩:"+req.getCharacterEncoding());
		System.out.println("ContextPath:"+req.getContextPath());
		System.out.println("getLocalAddr:"+req.getLocalAddr());
		System.out.println("getLocalPort:"+req.getLocalPort());
		System.out.println("getMethod:"+req.getMethod());
		
		Enumeration<String> hnames = req.getHeaderNames();
		
		while(hnames.hasMoreElements()) {
			String name = hnames.nextElement();
			System.out.println("헤더 "+name+": "+req.getHeader(name));
		}
		
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		Map<String,String[]> parameters = req.getParameterMap();
		Enumeration<String> names = req.getParameterNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			for(int i=0;i<parameters.get(name).length;i++) {
				writer.println("요청 파라메터<br>");
				writer.println(name+"["+i+"]: "+parameters.get(name)[i]+"<br>");
				System.out.println("요청 파라메터 "+name+"["+i+"]: "+parameters.get(name)[i]);
				
			}
		}
		writer.println("</body></html>");
	}
}
