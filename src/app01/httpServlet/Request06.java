package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "request06", urlPatterns = "/request06")
public class Request06 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request06 doGet");

//		req.getParameter(name)
		req.setAttribute("addedPara", "createdParam");//파라메터 추가방법 못찾고 애트리뷰트로 추가. 애트리뷰트는 리퀘스트,세션,컨텍스트 등 위치별로 있음
		RequestDispatcher dispatcher = req.getRequestDispatcher("request01");//
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request06 doPost");

//		req.getParameter(name)
		req.setAttribute("addedPara", "createdParam");//파라메터 추가방법 못찾고 애트리뷰트로 추가
		RequestDispatcher dispatcher = req.getRequestDispatcher("request01");//
		
		dispatcher.forward(req, resp);
	}
}
