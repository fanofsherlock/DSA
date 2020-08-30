package com.nissan.assessment.util;

import com.nissan.assessment.dto.request.AssessmentTollGateReviewSubmitRequest;
import com.nissan.assessment.dto.request.DeploymentTollGateReviewSubmitRequest;
import com.nissan.assessment.entities.AssessmentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.AssessmentTollGateChecklist;
import com.nissan.assessment.entities.DeploymentTollGateCheckListIdeaReview;
import com.nissan.assessment.entities.DeploymentTollGateChecklist;
import com.nissan.assessment.entities.Idea;

public class TollGateReviewConvertor {

	public static AssessmentTollGateCheckListIdeaReview getAssessmentTollGateReview(
			AssessmentTollGateReviewSubmitRequest tollGateSaveRequest) {
		AssessmentTollGateCheckListIdeaReview tollGate = new AssessmentTollGateCheckListIdeaReview();

		// Setting the checkList item id
		AssessmentTollGateChecklist tcheck = new AssessmentTollGateChecklist();
		tcheck.setChecklistItemId(tollGateSaveRequest.getChecklistItemId());
		tollGate.setTollGateCheckList(tcheck);

		// Setting idea id
		Idea idea = new Idea();
		idea.setIdeaId(tollGateSaveRequest.getIdeaId());
		tollGate.setIdea(idea);

		// Setting tollGateStatus and tollGate Description

		tollGate.setChecklistReviewStatus(tollGateSaveRequest.getChecklistReviewStatus());
		tollGate.setChecklistReviewDescription(tollGateSaveRequest.getChecklistReviewDescription());

		return tollGate;
	}

	public static DeploymentTollGateCheckListIdeaReview getDeploymentTollGateReview(
			DeploymentTollGateReviewSubmitRequest tollGateSaveRequest) {

		DeploymentTollGateCheckListIdeaReview tollGate = new DeploymentTollGateCheckListIdeaReview();

		// Setting the checkList item id
		DeploymentTollGateChecklist tcheck = new DeploymentTollGateChecklist();
		tcheck.setChecklistItemId(tollGateSaveRequest.getChecklistItemId());
		tollGate.setTollGateCheckList(tcheck);

		// Setting idea id
		Idea idea = new Idea();
		idea.setIdeaId(tollGateSaveRequest.getIdeaId());
		tollGate.setIdea(idea);

		// Setting tollGateStatus and tollGate Description

		tollGate.setChecklistReviewStatus(tollGateSaveRequest.isChecklistReviewStatus());
		tollGate.setChecklistReviewDescription(tollGateSaveRequest.getChecklistReviewDescription());

		return tollGate;
	}

}
