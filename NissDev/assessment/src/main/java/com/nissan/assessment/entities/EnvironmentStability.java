package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class EnvironmentStability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long envStabilityId;

	@Column(name = "Env_Stability_Desc")
	private String envStabilityDesc;

	public Long getEnvStabilityId() {
		return envStabilityId;
	}

	public void setEnvStabilityId(Long envStabilityId) {
		this.envStabilityId = envStabilityId;
	}

	public String getEnvStabilityDesc() {
		return envStabilityDesc;
	}

	public void setEnvStabilityDesc(String envStabilityDesc) {
		this.envStabilityDesc = envStabilityDesc;
	}

}
