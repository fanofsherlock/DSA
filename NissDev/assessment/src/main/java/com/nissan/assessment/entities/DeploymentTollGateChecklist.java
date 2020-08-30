package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class DeploymentTollGateChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long checklistItemId;

	@Column
	private String checklistItemLabel;

	public Long getChecklistItemId() {
		return checklistItemId;
	}

	public void setChecklistItemId(Long checklistItemId) {
		this.checklistItemId = checklistItemId;
	}

	public String getChecklistItemLabel() {
		return checklistItemLabel;
	}

	public void setChecklistItemLabel(String checklistItemLabel) {
		this.checklistItemLabel = checklistItemLabel;
	}

}
