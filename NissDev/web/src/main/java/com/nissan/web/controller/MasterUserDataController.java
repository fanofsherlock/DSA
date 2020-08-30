package com.nissan.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.core.entities.BusinessUnit;
import com.nissan.core.entities.Department;
import com.nissan.core.entities.JobTitle;
import com.nissan.core.service.MasterUserDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
@Api(value = "Operations pertaining to User management")
public class MasterUserDataController {

	@Autowired
	private MasterUserDataService masterUserDataService;

	@ApiOperation(value = "Get List of business unit", response = List.class)
	@RequestMapping(value = "/getAllBusinessUnits", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<BusinessUnit> getAllBusinessUnits() {
		return masterUserDataService.getAllBusinessUnits();
	}

	@ApiOperation(value = "Get List of Job titles", response = List.class)
	@RequestMapping(value = "/getAllJobTitles", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<JobTitle> getAllJobTitles() {
		return masterUserDataService.getAllJobTitles();
	}

	@ApiOperation(value = "Get List of Departments", response = List.class)
	@RequestMapping(value = "/getAllDepartments", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Department> getAllDepartments() {
		return masterUserDataService.getAllDepartments();
	}

}
