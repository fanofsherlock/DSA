package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class PhaseDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long phaseDocId;

	@ManyToOne
	@JoinColumn(name = "phaseId", referencedColumnName = "phaseId")
	private Phase phaseDetails;

	@ManyToOne
	@JoinColumn(name = "docId", referencedColumnName = "docId")
	private Document documentDetails;

	public Long getPhaseDocId() {
		return phaseDocId;
	}

	public void setPhaseDocId(Long phaseDocId) {
		this.phaseDocId = phaseDocId;
	}

	public Phase getPhaseDetails() {
		return phaseDetails;
	}

	public void setPhaseDetails(Phase phaseDetails) {
		this.phaseDetails = phaseDetails;
	}

	public Document getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(Document documentDetails) {
		this.documentDetails = documentDetails;
	}

}
