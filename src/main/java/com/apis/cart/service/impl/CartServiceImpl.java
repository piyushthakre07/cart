package com.apis.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apis.cart.dao.ICartDao;
import com.apis.cart.service.ICartService;
import com.beans.CartBean;
import com.beans.CommonResponseBean;
import com.google.gson.Gson;
import com.model.CartMaster;
import com.model.ProductMaster;
import com.model.UserMaster;
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartDao cartDao;

	@Autowired
	RestTemplate restTemplate;
	/**
	 * @author piyusht4
	 * @since 24-04-2019
	 */
	@Override
	public String addToCart(CartBean cartBean) {
		CartMaster cart = new CartMaster();
		if (cartBean.getProductId() == null || cartBean.getUserId() == null || cartBean.getQuantity() == null) {
			return new Gson().toJson(new CommonResponseBean("Invalid Request", "0", "ERROR501"));
		}
		try {
			String url = "http://localhost:8092/fetchbyproductid/"+cartBean.getProductId();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<String>("{}",headers);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
			
			String json = response.getBody();
			System.out.println("JSON :: "+json);
			//return json;
			ProductMaster productMaster = new ProductMaster();
			productMaster.setProductId(cartBean.getProductId());
			
			cart.setProductMaster(productMaster);
			UserMaster user = new UserMaster();
			user.setUserId(cartBean.getUserId());
			cart.setUserMaster(user);
			cart.setQuantity(cartBean.getQuantity());
			cart.setIsActive(true);
			String response1 = cartDao.addToCart(cart);
			return response1;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR001"));
		}
	}

	/**
	 * @author piyusht4
	 * @since 24-04-2019
	 */
	@Override
	public String removeFromCart(CartBean cartBean) {
		if (cartBean.getCartId() == null) {
			return new Gson().toJson(new CommonResponseBean("Invalid Request", "0", "ERROR501"));
		}
		try {
			CartMaster cartMaster=cartDao.fetchCartById(cartBean.getCartId());
			if(cartMaster==null) {
				return new Gson().toJson(new CommonResponseBean("Cart Id not Exist", "0", "ERROR501"));
			}
			cartMaster.setIsActive(false);
			String response = cartDao.updateCart(cartMaster);
			return response;
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error while processing", "0", "ERROR001"));
		}
	}
}
