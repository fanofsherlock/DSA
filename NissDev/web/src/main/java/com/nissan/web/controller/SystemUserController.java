
package com.nissan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.core.dto.RoleInfo;
import com.nissan.core.dto.UserInfo;
import com.nissan.core.dto.request.LoginRequest;
import com.nissan.core.dto.response.CommonResponse;
import com.nissan.core.dto.response.LoginResponse;
import com.nissan.core.entities.SystemUser;
import com.nissan.core.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users/")
@Api(value = "Operations pertaining to User management")
public class SystemUserController {

	@Autowired
	private SystemUserService systemUserService;

	@ApiOperation(value = "Create New User", response = List.class)
	@PostMapping(value = "/addNewUser")
	@ResponseStatus(HttpStatus.OK)
	public Object createNewUser(@RequestBody UserInfo userInfo) {
		return systemUserService.addNewUser(userInfo);
	}

	@ApiOperation(value = "Get List of Users")
	@GetMapping(value = "/getUserList")
	@ResponseStatus(HttpStatus.OK)
	public CommonResponse<List<SystemUser>> getUserList(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		return systemUserService.getAllUser(pageNo, pageSize);
	}

	@ApiOperation(value = "Update User data")
	@PostMapping(value = "/editUser")
	@ResponseStatus(HttpStatus.OK)
	public CommonResponse<SystemUser> editUser(@RequestBody UserInfo userInfo) {
		return systemUserService.updateUser(userInfo);
	}

	@ApiOperation(value = "Create role", response = List.class)
	@PostMapping(value = "/addNewRole", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public Object createRoleUser(@RequestBody RoleInfo roleInfo) {
		return systemUserService.addNewRole(roleInfo);
	}

	@ApiOperation(value = "Get roles")
	@GetMapping(value = "/getRoles", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public Object getRoles() {
		return systemUserService.getRoles();
	}

	@ApiOperation(value = "Activate User")
	@PutMapping(value = "/activateUser", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public Object activateUser(@RequestParam Long userId) {
		return systemUserService.activateUser(userId);
	}

	@ApiOperation(value = "Deactivate User")
	@PutMapping(value = "/deactivateUser", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public Object deactivateUser(@RequestParam Long userId) {
		return systemUserService.deactivateUser(userId);
	}

	@ApiOperation(value = "User Login")
	@PostMapping(value = "/login", produces = { "application/json" })
	public CommonResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		return systemUserService.login(loginRequest);
	}

}
