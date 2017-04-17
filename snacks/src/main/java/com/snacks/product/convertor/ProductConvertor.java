package com.snacks.product.convertor;

import com.google.common.collect.Lists;
import com.snacks.activity.domain.ActivityProduct;
import com.snacks.common.util.ListUtils;
import com.snacks.filerecord.aggregate.FileRecordServiceRoot;
import com.snacks.order.aggregate.OrderRecordServiceRoot;
import com.snacks.product.aggregate.ProductImageServiceRoot;
import com.snacks.product.aggregate.ProductServiceRoot;
import com.snacks.product.domain.Product;
import com.snacks.product.domain.ProductComment;
import com.snacks.product.domain.ProductImage;
import com.snacks.product.domain.ProductInfo;
import com.snacks.product.request.AppListActivityProductRequest;
import com.snacks.product.request.AppListCommentRequest;
import com.snacks.product.response.AppGetProductDetailResponse;
import com.snacks.product.response.AppGetProductInfoResponse;
import com.snacks.product.response.AppListActivityProductResponse;
import com.snacks.product.response.AppListCommentResponse;
import com.snacks.user.aggregate.UserServiceRoot;
import com.snacks.user.domain.User;
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
	@Autowired
	UserServiceRoot userServiceRoot;

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

	public static AppGetProductInfoResponse convertToAppGetProductInfoResponse(ProductInfo productInfo) {
		AppGetProductInfoResponse appGetProductInfoResponse = new AppGetProductInfoResponse();
		if (null == productInfo) {
			return appGetProductInfoResponse;
		}
		appGetProductInfoResponse.setBrand(productInfo.getBrand());
		appGetProductInfoResponse.setProductName(productInfo.getProductName());
		appGetProductInfoResponse.setQualityPeriod(productInfo.getQualityPeriod());
		appGetProductInfoResponse.setProduceDate(productInfo.getProduceDate());
		appGetProductInfoResponse.setVolume(productInfo.getVolume());
		appGetProductInfoResponse.setPackageWay(productInfo.getPackageWay());
		appGetProductInfoResponse.setProducePlace(productInfo.getProducePlace());
		appGetProductInfoResponse.setStorageWay(productInfo.getStorageWay());
		appGetProductInfoResponse.setTechnology(productInfo.getTechnology());
		appGetProductInfoResponse.setContainSugar(productInfo.getContainSugar());
		appGetProductInfoResponse.setIngredients(productInfo.getIngredients());
		appGetProductInfoResponse.setProducePermit(productInfo.getProducePermit());
		appGetProductInfoResponse.setBarCode(productInfo.getBarCode());
		appGetProductInfoResponse.setProductCode(productInfo.getProductCode());
		return appGetProductInfoResponse;
	}

	public static Map convertAppListCommentRequest(AppListCommentRequest appListCommentRequest) {
		Map paramMap = new HashMap();
		paramMap.put("productId", appListCommentRequest.getProductId());
		paramMap.put("boundId", appListCommentRequest.getBoundId());
		paramMap.put("pageSize", appListCommentRequest.getPageSize());
		return paramMap;
	}

	public AppListCommentResponse convertToAppListCommentResponse(ProductComment productComment) {
		AppListCommentResponse appListCommentResponse = new AppListCommentResponse();
		if (null == productComment) {
			return appListCommentResponse;
		}
		User user = userServiceRoot.getById(productComment.getUserId());
		appListCommentResponse.setHeadImage(fileRecordServiceRoot.getFileUrlById(user.getHeadId()));
		appListCommentResponse.setUserName(user.getUserName());
		appListCommentResponse.setCommentTime(productComment.getCreateTime());
		appListCommentResponse.setScore(productComment.getScore());
		appListCommentResponse.setContent(productComment.getContent());
		return appListCommentResponse;
	}

	public List<AppListCommentResponse> convertToAppListCommentResponses(List<ProductComment> productComments) {
		List<AppListCommentResponse> appListCommentResponses = Lists.newArrayList();
		if (CollectionUtils.isEmpty(productComments)) {
			return appListCommentResponses;
		}
		for (ProductComment productComment : productComments) {
			appListCommentResponses.add(convertToAppListCommentResponse(productComment));
		}
		return appListCommentResponses;
	}
}
