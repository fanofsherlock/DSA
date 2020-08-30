package com.nissan.core.dto;

import com.nissan.core.codes.SuccessCodes;

public class SuccessStatus extends Status {

	public SuccessStatus(SuccessCodes statusCode) {
		super.statusId = statusCode.getCode();
		super.description = statusCode.getDescription();
	}
}
