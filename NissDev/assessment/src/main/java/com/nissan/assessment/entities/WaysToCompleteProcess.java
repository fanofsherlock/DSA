package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class WaysToCompleteProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long waysToCompletePrcsId;

	@Column
	private String waysToCompletePrcsDesc;

	public Long getWaysToCompletePrcsId() {
		return waysToCompletePrcsId;
	}

	public void setWaysToCompletePrcsId(Long waysToCompletePrcsId) {
		this.waysToCompletePrcsId = waysToCompletePrcsId;
	}

	public String getWaysToCompletePrcsDesc() {
		return waysToCompletePrcsDesc;
	}

	public void setWaysToCompletePrcsDesc(String waysToCompletePrcsDesc) {
		this.waysToCompletePrcsDesc = waysToCompletePrcsDesc;
	}

}
