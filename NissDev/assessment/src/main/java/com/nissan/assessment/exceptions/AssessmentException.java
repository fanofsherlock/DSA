package com.nissan.assessment.exceptions;

import com.nissan.core.codes.ErrorCodes;

/**
 * Exception to indicate error in communicating with ARS or authenticating
 * license of the requester.
 */
public class AssessmentException extends Exception {

	private static final long serialVersionUID = -7379208732890921277L;
	private String status;
	private Integer code;

	public AssessmentException(ErrorCodes errorCode) {
		super(errorCode.getDescription());
		this.setCode(errorCode.getCode());
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

}

