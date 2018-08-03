package urlManageWriting.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlManageWriting
 */
@WebServlet(name = "urlManageWriting", urlPatterns = { "/urlManageWriting" })
public class UrlManageWriting extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = request.getParameter("city");
		
		if(city !=null) {
			if("서울".equals(city)) {
				request.setAttribute("helloWord", "안녕하세요.");
			}else if("제주도".equals(city)) {
				request.setAttribute("helloWord", "혼저옵서예.");
			}			
			showCity(request, response);
		}else {
			response.sendRedirect("url01.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void showCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("url02.jsp");
		dispatcher.forward(request, response);
	}
}
