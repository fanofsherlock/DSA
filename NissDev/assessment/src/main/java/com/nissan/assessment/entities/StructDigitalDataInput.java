package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class StructDigitalDataInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long structDataInputId;

	@Column
	private String structDataInputDesc;

	public Long getStructDataInputId() {
		return structDataInputId;
	}

	public void setStructDataInputId(Long structDataInputId) {
		this.structDataInputId = structDataInputId;
	}

	public String getStructDataInputDesc() {
		return structDataInputDesc;
	}

	public void setStructDataInputDesc(String structDataInputDesc) {
		this.structDataInputDesc = structDataInputDesc;
	}

}
