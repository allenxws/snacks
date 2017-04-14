package com.snacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by xuwushun on 2017/3/19.
 */
@Configuration
@ComponentScan(basePackages = "com.snacks")
public class AppConfig {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public Properties messageClient() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getResourceAsStream("/messages/Messages.properties");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			properties.load(bufferedReader);
			inputStream.close();
		} catch (IOException e1) {
			logger.debug("get message properties error", e1);
		}
		return properties;
	}

	@Bean
	public JavaMailSenderImpl mailClient() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setUsername("1471132931@qq.com");
		javaMailSender.setPassword("xwtidjohqudwfghd");
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.qq.com");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.timeout", "2000");
		properties.setProperty("mail.smtp.auth", "true");
		javaMailSender.setJavaMailProperties(properties);
		return javaMailSender;
	}
}
