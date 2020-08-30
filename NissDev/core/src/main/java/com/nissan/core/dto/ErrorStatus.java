package com.nissan.core.dto;

import com.nissan.core.codes.ErrorCodes;

public class ErrorStatus extends Status {

	public ErrorStatus(ErrorCodes status) {
		super.statusId = status.getCode();
		super.description = status.getDescription();
	}

}
