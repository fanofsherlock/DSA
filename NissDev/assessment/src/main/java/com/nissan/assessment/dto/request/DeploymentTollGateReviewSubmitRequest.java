package com.nissan.assessment.dto.request;

public class DeploymentTollGateReviewSubmitRequest {

	private Long checklistItemId;;

	private String ideaId;

	private boolean checklistReviewStatus;

	private String checklistReviewDescription;

	public Long getChecklistItemId() {
		return checklistItemId;
	}

	public void setChecklistItemId(Long checklistItemId) {
		this.checklistItemId = checklistItemId;
	}

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

	public boolean isChecklistReviewStatus() {
		return checklistReviewStatus;
	}

	public void setChecklistReviewStatus(boolean checklistReviewStatus) {
		this.checklistReviewStatus = checklistReviewStatus;
	}

	public String getChecklistReviewDescription() {
		return checklistReviewDescription;
	}

	public void setChecklistReviewDescription(String checklistReviewDescription) {
		this.checklistReviewDescription = checklistReviewDescription;
	}

}
