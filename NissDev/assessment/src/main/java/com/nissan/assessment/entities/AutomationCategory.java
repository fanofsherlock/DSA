package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class AutomationCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long automationCatId;

	@Column
	private String automationCatName;

	@Column
	private Long automationAreaId;

	public Long getAutomationCatId() {
		return automationCatId;
	}

	public void setAutomationCatId(Long automationCatId) {
		this.automationCatId = automationCatId;
	}

	public String getAutomationCatName() {
		return automationCatName;
	}

	public void setAutomationCatName(String automationCatName) {
		this.automationCatName = automationCatName;
	}

	public Long getAutomationAreaId() {
		return automationAreaId;
	}

	public void setAutomationAreaId(Long automationAreaId) {
		this.automationAreaId = automationAreaId;
	}

}
