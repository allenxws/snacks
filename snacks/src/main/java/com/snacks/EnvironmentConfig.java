package com.snacks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by xuwushun on 2016/12/16.
 */
@Configuration
@PropertySource("classpath:environment.properties")
public class EnvironmentConfig {
	@Value("${current.environment}")
	private String environment;

	@Bean
	public Properties environmentClient() throws IOException {
		Properties properties = new Properties();
		InputStream inputStream;
		if (environment.equals("dev")) {
			inputStream = getClass().getResourceAsStream("/environment/dev.properties");
		} else if (environment.equals("test")) {
			inputStream = getClass().getResourceAsStream("/environment/test.properties");
		} else {
			inputStream = getClass().getResourceAsStream("/environment/product.properties");
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
		properties.load(bufferedReader);
		inputStream.close();
		return properties;
	}
}
