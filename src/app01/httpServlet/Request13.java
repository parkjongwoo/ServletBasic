package app01.httpServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 세션 정보. 세션에 저장된 login_info값을 확인하는 서블릿
 */
@WebServlet(name = "request13", urlPatterns = { "/request13" })
public class Request13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println("<!doctype html><html><head><meta charset='utf-8'></head><body>doGet호출<br>");
		
		String rid = String.valueOf(request.getAttribute("rid"));
		response.getWriter().println("<h3>request에 저장된 rid는 "+rid+"입니다.</h3>");
		
		HttpSession session = request.getSession();
		String userId = String.valueOf(session.getAttribute("login_info"));
		response.getWriter().println("<h3>세션에 저장된 유저아이디는 "+userId+"입니다.</h3>");
		
		ServletContext context = request.getServletContext();
		String conId = String.valueOf(context.getAttribute("context_id"));
		response.getWriter().println("<h3>context에 저장된 context_id는 "+conId+"입니다.</h3>");
		
		response.getWriter().println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
