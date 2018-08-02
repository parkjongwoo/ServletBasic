package jstl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jstl.model.Dog;

/**
 * Servlet implementation class JstlTestServlet
 */
@WebServlet(name = "jstlTestServlet", urlPatterns = { "/jstlTestServlet" })
public class JstlTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<String> subjects = new ArrayList<String>();
		subjects.add("music");
		subjects.add("computer");
		subjects.add("history");
		subjects.add("english");
		request.setAttribute("subjects", subjects);
		request.setAttribute("userType", "member");
		
		Dog d = new Dog();
		request.setAttribute("dog", d);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp_jstl_usage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
