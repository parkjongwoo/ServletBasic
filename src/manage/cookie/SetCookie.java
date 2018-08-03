package manage.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerCookie
 */
@WebServlet(name = "setCookie", urlPatterns = { "/setCookie","/delCookie" })
public class SetCookie extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie addressCookie = new Cookie("address", "");
		addressCookie.setMaxAge(0);
		
		response.addCookie(addressCookie);
		response.sendRedirect("cookies_01.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("addr");
		//request.setAttribute("addr", addr);
		
		Cookie addressCookie = new Cookie("address", addr);
		
		response.addCookie(addressCookie);
		response.sendRedirect("cookies_01.jsp");
		//doGet(request, response);
	}

}
