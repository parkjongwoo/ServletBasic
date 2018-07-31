package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="request01", urlPatterns="/request01")
public class Request01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>doGet호출<br>");
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
		
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>doPost호출<br>");
		Map<String,String[]> parameters = req.getParameterMap();
		Enumeration<String> names = req.getParameterNames();
		
		
		Enumeration<String> attributeNames = req.getAttributeNames();
		
		//파라메터 출력
		writer.println("요청 파라메터<br>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			for(int i=0;i<parameters.get(name).length;i++) {
				
				writer.println(name+"["+i+"]: "+parameters.get(name)[i]+"<br>");
				System.out.println("요청 파라메터 "+name+"["+i+"]: "+parameters.get(name)[i]);
				
			}
		}
		
		//애트리뷰트 출력
		writer.println("추가된 애트리뷰트<br>");
		System.out.println("추가된 애트리뷰트");
		while(attributeNames.hasMoreElements()) {
			String name = attributeNames.nextElement();			
			writer.println(name+": "+req.getAttribute(name)+"<br>");
			System.out.println(name+": "+req.getAttribute(name));
		}
		writer.println("</body></html>");
	}
}
