package com.snacks.product.convertor;

import com.google.common.collect.Lists;
import com.snacks.product.domain.ProductLabel;
import com.snacks.product.response.AppListProductLabelResponse;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xuwushun on 2017/4/18.
 */
public class ProductLabelConvertor {
	public static AppListProductLabelResponse convertToAppListProductLabelResponse(ProductLabel productLabel) {
		AppListProductLabelResponse appListProductLabelResponse = new AppListProductLabelResponse();
		if (null == productLabel) {
			return appListProductLabelResponse;
		}
		appListProductLabelResponse.setId(productLabel.getId());
		appListProductLabelResponse.setLabelName(productLabel.getLabelName());
		return appListProductLabelResponse;
	}

	public static List<AppListProductLabelResponse> convertToAppListProductLabelResponses(List<ProductLabel> productLabels) {
		List<AppListProductLabelResponse> appListProductLabelResponses = Lists.newArrayList();
		if (CollectionUtils.isEmpty(productLabels)) {
			return appListProductLabelResponses;
		}
		for (ProductLabel productLabel : productLabels) {
			appListProductLabelResponses.add(convertToAppListProductLabelResponse(productLabel));
		}
		return appListProductLabelResponses;
	}
}
