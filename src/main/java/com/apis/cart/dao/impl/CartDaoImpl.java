/**
 * 
 */
package com.apis.cart.dao.impl;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apis.cart.dao.ICartDao;
import com.beans.CommonResponseBean;
import com.google.gson.Gson;
import com.model.CartMaster;

/**
 * @author piyusht4
 *
 */
@Repository
public class CartDaoImpl implements ICartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public String addToCart(CartMaster cart) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(cart);
			return new Gson().toJson(new CommonResponseBean("Successfully added product to cart with ID is "+cart.getCartId(), "1", ""));
		} catch (Exception e) {
			return new Gson().toJson(new CommonResponseBean("Error", "0", "Error001"));
		}
	}
	
	 @SuppressWarnings("unchecked")
		@Override
		@Transactional
	public CartMaster fetchCartById(Long cartId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			TypedQuery<CartMaster> query = session.getNamedQuery("findCartById");
			query.setParameter("cartId", cartId);
			CartMaster cart = query.getSingleResult();
			return cart;
		} catch (Exception e) {
			return null;
		}
	}
	 

		@Transactional
		@Override
		public String updateCart(CartMaster cart) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.update(cart);
				return new Gson().toJson(new CommonResponseBean("Successfully remove product from cart", "1", ""));
			} catch (Exception e) {
				return new Gson().toJson(new CommonResponseBean("Error", "0", "Error001"));
			}
		}
}
