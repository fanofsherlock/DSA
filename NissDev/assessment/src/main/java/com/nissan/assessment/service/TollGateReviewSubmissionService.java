package com.nissan.assessment.service;

import com.nissan.assessment.dto.request.AssessmentTollGateReviewSubmitRequest;
import com.nissan.assessment.dto.request.DeploymentTollGateReviewSubmitRequest;
import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;

public interface TollGateReviewSubmissionService {

	AssessmentTollGateCheckListIdeaReview submitTollGateReview(AssessmentTollGateReviewSubmitRequest tollGateReview);

	DeploymentTollGateCheckListIdeaReview submitTollGateReview(DeploymentTollGateReviewSubmitRequest tollGateReview);

}
