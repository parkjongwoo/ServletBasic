package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.signin.MemberDao;
import member.dao.signin.MemberDaoImpl;
import member.model.Member;

/**
 * Servlet implementation class SigninController
 */
@WebServlet(name = "signinController", urlPatterns = { "/memberList" })
public class MemberController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDao dao = new MemberDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int actionIndex = uri.lastIndexOf("/");
		String action = uri.substring(actionIndex+1);
		
		if(action.equals("memberList")) {
			List<Member> list = dao.selectAll();
			request.setAttribute("memberList", list);
		}
		
		String requestURL = null;
		
		if(action.equals("memberList")) {
			requestURL = "/member_view/memberList.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestURL);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
