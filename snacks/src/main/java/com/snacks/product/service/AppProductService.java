package com.snacks.product.service;

import com.snacks.activity.aggregate.ActivityProductServiceRoot;
import com.snacks.activity.aggregate.ActivityServiceRoot;
import com.snacks.activity.domain.ActivityProduct;
import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.common.response.CommonResponse;
import com.snacks.product.aggregate.ProductImageServiceRoot;
import com.snacks.product.aggregate.ProductInfoServiceRoot;
import com.snacks.product.aggregate.ProductServiceRoot;
import com.snacks.product.convertor.ProductConvertor;
import com.snacks.product.domain.Product;
import com.snacks.product.domain.ProductImage;
import com.snacks.product.domain.ProductInfo;
import com.snacks.product.request.AppListActivityProductRequest;
import com.snacks.product.response.AppGetProductDetailResponse;
import com.snacks.product.response.AppListActivityProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class AppProductService {
	@Autowired
	ActivityServiceRoot activityServiceRoot;
	@Autowired
	ActivityProductServiceRoot activityProductServiceRoot;
	@Autowired
	ProductServiceRoot productServiceRoot;
	@Autowired
	ProductConvertor productConvertor;
	@Autowired
	ProductInfoServiceRoot productInfoServiceRoot;
	@Autowired
	ProductImageServiceRoot productImageServiceRoot;

	public CommonPhoneListResponse<AppListActivityProductResponse> listActivityProduct(AppListActivityProductRequest appListActivityProductRequest) {
		Long activityId = activityServiceRoot.getActiveActivityId();
		if (null == activityId) {
			return new CommonPhoneListResponse<>();
		}
		Map paramMap = ProductConvertor.convertAppListActivityProductRequest(appListActivityProductRequest, activityId);
		List<ActivityProduct> activityProducts = activityProductServiceRoot.listForApp(paramMap);
		List<AppListActivityProductResponse> appListActivityProductResponses = productConvertor.convertToAppListActivityProductResponses(activityProducts);
		return new CommonPhoneListResponse<AppListActivityProductResponse>(appListActivityProductResponses);
	}

	public CommonResponse<AppGetProductDetailResponse> getDetail(Long id) {
		Product product = productServiceRoot.getById(id);
		ActivityProduct activityProduct = activityProductServiceRoot.getById(id);
		ProductInfo productInfo = productInfoServiceRoot.getByProductId(id);
		ProductImage productImage = productImageServiceRoot.getByProductId(id);
		AppGetProductDetailResponse appGetProductDetailResponse = productConvertor.convertToAppGetProductDetailResponse(product, activityProduct, productInfo, productImage);
		return new CommonResponse<>(appGetProductDetailResponse);
	}
}
