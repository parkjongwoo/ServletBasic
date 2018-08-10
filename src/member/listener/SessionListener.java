package member.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 리스너는 각 서블릿 컨테이너의 상황별 이벤트에 맞춰 실행되는 객체. 필요한 시기에 코드 실행이 가능하다.
 * @author goott3-4
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext =
				sce.getServletContext();
		servletContext.setAttribute("userCount", new AtomicInteger());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		AtomicInteger userCounter = (AtomicInteger)se.getSession().getServletContext().getAttribute("userCount");
		int userCount = userCounter.incrementAndGet();
		System.out.println("세션 시작_현재 접속 세션 수:"+userCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger userCounter = (AtomicInteger)se.getSession().getServletContext().getAttribute("userCount");
		int userCount = userCounter.decrementAndGet();
		System.out.println("세션 종료_현재 접속 세션 수:"+userCount);
	}
}
