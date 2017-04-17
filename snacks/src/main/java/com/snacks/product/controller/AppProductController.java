package com.snacks.product.controller;

import com.snacks.common.controller.BaseSSOController;
import com.snacks.common.response.CommonPhoneListResponse;
import com.snacks.common.response.CommonResponse;
import com.snacks.product.request.AppListActivityProductRequest;
import com.snacks.product.request.AppListCommentRequest;
import com.snacks.product.response.AppGetProductDetailResponse;
import com.snacks.product.response.AppGetProductInfoResponse;
import com.snacks.product.response.AppListActivityProductResponse;
import com.snacks.product.response.AppListCommentResponse;
import com.snacks.product.service.AppProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by xuwushun on 2017/4/12.
 */
@RestController
@RequestMapping(value = "/app/produt")
public class AppProductController extends BaseSSOController {
	@Autowired
	AppProductService appProductService;

	@RequestMapping(value = "/listActivityProduct", method = RequestMethod.POST)
	public CommonPhoneListResponse<AppListActivityProductResponse> listActivityProduct(@RequestBody @Valid AppListActivityProductRequest appListActivityProductRequest) {
		return appProductService.listActivityProduct(appListActivityProductRequest);
	}

	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public CommonResponse<AppGetProductDetailResponse> getDetail(@RequestParam("id") Long id) {
		return appProductService.getDetail(id);
	}

	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public CommonResponse<AppGetProductInfoResponse> getInfo(@RequestParam("id") Long id) {
		return appProductService.getInfo(id);
	}

	@RequestMapping(value = "/listComment", method = RequestMethod.POST)
	public CommonPhoneListResponse<AppListCommentResponse> listComment(@RequestBody @Valid AppListCommentRequest appListCommentRequest){
		return appProductService.listComment(appListCommentRequest);
	}
}
