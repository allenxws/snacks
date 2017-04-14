package com.snacks.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by xuwushun on 2017/4/5.
 */
@Service
public class MailService {
	@Autowired
	@Qualifier(value = "mailClient")
	JavaMailSenderImpl javaMailSender;
	Logger logger = LoggerFactory.getLogger(getClass());

	public void sentMail(String subject, String content, String... receiver) {
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = null;
		try {
			mimeMessageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			mimeMessageHelper.setTo(receiver);
			mimeMessageHelper.setFrom(javaMailSender.getUsername());
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content);
			javaMailSender.send(mailMessage);
		} catch (MessagingException e) {
			logger.debug("send mail error, receiver=" + receiver + ", subject=" + subject + ",content=" + content, e);
		}
	}
}
