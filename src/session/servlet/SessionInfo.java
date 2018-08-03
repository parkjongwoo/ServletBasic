package session.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionInfo
 */
@WebServlet(name = "sessionInfo", urlPatterns = { "/sessionInfo" })
public class SessionInfo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();	
		List<String> nameList = (List<String>)session.getAttribute("nameList");
		
		if(nameList==null) {
			nameList = new ArrayList<String>();			
		}
		
		String name = request.getParameter("name");

		if(name!=null && name.trim().length()>0) {
			nameList.add(name);	
		}		
		session.setAttribute("nameList", nameList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp_session.jsp");
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
