package com.nissan.core.dto.response;

import java.util.Map;

public class LoginResponse {

	private String token;
	
	private Map<Long, String> roles;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Map<Long, String> getRoles() {
		return roles;
	}

	public void setRoles(Map<Long, String> roles) {
		this.roles = roles;
	}
	
	
}
