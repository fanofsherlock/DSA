package com.nissan.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nissan.core.codes.ErrorCodes;
import com.nissan.core.codes.SuccessCodes;
import com.nissan.core.dto.ErrorStatus;
import com.nissan.core.dto.RoleInfo;
import com.nissan.core.dto.Status;
import com.nissan.core.dto.SuccessStatus;
import com.nissan.core.dto.UserInfo;
import com.nissan.core.dto.request.LoginRequest;
import com.nissan.core.dto.response.CommonResponse;
import com.nissan.core.dto.response.LoginResponse;
import com.nissan.core.entities.Role;
import com.nissan.core.entities.SystemUser;
import com.nissan.core.repository.RoleRepository;
import com.nissan.core.repository.SystemUserRepository;
import com.nissan.core.service.SystemUserService;
import com.nissan.core.util.EmailUtil;
import com.nissan.core.util.JWTUtil;
import com.nissan.core.util.UserDtoConverter;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private EmailUtil emailUtil;

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days

	@Override
	public CommonResponse<LoginResponse> login(LoginRequest loginRequest) {
		CommonResponse<LoginResponse> commonResponse = new CommonResponse<>();
		SystemUser userEntity = systemUserRepository.findByEmailId(loginRequest.getUsername());
		Status status = null;
		if (userEntity != null && bCryptPasswordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword())) {
			String token = JWT.create().withSubject(loginRequest.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.sign(Algorithm.HMAC512(SECRET.getBytes()));
			status = new SuccessStatus(SuccessCodes.GENERIC);
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setToken("Bearer " + token);
			loginResponse.setRoles(new HashMap<>());
			commonResponse.setData(loginResponse);
		} else {
			status = new ErrorStatus(ErrorCodes.LOGIN_FAILED);
		}
		commonResponse.setStatus(status);
		return commonResponse;
	}

	@Override
	@Transactional
	public CommonResponse<SystemUser> addNewUser(UserInfo userInfo) {
		userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		SystemUser userObject = systemUserRepository.save(UserDtoConverter.getUserDomain(userInfo));
		CommonResponse<SystemUser> response = new CommonResponse<SystemUser>();
		// emailUtil.sendEmail(userObject);
		response.setData(userObject);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<List<SystemUser>> getAllUser(Integer pageNo, Integer pageSize) {
		List<SystemUser> userList = new ArrayList<SystemUser>();
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<SystemUser> pagedResult = systemUserRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			userList = pagedResult.getContent();
		}
		CommonResponse<List<SystemUser>> response = new CommonResponse<List<SystemUser>>();
		response.setData(userList);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<Role> addNewRole(RoleInfo roleInfo) {
		Role roleDomain = roleRepository.save(UserDtoConverter.getRoleDomain(roleInfo));
		CommonResponse<Role> response = new CommonResponse<Role>();
		response.setData(roleDomain);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<SystemUser> updateUser(UserInfo userInfo) {
		SystemUser systemUser = systemUserRepository.findById(userInfo.getUserId()).get();
		systemUser = systemUserRepository.save(UserDtoConverter.updateUserDomain(systemUser, userInfo));
		CommonResponse<SystemUser> response = new CommonResponse<SystemUser>();
		response.setData(systemUser);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;

	}

	@Override
	public CommonResponse<String> activateUser(Long userId) {
		systemUserRepository.activateUser(userId);
		CommonResponse<String> response = new CommonResponse<String>();
		response.setData(null);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<String> deactivateUser(Long userId) {
		systemUserRepository.deactivateUser(userId);
		CommonResponse<String> response = new CommonResponse<String>();
		response.setData(null);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<Integer> getActivationStatus(Long userId) {
		Integer status = systemUserRepository.getActivationStatus(userId);
		CommonResponse<Integer> response = new CommonResponse<Integer>();
		response.setData(status);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<List<Role>> getRoles() {
		CommonResponse<List<Role>> response = new CommonResponse<List<Role>>();
		response.setData(roleRepository.findAll());
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonResponse<List<SystemUser>> getAllApprovers() {
		CommonResponse<List<SystemUser>> response = new CommonResponse<List<SystemUser>>();
		response.setData(systemUserRepository.getAllApprovers(jwtUtil.getUserInfo().getUserId()));
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

}
