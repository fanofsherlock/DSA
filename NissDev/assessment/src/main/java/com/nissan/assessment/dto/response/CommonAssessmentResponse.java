package com.nissan.assessment.dto.response;

import com.nissan.core.dto.Status;

public class CommonAssessmentResponse<T> {

	private Data<T> data;

	private Status status;

	public Data<T> getData() {
		return data;
	}

	public void setData(Data<T> data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
