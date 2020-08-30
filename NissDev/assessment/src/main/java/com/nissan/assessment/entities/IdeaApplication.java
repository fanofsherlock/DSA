package com.nissan.assessment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class IdeaApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long ideaAppId;

	@Column
	private String applicationName;

	@Column
	private String versionNo;

	@Column
	private String language;

	@Column
	private Boolean thinClient;

	@Column
	private Integer feasibilityScore;

	@Column
	private String comments;

	public Long getIdeaAppId() {
		return ideaAppId;
	}

	public void setIdeaAppId(Long ideaAppId) {
		this.ideaAppId = ideaAppId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getThinClient() {
		return thinClient;
	}

	public void setThinClient(Boolean thinClient) {
		this.thinClient = thinClient;
	}

	public Integer getFeasibilityScore() {
		return feasibilityScore;
	}

	public void setFeasibilityScore(Integer feasibilityScore) {
		this.feasibilityScore = feasibilityScore;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
