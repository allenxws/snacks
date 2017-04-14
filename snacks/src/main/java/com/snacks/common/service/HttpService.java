package com.snacks.common.service;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwushun on 2016/12/15.
 */
@Service
public class HttpService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	HttpClientBuilder httpClientBuilder;
	@Autowired
	RequestConfig requestConfig;
	@Autowired
	JsonService jsonService;

	public String doGet(String url) throws IOException {
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		CloseableHttpResponse closeableHttpResponse = null;
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		try {
			closeableHttpResponse = closeableHttpClient.execute(httpGet);
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			}
		} finally {
			httpGet.releaseConnection();
			if (closeableHttpResponse != null) {
				closeableHttpResponse.close();
			}
		}
		return null;
	}

	public String doGet(String url, Map<String, String> paramMap) throws IOException, URISyntaxException {
		URIBuilder builder = new URIBuilder(url);
		for (String s : paramMap.keySet()) {
			builder.addParameter(s, paramMap.get(s));
		}
		return doGet(builder.build().toString());
	}

	public String doPost(String url, Map<String, String> paramMap) {
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if (paramMap != null) {
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			for (String s : paramMap.keySet()) {
				parameters.add(new BasicNameValuePair(s, paramMap.get(s)));
			}
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, Charset.forName("UTF-8"));
			httpPost.setEntity(formEntity);
		}
		CloseableHttpResponse response = null;
		try {
			response = closeableHttpClient.execute(httpPost);
			return EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			logger.debug("do http post request error, url=" + url + "param=" + jsonService.toJson(paramMap), e);
		} finally {
			httpPost.releaseConnection();
		}
		return null;
	}

	public String doPost(String url) {
		return doPost(url, null);
	}

	public String doPostJson(String url, String json) throws IOException {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
		httpPost.setEntity(stringEntity);
		CloseableHttpResponse response = null;
		try {
			response = closeableHttpClient.execute(httpPost);
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (Exception e) {
			logger.debug("do http post json error, json=" + json, e);
			return null;
		} finally {
			httpPost.releaseConnection();
			if (response != null) {
				response.close();
			}
		}
	}
}
