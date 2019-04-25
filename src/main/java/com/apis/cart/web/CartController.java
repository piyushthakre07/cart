package com.apis.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CartServiceApplication;
import com.apis.cart.service.ICartService;
import com.beans.CartBean;

/**
 * @author piyusht4
 * @since 24-04-2018
 * 
 */
@RestController
public class CartController {
	@Autowired
	ICartService cartservice;

	/**
	 * @author piyusht4
	 * @since 24-04-2019
	 * @param requestBean
	 * @return Json
	 * @purpose To add product into cart
	 */
	@RequestMapping(value = "/addToCart")
	public @ResponseBody String addToCart(@RequestBody CartBean requestBean) {
		String response = cartservice.addToCart(requestBean);
		return response;
	}
	
	/**
	 * @author piyusht4
	 * @since 24-04-2019
	 * @param requestBean
	 * @return Json
	 * @purpose To remove product from cart
	 */
	@RequestMapping(value = "/removeFromCart")
	public @ResponseBody String removeFromCart(@RequestBody CartBean requestBean) {
		String response = cartservice.removeFromCart(requestBean);
		return response;
	}
}
