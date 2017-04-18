package com.snacks.order.repository;

import com.snacks.order.dao.ShoppingCartMapper;
import com.snacks.order.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class ShoppingCartServiceDB {
	@Autowired
	ShoppingCartMapper shoppingCartMapper;

	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartMapper.addShoppingCart(shoppingCart);
	}

	public List<ShoppingCart> listAllByUserId(Long userId){
		return shoppingCartMapper.listAllByUserId(userId);
	}
}
