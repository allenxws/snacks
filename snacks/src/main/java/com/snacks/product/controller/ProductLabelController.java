package com.snacks.product.controller;

import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.product.response.AppListProductLabelResponse;
import com.snacks.product.service.AppLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuwushun on 2017/4/18.
 */
@RestController
@RequestMapping("/app/label")
public class ProductLabelController {
	@Autowired
	AppLabelService appLabelService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonPhoneListResponse<AppListProductLabelResponse> list(@RequestParam("product_id") Long productId) {
		return appLabelService.list(productId);
	}
}
