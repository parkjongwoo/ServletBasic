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
import javax.servlet.http.HttpSession;

import member.dao.member.MemberDao;
import member.dao.member.MemberDaoImpl;
import member.form.MemberForm;
import member.membererror.MemberError;
import member.model.Member;
import member.validator.MemberValidator;
import mvc.memoerror.MemoError;
import mvc.model.Memo;
import mvc.validator.MemoValidator;

/**
 * Servlet implementation class SigninController
 */
@WebServlet(name = "memberController", urlPatterns = { "","/home","/memberList", "/memberForm", "/memberInput", 
		"/memberDetail", "/memberDelete","/pwRecheck","/memberUpdate","/idcheck","/login","/loginForm","/logout"})
public class MemberController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDao dao = new MemberDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int actionIndex = uri.lastIndexOf("/");
		String action = uri.substring(actionIndex+1);
		System.out.println("uri: "+uri+" action:"+action);
		
		if(action.equals("")) {
			
		}else if(action.equals("memberList")) {
			List<Member> list = dao.selectAll();
			request.setAttribute("memberList", list);
		}else if(action.equals("memberForm")) {
			
		}else if(action.equals("memberDetail")) {
			
		}else if(action.equals("home")) {
			
		}else if(action.equals("idcheck")) {
			String id = request.getParameter("memberid");
		}else if(action.equals("loginForm")) {
			
		}else if(action.equals("logout")) {
			request.getSession().removeAttribute("member");
		}
		
		String requestURL = null;
		
		if(action.equals("")) {
			requestURL = "/member_view/index.jsp";
		}else if(action.equals("memberList")) {
			requestURL = "/member_view/memberList.jsp";
		}else if(action.equals("memberForm")) {
			requestURL = "/member_view/memberForm.jsp";
		}else if(action.equals("memberDetail")) {			
			Member loginMember = (Member)request.getSession().getAttribute("member");
			
			if(loginMember != null) {
				String confirmed = String.valueOf(request.getAttribute("confirmed"));
				if("true".equals(confirmed)) {
					requestURL = "/member_view/memberDetail.jsp";
				}else {
					requestURL = "/member_view/pwRecheck.jsp";
				}				
			}else {
				requestURL = "/member_view/loginForm.jsp";
			}			
		}else if(action.equals("home")) {
			requestURL = "/member_view/index.jsp";
		}else if(action.equals("idcheck")) {
			
		}else if(action.equals("loginForm")) {
			requestURL = "/member_view/loginForm.jsp";
		}else if(action.equals("logout")) {
			requestURL = "/home";
		}
		
		System.out.println("requestURL: "+requestURL);
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestURL);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int actionIndex = uri.lastIndexOf("/");
		String action = uri.substring(actionIndex+1);
		System.out.println("uri: "+uri+" action:"+action);
		
		if(action.equals("memberInput")) {
			MemberForm form = new MemberForm();
			form.setMemberid(request.getParameter("memberid"));
			form.setPw1(request.getParameter("pw1"));
			form.setPw2(request.getParameter("pw2"));
			form.setName(request.getParameter("name"));
			form.setGender(request.getParameter("gender"));
			form.setEmail(request.getParameter("email"));
			
			MemberValidator val = new MemberValidator();
			MemberError error = val.validate(form);
			if(error.isResult()) {
				request.setAttribute("errors", error);
				request.setAttribute("memberForm", form);
				System.out.println("error:"+error);
				System.out.println("memberForm:"+form);
			}else {				
				Member member = new Member();
				member.setMemberid(request.getParameter("memberid"));
				member.setPassword(request.getParameter("pw1"));
				member.setName(request.getParameter("name"));
				member.setGender(request.getParameter("gender"));
				member.setEmail(request.getParameter("email"));
				
				dao.insert(member);
				request.setAttribute("message", "저장 되었습니다.");				
			}
		}else if(action.equals("memberList")) {
			List<Member> list = dao.selectAll();
			request.setAttribute("memberList", list);
		}else if(action.equals("memberDetail")) {			
				
		}else if(action.equals("pwRecheck")) {			
			String memberid = request.getParameter("memberid");
			String pw = request.getParameter("pw");	
			Member member = dao.getUserInfo(memberid, pw);
			if(member!=null) {
				System.out.println("pwRecheck member:"+member);
				request.setAttribute("member", member);
				request.setAttribute("confirmed", true);
			}				
		}else if(action.equals("home")) {
			
		}else if(action.equals("memberUpdate")) {
			MemberForm form = new MemberForm();
			form.setMemberid(request.getParameter("memberid"));//세션정보로 변경
			form.setPw1(request.getParameter("pw1"));
			form.setPw2(request.getParameter("pw2"));
			form.setName(request.getParameter("name"));
			form.setGender(request.getParameter("gender"));
			form.setEmail(request.getParameter("email"));
			
			MemberValidator val = new MemberValidator();
			MemberError error = val.updateValidate(form);
			if(error.isResult()) {
				request.setAttribute("errors", error);
				request.setAttribute("memberForm", form);
				System.out.println("error:"+error);
				System.out.println("memberForm:"+form);
				request.setAttribute("confirmed",true);
			}else {				
				Member member = new Member();
				member.setMemberid(request.getParameter("memberid"));
				member.setPassword(request.getParameter("pw1"));
				member.setName(request.getParameter("name"));
				member.setGender(request.getParameter("gender"));
				member.setEmail(request.getParameter("email"));
				
				dao.update(member);//TODO 미기재 회원정보 처리필요
				request.setAttribute("message", "저장 되었습니다.");				
			}
		}else if(action.equals("login")) {
			String memberid = request.getParameter("memberid");
			String pw = request.getParameter("pw");	
			Member member = dao.selecteById(memberid);
			if(member==null) {//맞지 않는 아이디
				request.setAttribute("message", "맞지않는 아이디 입니다.");
			}else {
				System.out.println("member.getPassword():"+member.getPassword()+" pw:"+pw);
				if(member.getPassword().equals(pw)) {//로그인 성공
					request.getSession().setAttribute("member", member);
					request.setAttribute("message", "로그인되었습니다.");
					
				}else {//패스워드 틀림
					request.setAttribute("message", "암호가 올바르지 않습니다.");
				}
			}			
		}
		
		String requestURL = null;
		
		if(action.equals("memberInput")) {
			if(request.getAttribute("errors")==null) 
				requestURL = "/memberList";				
			else
				requestURL = "/member_view/memberForm.jsp";
		}else if(action.equals("memberList")) {
			requestURL = "/member_view/memberList.jsp";
		}else if(action.equals("memberDetail")) {
			Member loginMember = (Member)request.getSession().getAttribute("member");
			
			if(loginMember!=null) {
				String confirmed = String.valueOf(request.getAttribute("confirmed"));
				if(!"true".equals(confirmed)) {
					confirmed = request.getParameter("confirmed");
				}
				if("true".equals(confirmed)) {
					requestURL = "/member_view/memberDetail.jsp";
				}else {
					requestURL = "/member_view/pwRecheck.jsp";
				}				
			}else {
				requestURL = "/member_view/loginForm.jsp";
			}
			
		}else if(action.equals("pwRecheck")) {		
			if(request.getAttribute("member")!=null) {							
				requestURL = "/memberDetail";				
			}else {
				requestURL = "/member_view/pwRecheck.jsp";
			}
			
		}else if(action.equals("home")) {
			requestURL = "/member_view/index.jsp";
		}else if(action.equals("memberUpdate")) {
			if(request.getAttribute("errors")==null) 
				requestURL = "/memberList";				
			else
				requestURL = "/memberDetail";			
		}else if(action.equals("login")) {
			if(request.getSession().getAttribute("member")==null) {
				requestURL = "/member_view/wellcome.jsp";
			}else {
				requestURL = "/member_view/index.jsp";
			}
		}
		
		
		System.out.println("requestURL: "+requestURL);
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestURL);
		dispatcher.forward(request, response);
	}

}
