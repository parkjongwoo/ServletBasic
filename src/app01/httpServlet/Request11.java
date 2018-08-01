package app01.httpServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request11
 */
@WebServlet(name = "request11", urlPatterns = { "/request11" })
public class Request11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().println("<!doctype html><html><head><meta charset='utf-8'></head><body>");		
		response.getWriter().println("Served at: "+request.getContextPath()+"<br>\n");
		System.out.println("Request11 doGet 호출");
		
		String requestInfo =  String.valueOf(request.getAttribute("requestInfo"));
		response.getWriter().println("attribute delivered: requestInfo: "+requestInfo+"<br>\n");	
		ArrayList<Integer> list = (ArrayList<Integer>)request.getAttribute("dataList");
		for(Integer i:list) {
			response.getWriter().println("attribute delivered: dataList: "+i.toString()+"<br>\n");			
		}
		response.getWriter().println("dataList sum:"+sum(list)+"<br>\n");
		response.getWriter().println("dataList avg:"+avg(list)+"<br>\n");		
		response.getWriter().println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Request11 doPost 호출");
		doGet(request, response);
	}
	
	private int sum(ArrayList<Integer> list) {
		int sum=0;
		for(int i:list) {
			sum+=i;
		}
		return sum;
	}
	
	private double avg(ArrayList<Integer> list) {
		double avg = 0.0;
		avg=Math.round(((double)sum(list)/list.size()*100))/100;
		return avg;
	}
}
