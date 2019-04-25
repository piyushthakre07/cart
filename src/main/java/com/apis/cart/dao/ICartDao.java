package com.apis.cart.dao;

import com.model.CartMaster;

public interface ICartDao {

	String addToCart(CartMaster cart);

	CartMaster fetchCartById(Long cartId);

	String updateCart(CartMaster cart);

}
