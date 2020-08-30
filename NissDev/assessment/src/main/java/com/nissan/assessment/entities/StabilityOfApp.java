package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class StabilityOfApp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long stabilityOfAppId;

	@Column
	private String stabilityOfAppDesc;

	public Long getStabilityOfAppId() {
		return stabilityOfAppId;
	}

	public void setStabilityOfAppId(Long stabilityOfAppId) {
		this.stabilityOfAppId = stabilityOfAppId;
	}

	public String getStabilityOfAppDesc() {
		return stabilityOfAppDesc;
	}

	public void setStabilityOfAppDesc(String stabilityOfAppDesc) {
		this.stabilityOfAppDesc = stabilityOfAppDesc;
	}

}
