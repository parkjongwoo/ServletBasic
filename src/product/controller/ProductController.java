package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.product.ProductDao;
import product.dao.product.ProductDaoImpl;
import product.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "productController", urlPatterns = { "/productList", "/productForm", "/productInsert",
		"/productUpdate", "/productDetail", "/productDelete" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao = new ProductDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastSlashIdx = uri.lastIndexOf("/");
		String action = uri.substring(lastSlashIdx + 1);
		System.out.println("action:" + action);

		if (action.equals("productList")) {
			List<Product> list = dao.selectAll();
			request.setAttribute("productList", list);
		} else if (action.equals("productForm")) {
			// 로직 없음
		} else if (action.equals("productInsert")) {
			Product p = new Product();
			p.setProductname(request.getParameter("productname"));
			p.setDescription(request.getParameter("description"));
			p.setProductprice(Integer.parseInt(request.getParameter("productprice")));
			String message = dao.insert(p) ? "상품이 등록되었습니다." : "상품등록을 실패하였습니다.";
			request.setAttribute("message", message);
		} else if (action.equals("productUpdate")) {
			Product p = new Product();
			p.setProductid(Integer.parseInt(request.getParameter("productid")));
			p.setProductname(request.getParameter("productname"));
			p.setDescription(request.getParameter("description"));
			p.setProductprice(Integer.parseInt(request.getParameter("productprice")));
			System.out.println("p:" + p);
			String message = dao.update(p) ? "상품이 변경되었습니다." : "상품변경을 실패하였습니다.";
			request.setAttribute("message", message);
		} else if (action.equals("productDetail")) {
			int productid = Integer.parseInt(request.getParameter("productid"));
			Product p = dao.selectById(productid);
			request.setAttribute("product", p);
		} else if (action.equals("productDelete")) {
			int productid = Integer.parseInt(request.getParameter("productid"));
			String message = dao.delete(productid)?"상품이 삭제되었습니다.":"상품삭제를 실패하였습니다.";
			request.setAttribute("message", message);
		}

		String dispatchingUrl = null;

		if (action.equals("productList")) {
			dispatchingUrl = "product_view/productList.jsp";
		} else if (action.equals("productForm")) {
			dispatchingUrl = "product_view/productForm.jsp";
		} else if (action.equals("productInsert")) {
			dispatchingUrl = "productList";
		} else if (action.equals("productUpdate")) {
			dispatchingUrl = "productList";
		} else if (action.equals("productDetail")) {
			dispatchingUrl = "product_view/productDetail.jsp";
		} else if (action.equals("productDelete")) {
			dispatchingUrl = "productList";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchingUrl);
		dispatcher.forward(request, response);
	}
}
