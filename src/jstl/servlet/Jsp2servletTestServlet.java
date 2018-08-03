package jstl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jstl.model.Emp;

/**
 * Servlet implementation class JstlTestServlet
 */
@WebServlet(name = "jsp2servletTestServlet", urlPatterns = { "/jsp2servletTestServlet" })
public class Jsp2servletTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		printParams(request, response);
		
		HttpSession session = request.getSession();		
		Object o = session.getAttribute("emps");
		ArrayList<Emp> emps = null;
		
		if(o == null) {
			emps = new ArrayList<Emp>();
		}else {
			System.out.println("o:"+o.toString());
			try {
				emps = (ArrayList<Emp>)o;
			} catch (Exception e) {
				emps = new ArrayList<Emp>();
			}			
		}
		
		Emp d = new Emp();		
		d.setEmpno(Integer.parseInt(request.getParameter("e_empno")));
		d.setName(request.getParameter("e_empname"));
		d.setCountry(request.getParameter("e_country"));
		d.setCity(request.getParameter("e_city"));
		d.setStreet(request.getParameter("e_street"));
		emps.add(d);
		
		session.setAttribute("emps", emps);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Jsp2servlet_inputForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void printParams(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String[]> parameters = request.getParameterMap();
		Enumeration<String> names = request.getParameterNames();
		
		StringBuffer sb = new StringBuffer();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			for(int i=0;i<parameters.get(name).length;i++) {
				sb.append("요청 파라메터 "+name+"["+i+"]: "+parameters.get(name)[i]+"\n");				
			}
		}
		System.out.println(sb);
	}
}
