package member.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 주소에 private 이 있으면 이 class를 실행하게 된다.
 * 로그인 정보의 유/무, 페이지 접속 권한 등을 체크한다.
 * 필터 처리가 불필요한 경우는 doFilter를 호출하여 제어를 다음 필터 또는 서블릿으로 넘긴다.
 * 필터 처리가 필요한 경우는 request객체를 이용하여 페이지 제어를 시도 한다.
 * @author goott3-4
 *
 */
@WebFilter(filterName="memberCheckFilter",urlPatterns="/private/*")
public class MemberCheckFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest)request;
		HttpSession session = hreq.getSession();
		boolean login = false;
		if(session!=null) {
			if(session.getAttribute("member")!= null) {
				login = true;
			}
		}
		
		if(login) {
			chain.doFilter(request, response);			
		}else {
			((HttpServletResponse)response).sendRedirect("loginForm");
		}
	}

	@Override
	public void destroy() {
		

	}

}
