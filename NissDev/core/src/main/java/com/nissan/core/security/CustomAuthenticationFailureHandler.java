package com.nissan.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nissan.core.codes.ErrorCodes;
import com.nissan.core.dto.ErrorStatus;
import com.nissan.core.dto.response.CommonResponse;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		CommonResponse<String> commonResponse = new CommonResponse<String>();
		commonResponse.setStatus(new ErrorStatus(ErrorCodes.LOGIN_FAILED));
		response.getOutputStream().println(objectMapper.writeValueAsString(commonResponse));
	}

}
