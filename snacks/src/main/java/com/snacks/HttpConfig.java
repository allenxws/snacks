package com.snacks;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

/**
 * Created by xuwushun on 2016/12/15.
 */
@Configuration
@PropertySource("classpath:http.properties")
public class HttpConfig {
	@Value("${http.maxTotal}")
	private int maxTotal;
	@Value("${http.maxPerRoute}")
	private int maxPerRoute;
	@Value("${http.connectTimeout}")
	private int connectTimeout;
	@Value("${http.connectionRequestTimeout}")
	private int connectionRequestTimeout;
	@Value("${http.socketTimeout}")
	private int socketTimeout;
	@Value("${http.maxIdleTime}")
	private int maxIdleTime;

	@Bean
	public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
		poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
		return poolingHttpClientConnectionManager;
	}

	@Bean
	public HttpClientBuilder httpClientBuilder() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager());
		return httpClientBuilder;
	}

	@Bean
	public RequestConfig requestConfig() {
		RequestConfig.Builder builder = RequestConfig.custom();
		builder.setConnectTimeout(connectTimeout);
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		builder.setSocketTimeout(socketTimeout);
		return builder.build();
	}

	@Bean
	public IdleConnectionEvictor idleConnectionEvictor() {
		return new IdleConnectionEvictor(poolingHttpClientConnectionManager(), maxIdleTime, TimeUnit.MINUTES);
	}
}
