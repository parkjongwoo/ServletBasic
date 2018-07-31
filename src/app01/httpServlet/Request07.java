package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "request07", urlPatterns = "/request07")
public class Request07 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request07 doGet");

		
		RequestDispatcher dispacher = req.getRequestDispatcher("/request01");		
		dispacher.forward(req, resp);
		
//		resp.sendRedirect("request08");//상대경로 /가 없음.
//		resp.sendRedirect("/ServletBasic/request08");//절대경로 /로 시작.RequestDispatcher와 달리 context root 부터 작성해야 함.	
//		resp.sendRedirect("/request08");//절대경로이므로 context root가 포함되어야 하는데 없으므로 페이지 없다는 애러 404 발생
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request07 doPost");

//		resp.sendRedirect("request08");//상대경로 /가 없음.
//		resp.sendRedirect("/ServletBasic/request08");//절대경로 /로 시작.
//		resp.sendRedirect("/request08");//절대경로이므로 페이지 없다는 애러 404 발생
		
//		RequestDispatcher dispacher = req.getRequestDispatcher("request08");//상대경로
		RequestDispatcher dispacher = req.getRequestDispatcher("/request08");
		//절대경로 /를 context root로 변경됨. 
		//결국 서블릿이 context root에 있다면 "/+서블릿 urlPatterns" == "서블릿 urlPatterns" 이 성립
		dispacher.forward(req, resp);
	}
}
