package com.snacks.order.service;

import com.snacks.common.ThreadContextHolder;
import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.common.response.CommonResponse;
import com.snacks.order.aggregate.ShoppingCartServiceRoot;
import com.snacks.order.convertor.ShoppingCartConvertor;
import com.snacks.order.domain.ShoppingCart;
import com.snacks.order.request.AppAddProductToCartRequest;
import com.snacks.order.response.AppListCartProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class AppShoppingCartService {
	@Autowired
	ShoppingCartServiceRoot shoppingCartServiceRoot;
	@Autowired
	ShoppingCartConvertor shoppingCartConvertor;

	public CommonResponse addProduct(AppAddProductToCartRequest appAddProductToCartRequest) {
		ShoppingCart shoppingCart = ShoppingCartConvertor.convertAppAddProductToCartRequest(appAddProductToCartRequest);
		shoppingCartServiceRoot.addShoppingCart(shoppingCart);
		return new CommonResponse();
	}

	public CommonPhoneListResponse<AppListCartProductResponse> listProduct() {
		Long userId = ThreadContextHolder.getCurrentUserId();
		List<ShoppingCart> shoppingCarts = shoppingCartServiceRoot.listAllByUserId(userId);
		List<AppListCartProductResponse> appListCartProductResponses = shoppingCartConvertor.convertToAppListCartProductResponses(shoppingCarts);
		return new CommonPhoneListResponse<>(appListCartProductResponses);
	}
}
