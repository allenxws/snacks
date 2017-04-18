package com.snacks.order.controller;

import com.snacks.common.controller.BaseSSOController;
import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.common.response.CommonResponse;
import com.snacks.order.request.AppAddProductToCartRequest;
import com.snacks.order.response.AppListCartProductResponse;
import com.snacks.order.service.AppShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xuwushun on 2017/4/18.
 */
@RestController
@RequestMapping("/app/shoppingCart")
public class AppShoppingCartController extends BaseSSOController {
	@Autowired
	AppShoppingCartService appShoppingCartService;

	@RequestMapping(value = "/addProduct", method = RequestMethod.PUT)
	public CommonResponse addProduct(@RequestBody @Valid AppAddProductToCartRequest appAddProductToCartRequest) {
		return appShoppingCartService.addProduct(appAddProductToCartRequest);
	}

	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	public CommonPhoneListResponse<AppListCartProductResponse> listProduct(){
		return appShoppingCartService.listProduct();
	}
}
