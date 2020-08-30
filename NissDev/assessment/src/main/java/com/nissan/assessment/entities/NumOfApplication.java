package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class NumOfApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long numOfApplicationId;

	@Column
	private String numOfApplicationDesc;

	public Long getNumOfApplicationId() {
		return numOfApplicationId;
	}

	public void setNumOfApplicationId(Long numOfApplicationId) {
		this.numOfApplicationId = numOfApplicationId;
	}

	public String getNumOfApplicationDesc() {
		return numOfApplicationDesc;
	}

	public void setNumOfApplicationDesc(String numOfApplicationDesc) {
		this.numOfApplicationDesc = numOfApplicationDesc;
	}

}
