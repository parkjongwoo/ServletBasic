package app01.httpServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DB에서 값을 얻어와 반환해줄 일을 하는 서블릿
 */
@WebServlet(name="request10", urlPatterns = { "/request10" })
public class Request10 extends HttpServlet {
	    
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433459242393348312L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");		
		
		System.out.println("Request10 doGet 호출");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		request.setAttribute("requestInfo", "결과값이다");
		request.setAttribute("dataList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("request11");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Request10 doPost 호출");
		doGet(request, response);
	}

}
