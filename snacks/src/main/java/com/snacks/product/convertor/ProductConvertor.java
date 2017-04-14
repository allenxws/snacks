package com.snacks.product.convertor;

import com.google.common.collect.Lists;
import com.snacks.activity.domain.ActivityProduct;
import com.snacks.common.util.ListUtils;
import com.snacks.filerecord.aggregate.FileRecordServiceRoot;
import com.snacks.order.aggregate.OrderRecordServiceRoot;
import com.snacks.product.aggregate.ProductImageServiceRoot;
import com.snacks.product.aggregate.ProductServiceRoot;
import com.snacks.product.domain.Product;
import com.snacks.product.domain.ProductImage;
import com.snacks.product.domain.ProductInfo;
import com.snacks.product.request.AppListActivityProductRequest;
import com.snacks.product.response.AppGetProductDetailResponse;
import com.snacks.product.response.AppListActivityProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2017/4/14.
 */
@Service
public class ProductConvertor {
	@Autowired
	ProductServiceRoot productServiceRoot;
	@Autowired
	ProductImageServiceRoot productImageServiceRoot;
	@Autowired
	FileRecordServiceRoot fileRecordServiceRoot;
	@Autowired
	OrderRecordServiceRoot orderRecordServiceRoot;

	public AppListActivityProductResponse convertToAppListActivityProductResponse(ActivityProduct activityProduct) {
		AppListActivityProductResponse appListActivityProductResponse = new AppListActivityProductResponse();
		if (null == activityProduct) {
			return appListActivityProductResponse;
		}
		Product product = productServiceRoot.getById(activityProduct.getProductId());
		Long headImage = productImageServiceRoot.getHeadImageByProduct(activityProduct.getProductId());
		appListActivityProductResponse.setId(product.getId());
		appListActivityProductResponse.setName(product.getName());
		appListActivityProductResponse.setImgUrl(fileRecordServiceRoot.getFileUrlById(headImage));
		appListActivityProductResponse.setNewPrice(activityProduct.getActivityPrice());
		appListActivityProductResponse.setOldPrice(product.getPrice());
		appListActivityProductResponse.setEndTime(activityProduct.getEndTime());
		return appListActivityProductResponse;
	}

	public List<AppListActivityProductResponse> convertToAppListActivityProductResponses(List<ActivityProduct> activityProducts) {
		List<AppListActivityProductResponse> appListActivityProductResponses = Lists.newArrayList();
		if (CollectionUtils.isEmpty(activityProducts)) {
			return appListActivityProductResponses;
		}
		for (ActivityProduct activityProduct : activityProducts) {
			appListActivityProductResponses.add(convertToAppListActivityProductResponse(activityProduct));
		}
		return appListActivityProductResponses;
	}

	public static Map convertAppListActivityProductRequest(AppListActivityProductRequest appListActivityProductRequest, Long activityId) {
		Map paramMap = new HashMap();
		paramMap.put("boundId", appListActivityProductRequest.getBoundId());
		paramMap.put("pageSize", appListActivityProductRequest.getPageSize());
		paramMap.put("activityId", activityId);
		return paramMap;
	}

	public AppGetProductDetailResponse convertToAppGetProductDetailResponse(Product product, ActivityProduct activityProduct, ProductInfo productInfo, ProductImage productImage) {
		AppGetProductDetailResponse appGetProductDetailResponse = new AppGetProductDetailResponse();
		appGetProductDetailResponse.setName(product.getName());
		appGetProductDetailResponse.setHeadImage(fileRecordServiceRoot.getFileUrlById(productImage.getHeadImage()));
		appGetProductDetailResponse.setIntroduce(product.getIntroduce());
		appGetProductDetailResponse.setOrderNumber(orderRecordServiceRoot.countPayedByProductId(product.getId()));
		appGetProductDetailResponse.setRemainNumber(product.getStock());
		appGetProductDetailResponse.setDiscountPrice(activityProduct.getActivityPrice());
		appGetProductDetailResponse.setBrand(productInfo.getBrand());
		appGetProductDetailResponse.setProductName(productInfo.getProductName());
		appGetProductDetailResponse.setQualityPeriod(productInfo.getQualityPeriod());
		appGetProductDetailResponse.setProduceDate(productInfo.getProduceDate());
		appGetProductDetailResponse.setVolume(productInfo.getVolume());
		appGetProductDetailResponse.setPackageWay(productInfo.getPackageWay());
		appGetProductDetailResponse.setProducePlace(productInfo.getProducePlace());
		appGetProductDetailResponse.setContentImages(fileRecordServiceRoot.batchGetFileUrlById(ListUtils.stringToIdList(productImage.getContentImages())));
		return appGetProductDetailResponse;
	}
}
