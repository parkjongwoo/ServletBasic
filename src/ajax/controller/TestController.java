package ajax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.dao.comment.CommentDao;
import ajax.dao.comment.CommentDaoImpl;
import ajax.model.Comment;

/**
 * Servlet implementation class TestController
 * ajax 테스트를 위한 임시 서블릿
 */
@WebServlet(name = "testController", urlPatterns = { "/comment_list","/comment_insert","/comment_delete" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommentDao dao = new CommentDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int actionIndex = uri.lastIndexOf("/");
		String action = uri.substring(actionIndex + 1);
		System.out.println("uri: " + uri + " action:" + action);
		
		if (action.equals("comment_list")) {
			List<Comment> commentList = dao.selectCommentAll();
			request.setAttribute("commentList", commentList);
		}else if (action.equals("comment_insert")) {
			Comment c = new Comment();
			c.setWriter(request.getParameter("writer"));
			c.setContent(request.getParameter("content"));
			Comment insertedComment = dao.insertAndResult(c);
			boolean result = insertedComment!=null;
			request.setAttribute("result", result);
			request.setAttribute("insertedComment", insertedComment);
			
		}else if (action.equals("comment_delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			boolean result = dao.delete(num);
			request.setAttribute("result", result);
			request.setAttribute("num", num);
		}

		String requestURL = null;

		if (action.equals("comment_list")) {
			requestURL = "/ajax_view/ajax_comment_list_response.jsp";
		}else if (action.equals("comment_insert")) {
			requestURL = "/ajax_view/ajax_comment_insert_response.jsp";
		}else if (action.equals("comment_delete")) {
			requestURL = "/ajax_view/ajax_comment_delete_response.jsp";
		}
		
		System.out.println("requestURL: "+requestURL);
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestURL);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
