package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class AutomationArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long automationAreaId;

	@Column
	private String automationAreaName;

	public Long getAutomationAreaId() {
		return automationAreaId;
	}

	public void setAutomationAreaId(Long automationAreaId) {
		this.automationAreaId = automationAreaId;
	}

	public String getAutomationAreaName() {
		return automationAreaName;
	}

	public void setAutomationAreaName(String automationAreaName) {
		this.automationAreaName = automationAreaName;
	}

}
