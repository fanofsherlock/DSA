package com.nissan.assessment.dto;

public class ApplicationDto {

	private String applicationName;

	private String versionNo;

	private String language;

	private Boolean thinClient;

	private Integer feasibilityScore;

	private String comments;

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
