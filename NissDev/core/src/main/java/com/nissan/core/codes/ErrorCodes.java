package com.nissan.core.codes;

public enum ErrorCodes implements StatusCodes {
	GENERIC(20000000, "Generic exception"), MISSING_FIELDS(20000001, "Missing required data or invalid data provided:"),
	UI_ORCHESTRATOR_FAILURE(20000002, "UI Orchestrator is down, please try again"),
	ASSESSMENT_EXCEPTION(20000003, "ARS error: Unable to obtain requested store's license"),LOGIN_FAILED(20000004, "Login Failed");

	private Integer code;
	private String description;

	private ErrorCodes(Integer code, String description) {
		this.setCode(code);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
