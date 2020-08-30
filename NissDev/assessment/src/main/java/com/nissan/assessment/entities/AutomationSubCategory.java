package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class AutomationSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long automationSubCatId;

	@Column
	private String automationSubCatName;

	@Column
	private Long automationCatId;

	public Long getAutomationSubCatId() {
		return automationSubCatId;
	}

	public void setAutomationSubCatId(Long automationSubCatId) {
		this.automationSubCatId = automationSubCatId;
	}

	public String getAutomationSubCatName() {
		return automationSubCatName;
	}

	public void setAutomationSubCatName(String automationSubCatName) {
		this.automationSubCatName = automationSubCatName;
	}

	public Long getAutomationCatId() {
		return automationCatId;
	}

	public void setAutomationCatId(Long automationCatId) {
		this.automationCatId = automationCatId;
	}

}
