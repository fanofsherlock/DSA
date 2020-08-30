package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class AutomationGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long automationGoalId;

	@Column
	private String automationGoalName;

	public Long getAutomationGoalId() {
		return automationGoalId;
	}

	public void setAutomationGoalId(Long automationGoalId) {
		this.automationGoalId = automationGoalId;
	}

	public String getAutomationGoalName() {
		return automationGoalName;
	}

	public void setAutomationGoalName(String automationGoalName) {
		this.automationGoalName = automationGoalName;
	}

}
