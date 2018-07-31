package app01.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿에서 하위폴더 서블릿으로 이동 연습
 * 리다이렉트 정리
 * sendRedirect 사용시 절대경로방식 : /웹어플리케이션명/등록한urlPattern (앞에/붙임)
 * sendRedirect 사용시 상대경로방식 : 목표 서블릿에서 등록한urlPattern(/없이 작성 )
 * 주의할점: 상대경로방식 사용시 "현재"폴더 위치는 "현재"서블릿의 urlPattern이므로
 * 목표 서블릿의 urlPattern과 현재 서블릿의 urlPattern을 비교하여 호출하여야 한다.
 * 현재서블릿urlPattern: /request08/child ::::: 목표서블릿urlPattern: /request09/child 인 경우
 * ../request09/child로 지정해야 접근 가능.
 * 마지막 /밑의 값을 파일명이라고 생각하면 간단.
 * html의 action 값도 동일하게 지정하면됨. request01_childtest.html 참조. 
 * @author goott3-4
 *
 */
@WebServlet(name = "Request08_directory", urlPatterns = "/request08/directory")
public class Request08_directory extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request08_directory doGet");
//		resp.sendRedirect("../request08_response.html");//상위 폴더의 페이지로 이동
		
		resp.sendRedirect("../request09/child");//
		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("../app/test.html");
//		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		System.out.println("Request08_directory doPost");
//		resp.sendRedirect("../request08_response.html");
		
		resp.sendRedirect("../request09/child");//
	}
}
