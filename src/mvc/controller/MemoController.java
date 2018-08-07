package mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.memo.MemoDao;
import mvc.dao.memo.MemoDaoImpl;
import mvc.model.Memo;

/**
 * Servlet implementation class MemoController
 */
@WebServlet(name = "memoController", urlPatterns = {"/memo_list","/memo_input","/memo_save","/memo_update","/memo_delete","/memo_detail" })
public class MemoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private MemoDao dao = new MemoDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		System.out.println("action:"+action);
		if(action.equals("memo_input")) {
			
		}else if(action.equals("memo_save")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			Memo memo = new Memo();
			memo.setName(name);
			memo.setAge(age);
			
			dao.insert(memo);
			request.setAttribute("message", "저장 되었습니다.");
			
		}else if(action.equals("memo_update")) {
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int memoid = Integer.parseInt(request.getParameter("memoid"));
			Memo memo = new Memo();
			memo.setName(name);
			memo.setAge(age);
			memo.setMemoid(memoid);
			
			dao.update(memo);
		}else if(action.equals("memo_delete")) {
			int memoid = Integer.parseInt(request.getParameter("memoid"));
			dao.delete(memoid);			
		}else if(action.equals("memo_list")) {
			List<Memo> list = dao.selectAll();
			request.setAttribute("memoList", list);
		}else if(action.equals("memo_detail")) {
			System.out.println("memo_detail.command");
			int memoid = Integer.parseInt(request.getParameter("memoid"));
			Memo memo = dao.selectByMemoid(memoid);
			request.setAttribute("memo", memo);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("memo_input")) {
			dispatcherUrl = "/mvc_view/memoForm.jsp";
		}else if(action.equals("memo_save")) {
			dispatcherUrl = "/memo_list";
		}else if(action.equals("memo_update")) {
			dispatcherUrl = "/memo_list";
		}else if(action.equals("memo_delete")) {
			dispatcherUrl = "/memo_list";
		}else if(action.equals("memo_list")) {
			dispatcherUrl = "/mvc_view/memoList.jsp";
		}else if(action.equals("memo_detail")) {			
			dispatcherUrl = "/mvc_view/memoDetail.jsp";
		}		
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(request, response);
	}

}
