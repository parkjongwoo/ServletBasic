package member.listener;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {
	
	/**
	 * 서버 실행시 호출되는 이벤트 리스너 메소드
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = 
				sce.getServletContext();
		Map<String,String> countries = 
				new HashMap<String,String>();
		
		countries.put("kr", "대한민국");
		countries.put("us", "미국");
		
		servletContext.setAttribute("countries", countries);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
