package app02a.httpsession.quiz;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = { "/products", "/viewProductDetails", "/addToCart",
		"/viewCart" })
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = -20L;
	private static final String CART_ATTRIBUTE = "cart";

	private List<Product> products = new ArrayList<Product>();
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	@Override
	public void init() throws ServletException {
		products.add(new Product(1, "Bravo 32' HDTV", "유명 TV 제조사에서 만든 저가형 HDTV", 159.95F));
		products.add(new Product(2, "Bravo BluRay 플레이어", "세련된 고급 BluRay 플레이어", 99.95F));
		products.add(new Product(3, "Bravo 스테레오 시스템", "iPod 플레이어가 탑재된 5 스피커 하이파이 시스템", 129.95F));
		products.add(new Product(4, "Bravo iPod 플레이어", "여러 포맷을 재생할 수 있는 iPod 플러그인", 39.95F));
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 요청에 따라 적절히 메소드 호출하기
		String uri = request.getRequestURI();
		// if (uri.endsWith("/products")) {
		// sendProductList(request, response);
		// } else if (uri.endsWith("/viewProductDetails")) {
		// sendProductDetails(request, response);
		// } else if (uri.endsWith("viewCart")) {
		// showCart(request, response);
		// } else if (uri.endsWith("addToCart")) {
		// addToCart(request, response);
		// }

		if (uri.endsWith("/viewProductDetails")) {
			sendProductDetails(request, response);
		} else if (uri.endsWith("viewCart")) {
			showCart(request, response);
		} else if (uri.endsWith("addToCart")) {
			addToCart(request, response);
		} else {
			sendProductList(request, response);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		// 상품들은 구매 버튼을 누를때만 카트에 포함시켜야 하는데..
		// 그 카트의 상품들을 List<ShoppingItem>를 session에 추가해 놓는다.//List대신 Map
		// (ShoppingItem은 product, quantity 로 이루어짐)

		// [[로직]]
		// 1.세션객체 만들기
		// 2.(List<ShoppingItem>) cart = (List<ShoppingItem>)
		// session.getAttribute(CART_ATTRIBUTE);
		// 3.cart == null 경우 : List<ShoppingItem> cart를 만들어
		// session.setAttribute(CART_ATTRIBUTE, cart);
		// 4.cart.add(shoppingItem);
		// 5.상품목록을 화면에 출력 : sendProductList(response);

	}

	private void sendProductList(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 상품목록을 화면에 보여준다.
		// 상품이름 가격 (상세정보)
		// "<a href='viewProductDetails?id="+ product.getId() + "'>상세 정보</a>"
		// "<a href='viewCart'>카트 보기</a>"
		// jsp에서 formatter쓰려면 스크립틀릿에 복사해야하는데, 대신에 el이용해서 NumberFormat 인스턴스 넘겨서 이용
		request.setAttribute("currencyFormatter", currencyFormat);
		// 상품목록 출력할 판매상품목록 전달
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/viewProductList.jsp");
		dispatcher.include(request, response);
	}

	// id로 해당 Product 객체 가져오기
	private Product getProduct(int productId) {
		for (Product product : products) {
			if (product.getId() == productId) {
				return product;
			}
		}
		return null;
	}

	private void sendProductDetails(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// id를 통해 상품의 이름, 설명을 출력하고
		// 구매수량을 넣도록 하고
		// 구매 요청 => method : post, action : addToCart 값으로 요청 : doPost() 호출
		// <a>를 이용하여 상품목록으로 이동할 수 있도록 한다. : <a href='products'>상품 목록</a>
		// 표시할 상품번호 가져오기
		String productIdS = request.getParameter("productId");
		// 상품번호 없으면
		if(productIdS==null) {
			// 상품목록으로 이동
			response.sendRedirect("products");
			return;
		}
		int productId = Integer.parseInt(productIdS);
		// 표시할 상품 정보
		request.setAttribute("product", getProduct(productId));
		// jsp에서 formatter쓰려면 스크립틀릿에 복사해야하는데, 대신에 el이용해서 NumberFormat 인스턴스 넘겨서 이용
		request.setAttribute("currencyFormatter", currencyFormat);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/viewProductDetails.jsp");
		dispatcher.include(request, response);
	}

	@SuppressWarnings("unchecked")
	private void showCart(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// cart에 들어 있는 목록을 출력하는 메소드

		// 세션에 있는 카트를 가져와 카드가 null이 아니라면
		// 카드 내용을 출력한다.
		// 수량 상품 가격 수량*가격
		// 마지막 줄에 총구매 합계액을 출력한다.
		// 맨 윗줄에 상품목록으로 갈 수 있도록 링크 걸어 놓기
		// 금액 출력할때 참고: currencyFormat.format(price)
		
		// 세션에 장바구니 내용 있는지 확인
		HttpSession session = request.getSession();
		List<ShoppingItem> cart = (List<ShoppingItem>)session.getAttribute(CART_ATTRIBUTE);
		//장바구니 비었으면 판매상품목록 페이지 표시
		if(cart == null) {
			response.sendRedirect("products");
			return;
		}
		// jsp에서 formatter쓰려면 스크립틀릿에 복사해야하는데, 대신에 el이용해서 NumberFormat 인스턴스 넘겨서 이용
		request.setAttribute("currencyFormatter", currencyFormat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/cartList.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * 장바구니에 선택한 상품 담기
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@SuppressWarnings("unchecked")
	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 담을 상품의 상품번호
		String addedProductIdS = request.getParameter("productId");
		String quantityS = request.getParameter("quantity");
		//quantity 값이 파라메터에 없는 경우 1로 처리
		quantityS = quantityS==null?"1":quantityS;
		int quantity = Integer.parseInt(quantityS);
		// 상품번호 없으면 끝
		if (null == addedProductIdS)
			return;

		// 세션
		HttpSession session = request.getSession();
		// 장바구니 목록
		List<ShoppingItem> cart = null;
		// 상품번호
		int addedProductId = Integer.parseInt(addedProductIdS);
		// 상품 가져오기
		Product addedProduct = getProduct(addedProductId);
		// 없는 상품번호면 끝
		if (addedProduct == null)
			return;

		// 장바구니 세션정보 가져오기
		cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
		// 장바구니 정보가 없으면
		if (cart == null) {
			// 새 장바구니 상품목록 생성
			cart = new ArrayList<ShoppingItem>();
		}
		// 상품이 이미 장바구니 목록에 있는지 여부
		boolean alreadyIsInCart = false;
		// 장바구니의 상품 탐색
		for (ShoppingItem item : cart) {
			// 장바구니에 같은 상품이 있으면
			if (item.getProduct().getId() == addedProductId) {
				// 기존 상품 갯수에 추가
				item.setQuantity(item.getQuantity() + quantity);
				// 이미 상품이 있음
				alreadyIsInCart = true;
				// 장바구니 탐색 종료
				break;
			}
		}
		// 장바구니에 없는 상품이라면
		if (!alreadyIsInCart) {
			// 장바구니 상품 추가
			ShoppingItem item = new ShoppingItem(addedProduct, quantity);
			cart.add(item);
		}

		// 세션에 장바구니 정보 저장
		session.setAttribute(CART_ATTRIBUTE, cart);
		// 상품목록으로 이동
		sendProductList(request, response);
	}
}