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
import mvc.form.MemoForm;
import mvc.memoerror.MemoError;
import mvc.model.Memo;
import mvc.model.page.PageGroupResult;
import mvc.model.page.PageRowResult;
import mvc.service.PageManager;
import mvc.sql.SQL;
import mvc.validator.MemoValidator;
import util.Util;

/**
 * Servlet implementation class MemoController
 */
@WebServlet(name = "memoController", urlPatterns = {"/memo_list_page","/memo_list","/memo_input_v1","/memo_input_v2","/memo_save_v1",
		"/memo_save_v2","/memo_update","/memo_delete","/memo_detail" })
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
		if(action.equals("memo_input_v1")) {
			
		}else if(action.equals("memo_input_v2")) {
			
		}else if(action.equals("memo_save_v1")) {
//			유효성검사
			MemoForm memoForm = new MemoForm();
			memoForm.setName(request.getParameter("name"));
			memoForm.setAge(request.getParameter("age"));
			
//			v1버전 error처리
			MemoValidator val = new MemoValidator();
			List<String> errors = val.validate_v1(memoForm);
			if(!errors.isEmpty()) {
				request.setAttribute("errors", errors);
				request.setAttribute("memoForm", memoForm);
			}else {
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				Memo memo = new Memo();
				memo.setName(name);
				memo.setAge(age);
				
				dao.insert(memo);
				request.setAttribute("message", "저장 되었습니다.");				
			}
		
		}else if(action.equals("memo_save_v2")) {
			
			
//			유효성검사
			MemoForm memoForm = new MemoForm();
			memoForm.setName(request.getParameter("name"));
			memoForm.setAge(request.getParameter("age"));
			
//			v2버전 error처리		
			MemoValidator val = new MemoValidator();
			MemoError error = val.validate_v2(memoForm);
			if(error.isResult()) {
				request.setAttribute("errors", error);
				request.setAttribute("memoForm", memoForm);
			}else {
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				Memo memo = new Memo();
				memo.setName(name);
				memo.setAge(age);
				
				dao.insert(memo);
				request.setAttribute("message", "저장 되었습니다.");				
			}
			
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
			int memoid = Integer.parseInt(request.getParameter("memoid"));
			Memo memo = dao.selectByMemoid(memoid);
			request.setAttribute("memo", memo);
			
		}else if(action.equals("memo_list_page")) {
			String pageNoS = request.getParameter("pageNo");			
			int pageNo = Util.isInteger(pageNoS)?Integer.parseInt(pageNoS):1;			
			PageManager pm = new PageManager(pageNo, SQL.MEMO_ALL_COUNT);
			
			PageGroupResult pageGroupResult = pm.getPageGroupResult();
			PageRowResult pageRowResult = pm.getPageRowResult(SQL.MEMO_ALL_COUNT);
			List<Memo> list = dao.select(pm);
			request.setAttribute("memoList", list);
			request.setAttribute("pageGroupResult", pageGroupResult);
			request.setAttribute("pageRowResult", pageRowResult);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("memo_input_v1")) {
			dispatcherUrl = "/mvc_view/memoForm_v1.jsp";
		}if(action.equals("memo_input_v2")) {
			dispatcherUrl = "/mvc_view/memoForm_v2.jsp";
		}else if(action.equals("memo_save_v1")) {
			if(request.getAttribute("errors") == null) {
				dispatcherUrl = "/memo_list";				
			}else {
				dispatcherUrl = "/mvc_view/memoForm_v1.jsp";
			}
		}else if(action.equals("memo_save_v2")) {
			if(request.getAttribute("errors") == null) {
				dispatcherUrl = "/memo_list";				
			}else {
				dispatcherUrl = "/mvc_view/memoForm_v2.jsp";
			}
		}else if(action.equals("memo_update")) {
			dispatcherUrl = "/memo_list";
		}else if(action.equals("memo_delete")) {
			dispatcherUrl = "/memo_list";
		}else if(action.equals("memo_list")) {
			dispatcherUrl = "/mvc_view/memoList.jsp";
		}else if(action.equals("memo_detail")) {			
			dispatcherUrl = "/mvc_view/memoDetail.jsp";
		}else if(action.equals("memo_list_page")) {
			dispatcherUrl = "/mvc_view/memoList_page.jsp";			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(request, response);
	}

}
