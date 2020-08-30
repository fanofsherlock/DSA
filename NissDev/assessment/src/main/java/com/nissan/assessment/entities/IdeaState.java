package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class IdeaState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long ideaStateId;

	@Column
	private String ideaStatus;

	public Long getIdeaStateId() {
		return ideaStateId;
	}

	public void setIdeaStateId(Long ideaStateId) {
		this.ideaStateId = ideaStateId;
	}

	public String getIdeaStatus() {
		return ideaStatus;
	}

	public void setIdeaStatus(String ideaStatus) {
		this.ideaStatus = ideaStatus;
	}

}
