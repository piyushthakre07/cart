package com.apis.cart.service;

import com.beans.CartBean;

public interface ICartService {
	String addToCart(CartBean cartBean);

	String removeFromCart(CartBean cartBean);
}
