package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ProcessFrequency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long freqId;

	@Column
	private String freqDesc;

	public Long getFreqId() {
		return freqId;
	}

	public void setFreqId(Long freqId) {
		this.freqId = freqId;
	}

	public String getFreqDesc() {
		return freqDesc;
	}

	public void setFreqDesc(String freqDesc) {
		this.freqDesc = freqDesc;
	}

}
