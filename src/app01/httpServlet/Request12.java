package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 스코프 별 값 저장 및 관리 연습
 * 세션 정보 . html에서 전달된 userId를 세션에 login_info로 저장하는 서블릿
 */
@WebServlet(name = "request12", urlPatterns = { "/request12" })
public class Request12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request에 값 저장(jsp의 el에서 requestScope)
		request.setAttribute("rid","호호");
		
		//session에 값 저장(jsp의 el에서 sessionScope)
		HttpSession session = request.getSession();
		session.setAttribute("login_info", request.getParameter("userId"));
		
		//context에 값 저장(jsp의 el에서 applicationScope)
		ServletContext context = request.getServletContext();
		context.setAttribute("context_id", "con_id");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("request13");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
