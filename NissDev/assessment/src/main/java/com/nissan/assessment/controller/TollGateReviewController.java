package com.nissan.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.assessment.dto.request.AssessmentTollGateReviewSubmitRequest;
import com.nissan.assessment.dto.request.DeploymentTollGateReviewSubmitRequest;
import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;
import com.nissan.assessment.service.TollGateReviewSubmissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/submitTollGateCheckListReview")
@Api(value = "Idea and Assessment Management System", description = "Operations pertaining to Idea Assessment Management System")
public class TollGateReviewController {

	private static Logger logger = LoggerFactory.getLogger(TollGateReviewController.class);

	@Autowired
	private TollGateReviewSubmissionService tollGateReviewSubmissionService;

	@ApiOperation(value = "Submit Assessment Toll Gate Review Data")
	@RequestMapping(value = "/assessment", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public AssessmentTollGateCheckListIdeaReview submitAssessmentTollGateReview(
			@RequestBody AssessmentTollGateReviewSubmitRequest tollGateReview) {
		logger.info("TollGateReviewController: START : submit Assessment TollGateCheckListReview ");

		return tollGateReviewSubmissionService.submitTollGateReview(tollGateReview);

	}

	@ApiOperation(value = "Submit Deployment Toll Gate Review Data")
	@RequestMapping(value = "/deployment", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public DeploymentTollGateCheckListIdeaReview submitDeploymentTollGateReview(
			@RequestBody DeploymentTollGateReviewSubmitRequest tollGateReview) {
		logger.info("TollGateReviewController: START : submit Deployment TollGateCheckListReview ");
		return tollGateReviewSubmissionService.submitTollGateReview(tollGateReview);
	}

}
