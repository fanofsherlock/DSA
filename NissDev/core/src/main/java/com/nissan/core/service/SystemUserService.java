package com.nissan.core.service;

import java.util.List;

import com.nissan.core.dto.RoleInfo;
import com.nissan.core.dto.UserInfo;
import com.nissan.core.dto.request.LoginRequest;
import com.nissan.core.dto.response.CommonResponse;
import com.nissan.core.dto.response.LoginResponse;
import com.nissan.core.entities.SystemUser;

public interface SystemUserService {

	CommonResponse<SystemUser> addNewUser(UserInfo userInfo);

	Object addNewRole(RoleInfo roleInfo);

	CommonResponse<List<SystemUser>> getAllUser(Integer pageNo, Integer pageSize);

	CommonResponse<SystemUser> updateUser(UserInfo userInfo);

	CommonResponse<String> activateUser(Long userId);

	CommonResponse<String> deactivateUser(Long userId);

	CommonResponse<Integer> getActivationStatus(Long userId);

	Object getRoles();

	Object getAllApprovers();
	
	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	CommonResponse<LoginResponse> login(LoginRequest loginRequest);

}
