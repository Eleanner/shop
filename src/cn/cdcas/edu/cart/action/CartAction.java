package cn.cdcas.edu.cart.action;


import org.apache.struts2.ServletActionContext;


import cn.cdcas.edu.cart.vo.Cart;
import cn.cdcas.edu.cart.vo.CartItem;
import cn.cdcas.edu.product.service.ProductService;
import cn.cdcas.edu.product.vo.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车Action
 * 
 */
public class CartAction extends ActionSupport {

	private Integer pid;
	private Integer count;
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String addCart() {
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		Cart cart = getCart();
		cart.addCart(cartItem);

		return "addCart";
	}

	public String clearCart(){
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}
	
	public String removeCart(){
		Cart cart = getCart();
		cart.removeCart(pid);
		return "removeCart";
	}
	
	public String myCart(){
		return "myCart";
	}
	
	/**
	 * 获得购物车的方法:从session中获得购物车.
	 */
	private Cart getCart() {
		Cart cart = (Cart)ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
