package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class NoOfInputFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long noOfInputFieldsId;

	@Column
	private String noOfInputFieldsDesc;

	public Long getNoOfInputFieldsId() {
		return noOfInputFieldsId;
	}

	public void setNoOfInputFieldsId(Long noOfInputFieldsId) {
		this.noOfInputFieldsId = noOfInputFieldsId;
	}

	public String getNoOfInputFieldsDesc() {
		return noOfInputFieldsDesc;
	}

	public void setNoOfInputFieldsDesc(String noOfInputFieldsDesc) {
		this.noOfInputFieldsDesc = noOfInputFieldsDesc;
	}

}
