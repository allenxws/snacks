package com.snacks.order.aggregate;

import com.snacks.order.domain.ShoppingCart;
import com.snacks.order.repository.ShoppingCartServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class ShoppingCartServiceRoot {
	@Autowired
	ShoppingCartServiceDB shoppingCartServiceDB;

	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartServiceDB.addShoppingCart(shoppingCart);
	}

	public List<ShoppingCart> listAllByUserId(Long userId){
		return shoppingCartServiceDB.listAllByUserId(userId);
	}
}
