package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class DeploymentTollGateCheckListIdeaReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long checklistReviewId;

	@OneToOne
	@JoinColumn(name = "checklistItemId", referencedColumnName = "checklistItemId")
	private DeploymentTollGateChecklist tollGateCheckList;

	@OneToOne
	@JoinColumn(name = "ideaId", referencedColumnName = "ideaId")
	private Idea idea;

	@Column
	private boolean checklistReviewStatus;

	@Column
	private String checklistReviewDescription;

	public Long getChecklistReviewId() {
		return checklistReviewId;
	}

	public void setChecklistReviewId(Long checklistReviewId) {
		this.checklistReviewId = checklistReviewId;
	}

	public DeploymentTollGateChecklist getTollGateCheckList() {
		return tollGateCheckList;
	}

	public void setTollGateCheckList(DeploymentTollGateChecklist tollGateCheckList) {
		this.tollGateCheckList = tollGateCheckList;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
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
