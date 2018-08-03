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

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {
        "/products", "/viewProductDetails", 
        "/addToCart", "/viewCart" })
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "Bravo 32' HDTV",
                "유명 TV 제조사에서 만든 저가형 HDTV",
                159.95F));
        products.add(new Product(2, "Bravo BluRay 플레이어",
                "세련된 고급 BluRay 플레이어", 99.95F));
        products.add(new Product(3, "Bravo 스테레오 시스템",
                "iPod 플레이어가 탑재된 5 스피커 하이파이 시스템", 
                129.95F));
        products.add(new Product(4, "Bravo iPod 플레이어",
                "여러 포맷을 재생할 수 있는 iPod 플러그인",
                39.95F));
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        //요청에 따라 적절히 메소드 호출하기
    	String uri = request.getRequestURI();
        if (uri.endsWith("/products")) {
            sendProductList(response);
        } else if (uri.endsWith("/viewProductDetails")) {
            sendProductDetails(request, response);
        } else if (uri.endsWith("viewCart")) {
            showCart(request, response);
        } else if (uri.endsWith("addToCart")) {
            addToCart(request, response);
        }
    }   

	@SuppressWarnings("unchecked")
	@Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
    	
    	doGet(request,response);
    	//상품들은 구매 버튼을 누를때만 카트에 포함시켜야 하는데..
    	//그 카트의 상품들을 List<ShoppingItem>를 session에 추가해 놓는다.//List대신 Map
    	//(ShoppingItem은 product, quantity 로 이루어짐)
    	
    	//[[로직]]
    	//1.세션객체 만들기
    	//2.(List<ShoppingItem>) cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
    	//3.cart == null 경우 : List<ShoppingItem> cart를 만들어 session.setAttribute(CART_ATTRIBUTE, cart);
    	//4.cart.add(shoppingItem);
    	//5.상품목록을 화면에 출력 : sendProductList(response); 
    	

    }

    private void sendProductList(HttpServletResponse response)
            throws IOException {
    	
    	//상품목록을 화면에 보여준다.
    	//상품이름 가격 (상세정보) 
    	//"<a href='viewProductDetails?id="+ product.getId() + "'>상세 정보</a>"
    	//"<a href='viewCart'>카트 보기</a>"
    	
    	response.sendRedirect("view/viewProductList.jsp");
    }
    
    //id로 해당 Product 객체 가져오기
    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
    
    
    private void sendProductDetails(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	
    	//id를 통해 상품의 이름, 설명을 출력하고
    	//구매수량을 넣도록 하고
    	//구매 요청 => method : post, action : addToCart 값으로 요청 : doPost() 호출
    	//<a>를 이용하여 상품목록으로 이동할 수 있도록 한다. : <a href='products'>상품 목록</a>
    	RequestDispatcher dispatcher = request.getRequestDispatcher("view/productDetail.jsp");
    	dispatcher.forward(request, response);
    }

    @SuppressWarnings("unchecked")
	private void showCart(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	
    	//cart에 들어 있는 목록을 출력하는 메소드

    	//세션에 있는 카트를 가져와 카드가 null이 아니라면
    	//카드 내용을 출력한다.
    	//수량 상품 가격 수량*가격
    	//마지막 줄에 총구매 합계액을 출력한다.
    	//맨 윗줄에 상품목록으로 갈 수 있도록 링크 걸어 놓기
    	//금액 출력할때 참고: currencyFormat.format(price) 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("view/cartList.jsp");
    	dispatcher.forward(request, response);
    }
    
    @SuppressWarnings("unchecked")
	private void addToCart(HttpServletRequest request, HttpServletResponse response) {
    	String[] addedProductIds = request.getParameterValues("productId");
    	if(null == addedProductIds) return;
    	
    	HttpSession session = request.getSession();
    	List<ShoppingItem> cart = null;
    	
    	for(String id:addedProductIds) {
    		int addedProductId = Integer.parseInt(id);
    		
    		cart = (List<ShoppingItem>)session.getAttribute(CART_ATTRIBUTE);
    		//장바구니 
    		if(cart==null) {
    			cart = new ArrayList<ShoppingItem>();
    			ShoppingItem item = new ShoppingItem(getProduct(addedProductId), 1);
    			cart.add(item);
    			continue;
    		}
    		
    		boolean alreadyIsInCart = false;
    		for(ShoppingItem item:cart) {
    			if(item.getProduct().getId()==addedProductId) {
    				item.setQuantity(item.getQuantity()+1);
    				alreadyIsInCart = true;
    				break;
    			}
    		}
    		if(!alreadyIsInCart) {
    			ShoppingItem item = new ShoppingItem(getProduct(addedProductId), 1);
    			cart.add(item);
    		}    		
    	}
    	
    	session.setAttribute(CART_ATTRIBUTE, cart);
	}
}