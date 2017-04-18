package com.snacks.order.convertor;

import com.google.common.collect.Lists;
import com.snacks.activity.aggregate.ActivityProductServiceRoot;
import com.snacks.activity.domain.ActivityProduct;
import com.snacks.common.ThreadContextHolder;
import com.snacks.order.domain.ShoppingCart;
import com.snacks.order.request.AppAddProductToCartRequest;
import com.snacks.order.response.AppListCartProductResponse;
import com.snacks.product.aggregate.ProductLabelServiceRoot;
import com.snacks.product.aggregate.ProductServiceRoot;
import com.snacks.product.domain.Product;
import com.snacks.product.domain.ProductLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class ShoppingCartConvertor {
	@Autowired
	ProductServiceRoot productServiceRoot;
	@Autowired
	ProductLabelServiceRoot productLabelServiceRoot;
	@Autowired
	ActivityProductServiceRoot activityProductServiceRoot;

	public static ShoppingCart convertAppAddProductToCartRequest(AppAddProductToCartRequest appAddProductToCartRequest) {
		ShoppingCart shoppingCart = new ShoppingCart();
		if (null == appAddProductToCartRequest) {
			return shoppingCart;
		}
		shoppingCart.setUserId(ThreadContextHolder.getCurrentUserId());
		shoppingCart.setLabelId(appAddProductToCartRequest.getLabelId());
		shoppingCart.setProductId(appAddProductToCartRequest.getProductId());
		shoppingCart.setNumber(appAddProductToCartRequest.getNumber());
		return shoppingCart;
	}

	public AppListCartProductResponse convertToAppListCartProductResponse(ShoppingCart shoppingCart) {
		AppListCartProductResponse appListCartProductResponse = new AppListCartProductResponse();
		if (null == shoppingCart) {
			return appListCartProductResponse;
		}
		Product product = productServiceRoot.getById(shoppingCart.getProductId());
		ProductLabel productLabel = productLabelServiceRoot.getById(shoppingCart.getLabelId());
		ActivityProduct activityProduct = activityProductServiceRoot.getActiveByProductId(shoppingCart.getProductId());
		appListCartProductResponse.setProductId(shoppingCart.getProductId());
		appListCartProductResponse.setName(product.getName());
		appListCartProductResponse.setLabelName(productLabel.getLabelName());
		appListCartProductResponse.setNumber(shoppingCart.getNumber());
		appListCartProductResponse.setOldPrice(product.getPrice());
		appListCartProductResponse.setNewPrice(activityProduct.getActivityPrice());
		return appListCartProductResponse;
	}

	public List<AppListCartProductResponse> convertToAppListCartProductResponses(List<ShoppingCart> shoppingCarts) {
		List<AppListCartProductResponse> appListCartProductResponses = Lists.newArrayList();
		if (CollectionUtils.isEmpty(shoppingCarts)) {
			return appListCartProductResponses;
		}
		for (ShoppingCart shoppingCart : shoppingCarts) {
			appListCartProductResponses.add(convertToAppListCartProductResponse(shoppingCart));
		}
		return appListCartProductResponses;
	}
}
