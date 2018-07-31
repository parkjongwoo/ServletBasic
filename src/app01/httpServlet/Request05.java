package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "request05", urlPatterns = "/request05")
public class Request05 extends HttpServlet {
	
	/**
	 * sendRedirect 테스트. get 메서드로 서블릿, 페이지 이동
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request05 doGet");

//		resp.sendRedirect("get_welcome.html");//다른 웹페이지로 리다이렉트
		
		resp.sendRedirect("request01?testpara=ppp");//다른 서블릿으로 리다이렉트. 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request05 doPost");

//		resp.sendRedirect("get_welcome.html");
		resp.sendRedirect("request01?testpara=ppp");//다른 서블릿으로 리다이렉트. get방식으로 변경됨. 
	}
}
