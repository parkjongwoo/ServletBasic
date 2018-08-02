package el.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import el.model.Address;
import el.model.Employ;

@WebServlet(name="ElTestServlet",urlPatterns= {"/ElTestServlet"})
public class ElTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//1-1)Address 객체 생성 후 
		Address address = new Address();
		//객체변수 값을 set 하고
		address.setCity(req.getParameter("e_city"));
		address.setCountry(req.getParameter("e_country"));
		address.setStreetName(req.getParameter("e_street"));
		
		Employ emp = new Employ();
		emp.setAddress(address);
		emp.setId(Integer.parseInt(req.getParameter("e_empno").trim()));
		emp.setName(req.getParameter("e_empname"));
		
		Employ emp2 = new Employ();
		emp2.setAddress(address);
		emp2.setId(5588);
		emp2.setName("홍길동");
		
		//request에 생성한 Address객체를 저장
		req.setAttribute("info_emp", emp);
		
		Map<String,String> myMap = new HashMap<String,String>();
		myMap.put("china", "중국");
		myMap.put("korea", "한국");
		myMap.put("japan", "일본");
		req.setAttribute("string_map", myMap);//Map 전달 <String,String>
		
		Map<String,Employ> empMap = new HashMap<String,Employ>();
		empMap.put("one", emp);
		empMap.put("two", emp2);		
		req.setAttribute("emp_map", empMap);//Map 전달 <String, T>
		
		Employ[] empArr = {emp, emp2};
		req.setAttribute("emp_arr", empArr);//Array 전달
		
		
		List<Employ> empList = new ArrayList<Employ>();
		empList.add( emp);
		empList.add(emp2);
		req.setAttribute("emp_list", empList);//List 전달
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp_el_jstl.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
