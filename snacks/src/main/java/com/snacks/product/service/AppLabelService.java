package com.snacks.product.service;

import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.product.aggregate.ProductLabelServiceRoot;
import com.snacks.product.convertor.ProductLabelConvertor;
import com.snacks.product.domain.ProductLabel;
import com.snacks.product.response.AppListProductLabelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
@Service
public class AppLabelService {
	@Autowired
	ProductLabelServiceRoot productLabelServiceRoot;

	public CommonPhoneListResponse<AppListProductLabelResponse> list(Long productId) {
		List<ProductLabel> productLabels = productLabelServiceRoot.listAllByProductId(productId);
		List<AppListProductLabelResponse> appListProductLabelResponses = ProductLabelConvertor.convertToAppListProductLabelResponses(productLabels);
		return new CommonPhoneListResponse<>(appListProductLabelResponses);
	}
}
