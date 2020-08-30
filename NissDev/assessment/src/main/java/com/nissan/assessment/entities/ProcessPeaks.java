package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ProcessPeaks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Process_Peek_id", updatable = false, nullable = false)
	private Long processPeekId;

	@Column(name = "Process_Peek_Details")
	private String processPeekDetails;

	public Long getProcessPeekId() {
		return processPeekId;
	}

	public void setProcessPeekId(Long processPeekId) {
		this.processPeekId = processPeekId;
	}

	public String getProcessPeekDetails() {
		return processPeekDetails;
	}

	public void setProcessPeekDetails(String processPeekDetails) {
		this.processPeekDetails = processPeekDetails;
	}

}
