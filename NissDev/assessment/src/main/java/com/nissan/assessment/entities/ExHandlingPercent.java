package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ExHandlingPercent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long exHandlingPercentId;

	@Column
	private String exHandlingPercentDesc;

	public Long getExHandlingPercentId() {
		return exHandlingPercentId;
	}

	public void setExHandlingPercentId(Long exHandlingPercentId) {
		this.exHandlingPercentId = exHandlingPercentId;
	}

	public String getExHandlingPercentDesc() {
		return exHandlingPercentDesc;
	}

	public void setExHandlingPercentDesc(String exHandlingPercentDesc) {
		this.exHandlingPercentDesc = exHandlingPercentDesc;
	}

}
