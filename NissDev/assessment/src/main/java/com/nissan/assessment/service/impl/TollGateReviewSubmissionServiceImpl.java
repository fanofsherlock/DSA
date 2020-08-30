package com.nissan.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.assessment.dto.request.AssessmentTollGateReviewSubmitRequest;
import com.nissan.assessment.dto.request.DeploymentTollGateReviewSubmitRequest;
import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;
import com.nissan.assessment.repository.AssessmentTollGateCheckListIdeaReviewRepo;
import com.nissan.assessment.repository.DeploymentTollGateCheckListIdeaReviewRepo;
import com.nissan.assessment.service.TollGateReviewSubmissionService;
import com.nissan.assessment.util.TollGateReviewConvertor;

@Service
public class TollGateReviewSubmissionServiceImpl implements TollGateReviewSubmissionService {

	@Autowired
	AssessmentTollGateCheckListIdeaReviewRepo assessmentRepo;

	@Autowired
	DeploymentTollGateCheckListIdeaReviewRepo deploymentRepo;

	@Override
	public AssessmentTollGateCheckListIdeaReview submitTollGateReview(
			AssessmentTollGateReviewSubmitRequest tollGateReview) {
		return assessmentRepo.save(TollGateReviewConvertor.getAssessmentTollGateReview(tollGateReview));
	}

	@Override
	public DeploymentTollGateCheckListIdeaReview submitTollGateReview(
			DeploymentTollGateReviewSubmitRequest tollGateReview) {
		return deploymentRepo.save(TollGateReviewConvertor.getDeploymentTollGateReview(tollGateReview));
	}

}
