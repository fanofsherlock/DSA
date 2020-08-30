package com.nissan.core.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nissan.core.entities.SystemUser;
import com.nissan.core.repository.SystemUserRepository;

@Component
public class JWTUtil {

	@Autowired
	private SystemUserRepository systemUserRepository;

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";

	public SystemUser getUserInfo() {
		SystemUser systemUser = null;

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String userAccessToken = request.getHeader("Authorization");
		if (userAccessToken != null) {
			userAccessToken = userAccessToken.replace("bearer", "").trim();
			// parse the token.
			String userEmail = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(userAccessToken.replace(TOKEN_PREFIX, "")).getSubject();
			systemUser = systemUserRepository.findByEmailId(userEmail);
		}
		return systemUser;
	}
}
