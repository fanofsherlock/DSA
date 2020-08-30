package com.nissan.assessment.dto;

public class IdeaUpdateRequest {

	private String ideaId;

	private Long ideaStatus;

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

	public Long getIdeaStatus() {
		return ideaStatus;
	}

	public void setIdeaStatus(Long ideaStatus) {
		this.ideaStatus = ideaStatus;
	}

}
