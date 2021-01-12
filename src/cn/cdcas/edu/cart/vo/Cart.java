package cn.cdcas.edu.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * 
 */
public class Cart implements Serializable{
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	private double total;

	public double getTotal() {
		return total;
	}

	public void addCart(CartItem cartItem) {

		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			// 存在
			CartItem _cartItem = map.get(pid);// 获得购物车中原来的购物项
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			// 不存在
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}

	public void removeCart(Integer pid) {
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}

	public void clearCart() {
		map.clear();
		total = 0;
	}
}
