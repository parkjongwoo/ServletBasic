package app01.httpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2.0버전 방식 서블릿 매핑. 어노테이션 대신 web.xml에 servlet,servlet-mapping 추가
 */
//@WebServlet(name = "request14", urlPatterns = { "/request14" })
public class Request14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("init param name: ").append(getInitParameter("name"));
		response.getWriter().append("init param email: ").append(getInitParameter("email"));
		response.getWriter().append("context param myContextParam: ").append(getServletContext().getInitParameter("myContextParam"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
