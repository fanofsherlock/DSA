package com.nissan.assessment.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.assessment.dto.IdeaUpdateRequest;
import com.nissan.assessment.dto.request.IdeaSaveRequest;
import com.nissan.assessment.dto.request.IdeaSubmitRequest;
import com.nissan.assessment.dto.response.CommonAssessmentResponse;
import com.nissan.assessment.dto.response.IdeaResponse;
import com.nissan.assessment.dto.response.SavedIdeaResponse;
import com.nissan.assessment.service.IdeaQueryService;
import com.nissan.assessment.service.IdeaUpsertService;
import com.nissan.core.dto.SuccessStatus;
import com.nissan.core.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/assessment")
@Api(value = "Idea and Assessment Management System", description = "Operations pertaining to Idea Assessment Management System")
public class IdeasController {

	private static Logger logger = LoggerFactory.getLogger(IdeasController.class);

	@Autowired
	private IdeaQueryService ideaQueryService;

	@Autowired
	private IdeaUpsertService ideaUpsertService;

	@Autowired
	private SystemUserService systemUserService;

	@ApiOperation(value = "View a list of all Ideas")
	@RequestMapping(value = "/ideas", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<IdeaResponse>> getAllIdeas() {
		logger.info("IdeasController: START : getAllIdeas");
		return ideaQueryService.ideas();

	}

	@ApiOperation(value = "Filter Ideas based on filter name and Id")
	@RequestMapping(value = "/ideas/filter", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<IdeaResponse>> filterIdeasByCriteria(
			@RequestParam String filterName, @RequestParam String filterId) {
		logger.info("IdeasController: START : filterIdeasByCriteria " + filterName + filterId);
		return ideaQueryService.ideasWithFilter(filterName, filterId);
	}

	@ApiOperation(value = "Get Status Count of All Ideas")
	@RequestMapping(value = "/ideas/count", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<Map<String, BigInteger>> getAllIdeaStausCount() {
		logger.info("IdeasController: START : getAllIdeaStausCount ");
		return ideaQueryService.ideasCount();

	}

	@ApiOperation(value = "Search a specific Idea by Idea Id")
	@RequestMapping(value = "/ideas/{ideaId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<IdeaResponse>> getIdeaById(
			@PathVariable(value = "ideaId") String ideaId) {
		logger.info("IdeasController: START : getIdeaById " + ideaId);
		return ideaQueryService.ideasById(ideaId);

	}

	@ApiOperation(value = "Get Ideas Specific to Idea Status")
	@RequestMapping(value = "/ideas/status/{statusId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<IdeaResponse>> getIdeasByStatus(
			@PathVariable(value = "statusId") Long statusId) {
		logger.info("IdeasController: START : getIdeasByStatus " + statusId);
		return ideaQueryService.ideasByStatus(statusId);
	}

	@ApiOperation(value = "Idea Submit")
	@RequestMapping(value = "/ideas/submit", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<IdeaResponse>> submitIdea(
			@RequestBody IdeaSubmitRequest ideaSubmitRequest) {

		logger.info("IdeasController: START : submitIdea ");
		return ideaUpsertService.submitIdea(ideaSubmitRequest);
	}

	@ApiOperation(value = "Idea Save as Draft")
	@RequestMapping(value = "/ideas/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<SavedIdeaResponse>> saveIdea(
			@RequestBody IdeaSaveRequest ideaSaveRequest) {
		logger.info("IdeasController: START : saveIdea ");
		return ideaUpsertService.saveIdea(ideaSaveRequest);
	}

	@ApiOperation(value = "Get last saved Idea for User")
	@RequestMapping(value = "/ideas/latestSavedIdea", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CommonAssessmentResponse<List<SavedIdeaResponse>> latestSavedIdea() {
		logger.info("IdeasController: START : latestSavedIdea ");
		return ideaUpsertService.latestSavedIdea();
	}

	@ApiOperation(value = "Update status of the Idea")
	@RequestMapping(value = "/ideas/updateIdeaStatus", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public SuccessStatus updateIdeaStatus(@RequestBody IdeaUpdateRequest ideaUpdateRequest) {
		logger.info("IdeasController: START : updateIdeaStatus ");
		return ideaUpsertService.updateIdeaStatus(ideaUpdateRequest.getIdeaId(), ideaUpdateRequest.getIdeaStatus());
	}

	@ApiOperation(value = "Get all approvers", response = List.class)
	@GetMapping(value = "/getAllApprovers", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getAllApprovers() {
		return systemUserService.getAllApprovers();
	}

	@ApiOperation(value = "Get approval list", response = List.class)
	@GetMapping(value = "/getApprovals", produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getApprovals() {
		return ideaUpsertService.getApprovals();
	}

}
