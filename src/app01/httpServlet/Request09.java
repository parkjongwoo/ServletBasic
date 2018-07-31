package app01.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request08 서블릿이 목표로 할 하위폴더 서블릿
 * HttpServletResponse.sendRedirect() 와 RequestDispatcher.forward()의 차이
 * sendRedirect 는 클라이언트의 request에 response를 완료하는 동시에 
 * 인자로 전달하는 url로 이동하도록 브라우저에 요청한다.
 * 이에 브라우저는 url창의 주소를 전달받은 주소로 갱신하고 새로운 요청을 해당주소에 전달한다.
 * 
 * forward는 기존 request, response 객체를 유지한 상태로
 * 새로운 servlet객체에 전달하여 서버측 작업을 계속 진행한다.
 * 그러므로 클라이언트 브라우저에서는 새로운 주소를 알 수 없으며 url창도 갱신되지 않는다.
 * html파일로 forward한 경우 해당 html파일 주소가 브라우저에 표시되는 것이 아니라
 * forward하기전 마지막 url주소가 유지된다.
 * 
 * 서버 자원 이용 측면으로 생각해 본다면
 * sendRedirect는 기존 연결을 끊고 새 연결을 요청하므로 기존 request객체가 사라지며 요청시간이 추가로 소요된다.
 * forward는 기존request가 유지되므로 참조 가능하고 추가 요청시간 없이 서버내 처리만 하면되므로 실행시간이 단축된다. 
 * @author goott3-4
 *
 */
@WebServlet(name = "request09", urlPatterns = "/request09/child")
public class Request09 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		writer.println("Request09/child 패턴을 등록한 request09 서블릿 입니다.");		
		writer.println("</body></html>");
		
		System.out.println("Request09 doGet");
//		resp.sendRedirect("request08_response.html");//다른 페이지로 이동
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<!doctype html><html><head><meta charset='utf-8'></head><body>");
		writer.println("Request09/child 패턴을 등록한 request09 서블릿 입니다.");				
		writer.println("</body></html>");		
		System.out.println("Request09 doPost");
//		resp.sendRedirect("request08_response.html");
	}
}
