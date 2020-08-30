
package com.nissan.core.util;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nissan.core.entities.SystemUser;


/**
 * The Class EmailUtil.
 */
@Service
public class EmailUtil {

	/** The sender. */
	@Autowired
	private JavaMailSender mailSender;

	/** The nameSpace name. */
	@Value("${smtp.mail.emailid}")
	private String emailFrom;

	/** The nameSpace name. */
	@Value("${smtp.mail.emailid}")
	private String emailFromAlias;

	@Async
	public void sendEmail(SystemUser userObject) {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, CharEncoding.UTF_8);
			helper.setTo(userObject.getEmailId());
			helper.setFrom(emailFrom, emailFromAlias);
			helper.setText("Hi" + userObject.getEmailId(), true);
			helper.setSubject("User created successfully");
			Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
			mailSender.send(message);
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}

	}

}