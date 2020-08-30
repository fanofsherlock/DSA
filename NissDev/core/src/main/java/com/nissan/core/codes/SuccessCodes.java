package com.nissan.core.codes;

public enum SuccessCodes implements StatusCodes {
	
	GENERIC(20000000, "Success");

	private Integer code;
	private String description;

	private SuccessCodes(Integer code, String description) {
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
